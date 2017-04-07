/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import saveTheVillage.model.Scene;
import saveTheVillage.control.MapControl;
import saveTheVillage.control.SceneControl;
import saveTheVillage.control.InventoryControl;
import saveTheVillage.control.GameControl;
import saveTheVillage.exceptions.MapControlException;
import saveTheVillage.exceptions.InventoryControlException;
import saveTheVillage.model.Item;


public class SceneView extends View
{
    boolean defeated = false;
    
    SceneView()
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Cannot use default constructor for "
            + "SceneView");
    }
    
    SceneView(Game game)
    {
        //Start with the scene description
        String displayMessageConstruct = (game.getIsInDungeon() ? 
            game.getDungeonMap().getScene(game.getCurrentRow(), 
            game.getCurrentColumn()).getDescription() : game.getForestMap()
            .getScene(game.getCurrentRow(), game.getCurrentColumn())
            .getDescription()) + "\n\n";
        
        //Display the location
        displayMessageConstruct += "You are currently on row " + 
            (game.getCurrentRow() + 1) + ", column " + (game.getCurrentColumn() + 1) +
            ", located in the " + (game.getIsInDungeon() ? "Dungeon" : "Forest")
            + ".  What action would you like to complete?\n";
        
        //Determine the menu at the player's current location
        if (game.getIsInDungeon())
        {
            if (game.getCurrentRow() == 4 && game.getCurrentColumn() == 0)
            {
                //Show option to exit dungeon at the entrance
                displayMessageConstruct +=
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| D – Exit Dungeon    |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------";
            }
            else if ((game.getCurrentRow() == 4 && game.getCurrentColumn() == 8) 
                || (game.getCurrentRow() == 0 && game.getCurrentColumn() == 4)
                || (game.getCurrentRow() == 8 && game.getCurrentColumn() == 4))
            {
                //Option to fight boss or miniboss
                displayMessageConstruct +=
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| F - Fight Monster   |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------";
            }
            else  //Standard Dungeon Menu
            {
                displayMessageConstruct +=
                  "\n\t----BASIC--COMMANDS----"
                + "\n\t| N – Move North      |"
                + "\n\t| S – Move South      |"
                + "\n\t| E – Move East       |"
                + "\n\t| W – Move West       |"
                + "\n\t| U – Use an item     |"
                + "\n\t| G – Game Menu       |"
                + "\n\t-----------------------";
            }
        }
        else  //Forest Map
        {
            switch (game.getForestMap().getSceneArray()[game.getCurrentRow()]
                    [game.getCurrentColumn()].getName())
            {
                case "Entrance":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| D – Enter Dungeon   |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Key":
                case "Defensive":
                case "Offensive":
                case "Memento":
                case "Ring":
                case "Necklace":
                case "Toy":
                case "Tracks1":
                case "Tracks2":
                case "Tracks3":
                case "Forest":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| X – Search          |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Inn":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Inn       |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Bank":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Bank      |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Store":
                    displayMessageConstruct +=
                          "\n\t----BASIC--COMMANDS----"
                        + "\n\t| B – Enter Store     |"
                        + "\n\t| N – Move North      |"
                        + "\n\t| S – Move South      |"
                        + "\n\t| E – Move East       |"
                        + "\n\t| W – Move West       |"
                        + "\n\t| U – Use an item     |"
                        + "\n\t| C – Converse        |"
                        + "\n\t| G – Game Menu       |"
                        + "\n\t-----------------------";
                    break;
                case "Weapons":
                    displayMessageConstruct +=
                          "\n\t----BASIC---COMMANDS----"
                        + "\n\t| B – Enter Weapon Shop|"
                        + "\n\t| N – Move North       |"
                        + "\n\t| S – Move South       |"
                        + "\n\t| E – Move East        |"
                        + "\n\t| W – Move West        |"
                        + "\n\t| U – Use an item      |"
                        + "\n\t| C – Converse         |"
                        + "\n\t| G – Game Menu        |"
                        + "\n\t------------------------";
                    break;
                default:
                    displayMessageConstruct += "ERROR:  Invalid Scene";
            }
        }
        
        super.displayMessage = (displayMessageConstruct);
    }
    
    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Game as a parameter");
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        int currentRow = game.getCurrentRow();
        int currentColumn = game.getCurrentColumn();
        boolean isInDungeon = game.getIsInDungeon();
        GameControl timeControl = new GameControl();
        
        switch(choice)
        {
            //Enter a building
            case "B":
                if (isInDungeon || !((currentColumn == 2 && currentRow 
                    == 2) || (currentColumn == 2 && currentRow == 3) || 
                    (currentColumn == 3 && currentRow == 2) || (currentColumn
                    == 3 && currentRow == 3))) //If not in a town scene
                {
                    //Cannot enter a building in a dungeon
                    this.console.println("Sorry, there are no buildings around "
                        + "you to enter - try going back to town.");
                }
                else
                {
                    if (game.getForestMap().getSceneArray()[currentRow]
                        [currentColumn].getClosed())
                    {
                        ErrorView.display(this.getClass().getName(), "ERROR:  This "
                            + "building has been closed as its owner has been "
                            + "captured by the monster.\nYou can no longer use "
                            + "this building's functions.");
                    }
                    else
                    {
                    switch (game.getForestMap().getSceneArray()[currentRow]
                        [currentColumn].getName())
                    {
                        case "Inn":
                            InnView newInn = new InnView();
                            newInn.display(game);
                            break;
                        case "Bank":
                            BankView newBank = new BankView();
                            newBank.display(game);
                            break;
                        case "Store":
                            StoreView newStore = new StoreView();
                            newStore.display(game);
                            break;
                        case "Weapons":
                            WeaponShopView newWeaponShop = new WeaponShopView();
                            newWeaponShop.display(game);
                            break;
                    }
                    defeated = timeControl.timeDefeat(game);
                    }
                }
                break;
            //Head North
            case "N":
                try
                {
                    MapControl controlMap = new MapControl();
                    defeated = controlMap.movePlayer(game, game.getCurrentRow() - 1,
                        game.getCurrentColumn());
                    //Increment Time
                    defeated = timeControl.addTime(game, 15);
                }
                catch (MapControlException mce)
                {
                    ErrorView.display(this.getClass().getName(), mce.getMessage());
                }
                break;
            //Head South
            case "S":
                try
                {
                    MapControl controlMap = new MapControl();
                    defeated = controlMap.movePlayer(game, game.getCurrentRow() + 1,
                        game.getCurrentColumn());
                    //Increment Time
                    defeated = timeControl.addTime(game, 15);
                }
                catch (MapControlException mce)
                {
                    ErrorView.display(this.getClass().getName(), mce.getMessage());
                }
                break;
            //Head East
            case "E":
                try
                {
                    MapControl controlMap = new MapControl();
                    defeated = controlMap.movePlayer(game, game.getCurrentRow(),
                        game.getCurrentColumn() + 1);
                    //Increment Time
                    defeated = timeControl.addTime(game, 15);
                }
                catch (MapControlException mce)
                {
                    ErrorView.display(this.getClass().getName(), mce.getMessage());
                }
                break;
            //Head West
            case "W":
                try
                {
                    MapControl controlMap = new MapControl();
                    defeated = controlMap.movePlayer(game, game.getCurrentRow(),
                        game.getCurrentColumn() - 1);
                    //Increment Time
                    defeated = timeControl.addTime(game, 15);
                }
                catch (MapControlException mce)
                {
                    ErrorView.display(this.getClass().getName(), mce.getMessage());
                }
                break;
            //Enter/Exit Dungeon (If on Dungeon Entrance)
            case "D":
                //Locate the player and determine if they are located at the
                //Dungeon Entrance
                if (isInDungeon && currentRow == 4 && currentColumn == 0)
                {
                    boolean found = false;
                    int dungeonEntranceRow = 0;
                    int dungeonEntranceColumn = 0;
                    //Search Forest map for dungeon entrance  //WEEK 10 INDIVIDUAL ASSIGNMENT
                    for (Scene[] sceneRow : game.getForestMap().getSceneArray())
                    {
                        for (Scene scene : sceneRow)
                        {
                            if (scene.getName().equals("Entrance"))
                            {
                                //When located, record data and break the loop
                                found = true;
                                dungeonEntranceRow = scene.getRow();
                                dungeonEntranceColumn = scene.getColumn();
                                break;
                            }
                        }
                        
                        if (found)
                        {
                            //Break out if the scene and information has been found
                            break;
                        }
                    }
                    
                    //Move the player out of the dungeon
                    this.console.println("You are now leaving the dungeon.");
                    game.setCurrentRow(dungeonEntranceRow);
                    game.setCurrentColumn(dungeonEntranceColumn);
                    game.setIsInDungeon(false);
                    //Increment Time
                    defeated = timeControl.addTime(game, 15);
                }
                else
                {
                    //Move the player into the dungeon if they have the key
                    boolean hasKey = false;
                    for (Item item : game.getPlayer().getItems())
                    {
                        if (item.equals(Item.DungeonKey))
                        {
                            hasKey = true;
                            break;
                        }
                    }
                    
                    if (hasKey)
                    {
                        this.console.println("You are now entering the dungeon.");
                        game.setCurrentRow(4);
                        game.setCurrentColumn(0);
                        game.setIsInDungeon(true);
                        //Increment Time
                        defeated = timeControl.addTime(game, 15);
                    }
                    else
                    {
                        this.console.println("You cannot enter the dungeon without the key.");
                    }
                }
                break;
            //Search Scene and Pick Up Any Key Items
            case "X":
                //Display the Scene Clue If Key Scene Not Already Searched
                boolean alreadyDisplayed = false;
                SceneControl newSceneControl = new SceneControl();
                switch (newSceneControl.getCurrentScene(game).getName())
                {
                    case "Key":
                    case "Tracks1":
                    case "Tracks2":
                    case "Tracks3":
                    case "Defensive":
                    case "Offensive":
                    case "Memento":
                    case "Ring":
                    case "Necklace":
                    case "Toy":
                        if (game.getClue(newSceneControl.getCurrentScene(game).
                        getName()).getRetrieved())
                            this.console.println(game.getClues()[10].getSceneClue());
                        else
                        {
                            //Display the Clue
                            this.console.println(newSceneControl.getSceneClue(game));
                            
                            //Add the scene item to inventory and set the
                            //retrieved indicator as True if successful
                            InventoryControl newInventoryControl = new InventoryControl();
                            try
                            {
                                Item sceneItem = newSceneControl.
                                    retrieveClue(game).getSceneItem();
                                
                                //Add the Item to Inventory
                                newSceneControl.retrieveClue(game).setRetrieved(
                                    newInventoryControl.addItemToInventory(
                                    sceneItem,game.getPlayer()));
                                
                                //If the item is a Defensive or Offensive Charm,
                                //increase the player stats accordingly
                                if (sceneItem.getItemName().equals("Defensive"))
                                {
                                    int newDefense = game.getPlayer().
                                        getPlayerStats().getDefense() + 10;
                                    if (newDefense > 100)
                                        newDefense = 100;
                                    int newMagicDefense = game.getPlayer().
                                        getPlayerStats().getMagicDefense() + 10;
                                    if (newMagicDefense > 100)
                                        newMagicDefense = 100;
                                    game.getPlayer().getPlayerStats().
                                        setDefense(newDefense);
                                    game.getPlayer().getPlayerStats().
                                        setMagicDefense(newMagicDefense);
                                }
                                else if (sceneItem.getItemName().equals("Offensive"))
                                {
                                    int newStrength = game.getPlayer().
                                        getPlayerStats().getStrength() + 10;
                                    if (newStrength > 100)
                                        newStrength = 100;
                                    double newHitRate = game.getPlayer().
                                        getPlayerStats().getHitRate() + .1;
                                    if (newHitRate > 1)
                                        newHitRate = 1;
                                    game.getPlayer().getPlayerStats().
                                        setStrength(newStrength);
                                    game.getPlayer().getPlayerStats().
                                        setHitRate(newHitRate);
                                }
                            }
                            catch (InventoryControlException ice)
                            {
                                ErrorView.display(this.getClass().getName(),
                                    ice.getMessage());
                            }
                        }
                        //Increment Time
                        defeated = timeControl.addTime(game, 15);
                        break;
                    default:
                        this.console.println(game.getClues()[10].getSceneClue());
                }
                break;
            //Fight Boss/Miniboss
            case "F":
                String sceneName = (game.getIsInDungeon() ? game.getDungeonMap().
                    getScene(currentRow, currentColumn).getName() : 
                    game.getForestMap().getScene(currentRow, currentColumn).getName());
                BattleView newBattleView = new BattleView();
                switch (sceneName)
                {
                    case "Boss":
                        this.console.println("You have chosen to engage the "
                            + "Minotaur Boss at this time.");
                        defeated = newBattleView.displayBattleView(sceneName, game.getPlayer());
                        if (!defeated)
                        {
                            //Game has been won
                            GameVictoryView newGameVictory = new GameVictoryView();
                            newGameVictory.display();
                            //If this point is reached, the player wants to return
                            //to the main menu
                            defeated = true;
                        }
                    case "Miniboss1":
                    case "Miniboss2":
                        this.console.println("You have chosen to engage the "
                            + "Minotaur Captain at this time.");
                        defeated = newBattleView.displayBattleView(sceneName, game.getPlayer());
                        if (!defeated)
                        {
                            //Rewards based on which mini-boss defeated
                            switch (sceneName)
                            {
                                case "Miniboss1":
                                    this.console.println("Congratulations on "
                                        + "defeating the miniboss!  As a reward,"
                                        + " you receive <<Heaven's Sword>>.");
                                    game.getPlayer().setWeapon(Item.HeavensSword);
                                    break;
                                case "Miniboss2":
                                    this.console.println("Congratulations on "
                                        + "defeating the miniboss!  As a reward,"
                                        + " you receive <<5 Large Health Potions "
                                        + "and 5 Large Mana Potions>>.");
                                    SceneControl thisControl = new SceneControl();
                                    for (int i = 0; i < 5; i++)
                                    {
                                        thisControl.addItemReward(game.getPlayer(), Item.LargeHealthPotion);
                                        thisControl.addItemReward(game.getPlayer(), Item.LargeManaPotion);
                                    }
                                    break;
                                default:
                                    ErrorView.display(this.getClass().getName(), "Error:  Invalid Scene");
                            }
                        }
                    default:
                        ErrorView.display(this.getClass().getName(), "Error:  "
                            + "You are not in a location of a boss or miniboss.");
                }
                break;
            //Use Item in Inventory
            case "U":
                UseItemView newUseItemView = new UseItemView();
                newUseItemView.display(game.getPlayer());
                //Increment Time
                game.setElapsedTime(game.getElapsedTime() + 1);
                break;
            //Talk with an NPC
            case "C":
                CommunicationsView newCommunicationsView = new CommunicationsView(game);
                newCommunicationsView.display(game);
                //Increment Time
                defeated = timeControl.addTime(game, 5);
                break;
            //Bring up the Game Menu
            case "G":
                GameMenuView viewGameMenu = new GameMenuView();
                viewGameMenu.display(game);
                break;
            default:
        }

        return (!defeated);
    }
}
