/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.GameControl;
import saveTheVillage.model.Player;
import saveTheVillage.model.Item;
import saveTheVillage.control.SceneControl;
import saveTheVillage.model.Game;
import static java.lang.Integer.parseInt;


public class StoreView extends View{
    
    public StoreView()
    {
        super("\n"
            + "You step inside and your senses are immediately struck with a wide array or sights and smells. An elf woman\n"
            + "with a colorful turban smiles at you and motions with both her hands at the items that pack the shelves. She\n"
            + "then steps towards you, curtsies slightly. Then with a mischievous wink asks, “Do you see anything that you\n"
            + "like?”\n" 
            + "“I have healing salves, a variety of potions, and even a spell scroll or two. Anything that a strong hero like\n"
            + "you could possibly need.”"
            + "\n\t----STORE---MENU----"
            + "\n\t| B – Buy Items    |"
            + "\n\t| S – Sell Items   |"
            + "\n\t| L – Leave Store  |"
            + "\n\t--------------------"
            + "\n\n"
            + "Please make a selection:");
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
                this.buyItems(game);
                break;
            case "S": // List items to sell
                this.sellItems(game);
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
    
        private void buyItems(Game game) {
        
        //list store inventory 0 to quit 
      this.console.println("#  ITEM\t\t\tPRICE" );
      String itemName[]= new String[22];
   
        int i = 0;
        
        Item[] items = Item.values();
        for (Item item : items){
            if (item.getAssociation().equals("Item Shop") && item.getBuyPrice() != 0) {
              i++;  
              this.console.println(i + "  " + item.getItemName() +"\t" + item.getBuyPrice());
              itemName[i]=item.getItemName();
            }
        }
        
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
        newSceneControl.buyItem(game.getPlayer(), Item.values()[choice]);
        
        //Increment Time
        GameControl timeControl = new GameControl();
        timeControl.addTime(game, 1);
        
        return; 
        
    }

    private void sellItems(Game game) {
        //list store inventory 0 to quit       
      //  this.console.println("\nList of items to come, for now enter 0 to exit");
        //Prompt for user input of which item to sell
        Player player = new Player();
        player = game.getPlayer();
        player.getItems();
        
        int value = 0;
        boolean valid = false; 
 
      this.console.println("#  ITEM\t\t\tSELL PRICE" );
      String itemName[]= new String[22];
   
        int i = 0;
        Item[] items = player.getItems();
        for (Item item : items){
            if (item.getAssociation().equals("Item Shop") && item.getBuyPrice() != 0) {
              i++;  
              this.console.println(i + "  " + item +"\t" + item.getSellPrice());
              itemName[i]=item.getItemName();
            }
        }

        this.console.println("\nWhich item would you like to sell?");
        this.console.println("\nEnter 0 to exit");
        //Prompt for user input of which item to buy
        
        int keyboardValue = 0;


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

            int max = 60; //get number of items available
        //  while (player.getItems()[max] == null) max++;
            if(keyboardValue < 0)
            {
                ErrorView.display(this.getClass().getName(), "Invalid item - Try again");
                continue;
            }

            else if(keyboardValue == 0)
            {
                return;
            }

            else if(keyboardValue > max)  
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
        int choice = keyboardValue-1;
        SceneControl newSceneControl = new SceneControl();
        newSceneControl.sellItem(game.getPlayer(), player.getItems()[choice], choice);

        //Increment Time
        GameControl timeControl = new GameControl();
        timeControl.addTime(game, 1);

        return; 
    }        

}