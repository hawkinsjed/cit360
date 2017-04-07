/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.GameControl;
import saveTheVillage.control.InventoryControl;
import saveTheVillage.model.Player;
import saveTheVillage.model.Item;
import saveTheVillage.control.SceneControl;
import saveTheVillage.model.Game;
import static java.lang.Integer.parseInt;


public class WeaponShopView extends View{
    
    public WeaponShopView()
    {
        super("\n"
            + "The din of steel striking steel greets you as you press open the solidly built door. As you step in, a wave of\n"
            + "barely manageable heat envelopes you. The clanging of metal stops and a massively built human man lowers an\n"
            + "equally massive looking hammer. He glares at you for a moment before putting down his hammer and then casually\n"
            + "reaches for one of the myriad weapons lying about the interior. He then spits and growls, “What do you want? \n"
            + "I a'int got all day.”"
            + "\n\n\t-----STORE----MENU-----"
            + "\n\t| B – Buy New Weapon     |"
        //  + "\n\t| S – Sell Items         |"
            + "\n\t| L – Leave Store        |"
        //  + "\n\t| R – Print Report       |"                
            + "\n\t--------------------------"
            + "\n\nPlease make a selection:");
    }
    
    
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the "
                + "Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
    
    
    @Override
    public boolean doAction(String choice, Game game) {
        
        choice = choice.toUpperCase();
        
        try{
        switch(choice){
            case "B": // List items to buy
                this.buyWeapon(game);
                break;
            case "R": // List items to sell
                this.weaponReport();
                break;                
            case "L": // Leave store
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
        }} catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return false;
    }
    
    private void buyWeapon(Game game) {
        
        //list store inventory 0 to quit 
      this.console.println("#  ITEM\t\tPRICE" );
      String itemName[]= new String[22];
   
        int i = 0;
        int totalAll = 0;   //for assignment remove this later
        Item[] items = Item.values();
        for (Item item : items){
            if (item.getAssociation()== "Weapons Shop" && item.getBuyPrice() != 0) {
              i++;  
              this.console.println(i + "  " + item.getItemName() +"\t" + item.getBuyPrice());
              totalAll += item.getBuyPrice();  //for assignment remove this later
              itemName[i]=item.getItemName();
            }
        }
        //this.console.println("To purchase all items the cost would be: $" + totalAll);  //for assignment remove this later
        this.console.println("\nWhich item would you like to buy?");
        this.console.println("\nEnter 0 to exit");
        //Prompt for user input of which item to buy
        
        int keyboardValue = 0;
        boolean valid = false;

        try{
        while(!valid)
        {
            //get the next int entered from keyboard
            try {
                keyboardValue = parseInt(this.keyboard.readLine());
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "Invalid item - Leaving shop");
                return;
            };

            int max = 21; //get number of items available

            if(keyboardValue < 0)
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }

            else if(keyboardValue == 0)
            {
                return;
            }

            else if(keyboardValue > max)  //need to get the highest item number
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }
            else if(itemName[keyboardValue] == null )
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }
            valid = true;
        }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }

        //call the buy item function from SceneControl
        this.console.println("You chose " + itemName[keyboardValue]);
        int choice = 0;
        for (Item item : items){
            if (item.getItemName().equals(itemName[keyboardValue])) choice = item.ordinal();
        }
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.buyWeapon(game.getPlayer(), Item.values()[choice]);  
        
        //Increment Time
        GameControl timeControl = new GameControl();
        timeControl.addTime(game, 15);

        return; 
        
    }
    
    private void weaponReport()
    {
        System.out.println("\n\nEnter the file path to print the weapon report.");
        String filePath = this.getInputNoMenu(); 
        InventoryControl.printWeaponReport(filePath);
    }
}

