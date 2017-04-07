/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;


import saveTheVillage.model.Game;
import saveTheVillage.model.Player;
import saveTheVillage.model.Scene;
import saveTheVillage.model.Item;
import saveTheVillage.model.NPC;
import saveTheVillage.model.Clue;
import saveTheVillage.view.ErrorView;
import saveTheVillage.exceptions.SceneControlException;


public class SceneControl
{
    /* ********************************************************
    REST AT INN
    ********************************************************* */
    public void restAtInn(Player player, int hours)
    {
        //Error Trapping
        if (hours <= 0 || hours > 8)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Hours rest at inn must be a number "
                + "between 1 and 8");
            return;
        }
        
        //Restore a Percentage of Player Health
        int amountRestored = (int)(((double)hours / 8.0) * 
            player.getPlayerStats().getHealth());
        player.setCurrentHealth(player.getCurrentHealth() + amountRestored);
        
        //Health is no greater than max
        if (player.getCurrentHealth() > player.getPlayerStats().getHealth())
        {
            player.setCurrentHealth(player.getPlayerStats().getHealth());
        }
        
        //Reduce Player Money Appropriately
        player.setMoney(player.getMoney() - (hours * 5));
    }
    
    /* ********************************************************
    BUY ITEM
    ********************************************************* */
    public void buyItem(Player player, Item item)
    {
            int diff = player.getMoney() - item.getBuyPrice();

            if (item.getBuyPrice() == 0) {
                ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
                return;
            }
            if (item.getBuyPrice() != 0 && !(diff < 0))
            {
                int i = 0;
                while(!player.getItems()[i].getItemName().equals("None") && i < 60){
                    i++;
                }
                
                if (i >= 60)
                {
                    System.out.println("Unable to add " + item.getItemName() +
                        " to your inventory as you do not have any additional space.");
                }
                else
                {
                    player.setMoney(diff);
                    System.out.println("\nYou now have " + player.getMoney() + " gold.");
                    player.setItems(i, item);
                    System.out.println(item.getItemName() + " added to inventory");
                }
            }
            else System.out.println("\nYou don't have enough for that!" + 
                    "\nYou only have " + player.getMoney() + " gold.");
    }
    
    /* ********************************************************
    ADD ITEM REWARD
    ********************************************************* */
    public void addItemReward(Player player, Item item)
    {
        int i = 0;
        while(!player.getItems()[i].getItemName().equals("None") && i < 60){
            i++;
        }
        
        if (i >= 60)
        {
            System.out.println("Unable to add " + item.getItemName() +
                " to your inventory as you do not have any additional space.");
        }
        else
        {
            player.setItems(i, item);
            System.out.println(item.getItemName() + " added to inventory");
        }
    }
    
    /* ********************************************************
    SELL ITEM
    ********************************************************* */
    public void sellItem(Player player, Item item, int choice)
    {
        int sell = item.getBuyPrice();
        sell = sell/2;

        int diff = player.getMoney() + sell;
        if (sell == 0)
        {
            ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
            return;
        }
        if (sell != 0)
        {
            player.setItems(choice, Item.None);  //set inventory as none
            player.setMoney(diff);  //give user money from the sell
            System.out.println(item.getItemName() + " removed from inventory");
            System.out.println("\nYou now have " + player.getMoney() + " gold.");
        }
    }
    
    /* ********************************************************
    BUY WEAPON
    ********************************************************* */
    public void buyWeapon(Player player, Item item)
    {
            int diff = player.getMoney() - item.getBuyPrice();

            if (item.getBuyPrice() == 0) {
                ErrorView.display(this.getClass().getName(), "\nError Item price is 0");
                return;
            }
            if (item.getBuyPrice() != 0 && !(diff < 0))
            {
                //Replace the current weapon and sell current weapon for half price
                player.setMoney(player.getMoney() + 
                    (player.getWeapon().getBuyPrice() / 2));
                System.out.println("\nYou now have " + player.getMoney() + " gold.");
                
                player.setWeapon(item);

                System.out.println(item.getItemName() + " is now your current"
                    + " weapon.");
            }
            else System.out.println("\nYou don't have enough for that!" + 
                    "\nYou only have " + player.getMoney() + " gold.");
        }
    
    /* ********************************************************
    VALIDATE NPC
    ********************************************************* */
    public NPC validateNPC(String npcName, Scene scene) throws SceneControlException
    {
        //Find the NPC
        for (NPC thisNPC : scene.getNPC())
        {
            if (npcName.equals(thisNPC.getNPCName()))
                return thisNPC;
        }
        
        throw new SceneControlException("ERROR:  Invalid NPC selected");
    }
    
    /* ********************************************************
    GET CURRENT SCENE
    ********************************************************* */
    public Scene getCurrentScene(Game game)
    {
        return (game.getIsInDungeon() ? game.getDungeonMap().getScene(
            game.getCurrentRow(), game.getCurrentColumn()) : game.getForestMap().
            getScene(game.getCurrentRow(), game.getCurrentColumn()));
    }
    
    /* ********************************************************
    RETRIEVE CLUE
    ********************************************************* */
    public Clue retrieveClue(Game game)
    {
        return game.getClue(getCurrentScene(game).getName());
    }
    
    /* ********************************************************
    GET SCENE CLUE
    ********************************************************* */
    public String getSceneClue(Game game)
    {
        return retrieveClue(game).getSceneClue();
    }

    /* ********************************************************
    GET NPC CLUE
    ********************************************************* */
    public String getNPCClue(Game game, String associatedScene)
    {
        return retrieveClue(game).getNPCClue();
    }
}
