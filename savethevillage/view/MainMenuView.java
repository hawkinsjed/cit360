/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.PlayerControl;
import saveTheVillage.control.GameControl;
import saveTheVillage.model.Game;
import saveTheVillage.model.Player;
import saveTheVillage.model.Races;
import saveTheVillage.exceptions.InventoryControlException;
import static java.lang.Integer.parseInt;


public class MainMenuView extends View
{
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public MainMenuView(){
        super("\n"
            + "\n\t-----MAIN--MENU-----"
            + "\n\t| N – New Game     |"
            + "\n\t| L – Load Game    |"
            + "\n\t| H – Help Menu    |"
            + "\n\t| Q – Quit Game    |"
            + "\n\t|---Quick-Access---|"
            + "\n\t| S - Spell List   |"  //View Spell[] class
            + "\n\t| B - Battle View  |"
            + "\n\t| W - Weapon View  |"  //Test call of WeaponsStoreView to be removed later  
            + "\n\t| K - Bank         |"
            + "\n\t| I - Inventory    |"
            + "\n\t|     Weight       |"  //Test call of BankView to be removed later 
            + "\n\t--------------------"
            + "\n\n"
            + "Please make a selection:");
    }
    
    /* ********************************************************
    DO ACTION - OVERRIDE
    ********************************************************* */
    @Override
    public boolean doAction(String choice)
    {
        choice = choice.toUpperCase();
        boolean endGame = false;
        try{
        switch(choice)
        {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // load an existing game
                this.loadGame();
                break;
            case "H": // display help menu
                this.gotoHelpMenuView();
                break;
            case "Q": // quit the game
                this.quitGame();
                endGame = true;
                break;
            
            // These are to be deleted prior to implementing final game
            
            case "S":
                this.gotoSpellList();
                break;
            case "B":
                this.gotoBattleView();
                break;
            case "W":  //To be removed later
                this.gotoWeaponShopView();
                break;
            case "K":  //To be removed later
                this.gotoBankView();
                break;
            case "I":
                this.displayWeight();
                break;
            //
            default:
                ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
        }} catch(Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        
        return endGame;
    }
    
    /* ********************************************************
    START NEW GAME
    ********************************************************* */
    private void startNewGame()
    {
        Player newPlayer;
        
        boolean playerCreated = false; //set flag to not done
        try{
        do
        {
            //prompt for and get player's choice
            String playerName = this.getPlayerName();
            Races playerRace = this.getPlayerRace();
            int playerAge = this.getPlayerAge();
            
            //Create a new player
            PlayerControl newPlayerControl = new PlayerControl();
            newPlayer = newPlayerControl.initializeNewPlayer(playerName,
                    playerRace, playerAge);   
            if (newPlayer.getName().equals("Invalid"))
            {
                ErrorView.display(this.getClass().getName(), "INVALID PLAYER");
            }
            else
            {
                this.console.println("Welcome, " + playerName + ", you have been "
                        + "born!");
                playerCreated = true;
            }
        } while (!playerCreated);
        
        //Create New Game with Player
        boolean finished = false;
        
        //Create New Game
        GameControl newGameControl = new GameControl();
        Game newGame = new Game();
        try
        {
            newGame = newGameControl.initializeNewGame(newPlayer);
        }
        catch (InventoryControlException ice)
        {
            //If exception occurs, terminate the new game
            ErrorView.display(this.getClass().getName(),ice.getMessage());
            return;
        }
            
        //Begin New Game
        GameStartView startNewGame = new GameStartView();
        startNewGame.display(newGame);
        
        finished = true;
        
        }catch(Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
    }
        
    /* ********************************************************
    GET PLAYER NAME
    ********************************************************* */
    private String getPlayerName()
    {
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid)
        {
            this.console.println("\nOkay, so what is your name?");
            value = this.keyboard.readLine(); //get the next lined entered from keyboard
            value = value.trim();
            
            if(value.length() < 1)
            {
                ErrorView.display(this.getClass().getName(),
                        "Am I to call you nothing? I don't think so, try again.");
                continue;
            }
            else if(value.length() < 2)
            {
                ErrorView.display(this.getClass().getName(),
                        "An intriguing name, but that isn't going "
                        + "to work too well here. Try something a little longer.");
                continue;
            }
            else if(value.length() > 10)
            {
                ErrorView.display(this.getClass().getName(),
                        "That is quite the long name. I don't think I can handle that.");
                continue;
            }
            valid = true;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Unable to determine your needs " + e.getMessage());
        }
        return value; //return the value entered
    }
    
    /* ********************************************************
    GET PLAYER RACE
    ********************************************************* */
    private Races getPlayerRace()
    {
        String value = null;
        Races race = Races.HUMAN;
        boolean valid = false;
        
        try{
        while(!valid)
        {
            this.console.println("\nWhich race do you relate with?\n"
                    + "\n\t----RACES----"
                    + "\n\t| H – Human |"
                    + "\n\t| E – Elf   |"
                    + "\n\t| D – Dwarf |"
                    + "\n\t-------------");
            value = this.keyboard.readLine(); //get the next lined entered from keyboard
            value = value.toUpperCase();
            value = value.trim();
            
            if(value.length() < 1)
            {
                ErrorView.display(this.getClass().getName(), "Sorry, you can't be a bodiless enitity.");
                continue;
            }
            if(value.length() > 1 || (!value.equals("H") && 
                    !value.equals("E") && !value.equals("D")))
            {
                ErrorView.display(this.getClass().getName(), "Sorry, looks like you are an alien - Please"
                    + " select a valid race");
                continue;
            }
            
            valid = true;
            switch (value)
            {
                case "H":
                    race = Races.HUMAN;
                    break;
                case "E":
                    race = Races.ELF;
                    break;
                case "D":
                    race = Races.DWARF;
                    break;
                default:
                    valid = false;
            }
        }
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(),"Unable to determine your needs " + e.getMessage());
        }
        return race; //return the value entered
    }
    
    /* ********************************************************
    GET PLAYER AGE
    ********************************************************* */
    private int getPlayerAge()
    {
        int keyboardValue = 0;
        boolean valid = false;
        
        while(!valid)
        {
            this.console.println("\nHow old is your character?"
            + "\n(Hint - Age must be between 25 and 75) ");
            
            try
            {
                keyboardValue = parseInt(this.keyboard.readLine());
                if(keyboardValue < 25)
                {
                    ErrorView.display(this.getClass().getName(), "Unfortunately, you are too young to die.");
                    continue;
                }
                else if(keyboardValue > 75)
                {
                    ErrorView.display(this.getClass().getName(), "Sorry, you might as well retire and enjoy"
                        + " your last bit of life.");
                    continue;
                }

                valid = true;
            }
            catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "ERROR:  Input must be an integer between 25"
                        + " and 75 inclusive");
            }
        }
        
        return keyboardValue; //return the value entered
    }
    
    /* ********************************************************
    LOAD GAME
    ********************************************************* */
    private void loadGame()
    {
        LoadGameView newLoadGameView = new LoadGameView();
        newLoadGameView.display();
    } 
    
    /* ********************************************************
    GO TO HELP MENU
    ********************************************************* */
    private void gotoHelpMenuView()
    {
        //Create New Help Menu
        HelpMenuView helpMenu = new HelpMenuView();
        
        //Display Help Menu
        helpMenu.display();
    }

    private void quitGame()
    {
        System.exit(0);
    }
    
    /* ********************************************************
    *********** FUNCTIONS TO DELETE ***************************
    ********************************************************* */
    /* *****************************************
        MAKE SURE TO DELETE:
        gotoGameMenuView()
    */
    
    private void gotoSpellList() {
        
        
        
    }
    
    private void displayWeight(){
        this.console.println("\nInventory Weighs: 0");
    }
    
    private void gotoBattleView()
    {
        //Create Player for Battle
        PlayerControl newPlayerControl = new PlayerControl();
        Player testPlayer = newPlayerControl.initializeNewPlayer("Test", Races.HUMAN, 30);

        //Test Battle View
        BattleView battle = new BattleView();
        battle.displayBattleView("Forest", testPlayer);
    }
    // Call WeaponStoreView   for testing remove later
    private void gotoWeaponShopView() {
        WeaponShopView weaponShop = new WeaponShopView();
        weaponShop.display();
    }
    // Call BankView   for testing remove later
    private void gotoBankView() {
        BankView bank = new BankView();
        bank.display();
    }
}
