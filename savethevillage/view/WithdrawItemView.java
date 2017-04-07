/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import saveTheVillage.model.Item;
import saveTheVillage.model.Player;
import static java.lang.Integer.parseInt;


public class WithdrawItemView extends View
{
    WithdrawItemView()
    {
        super("Please select the item number from your bank inventory to withdraw "
            + "from the bank.\nIf your inventory is full, you will not be able to "
            + "withdraw your selected item.");
    }
    
    @Override
    public void display(Game game)
    {
        boolean done = false;
        do
        {
            displayInventory(game.getPlayer());
            int value = parseInt(this.getInput()) - 1;
            done = this.doAction(value, game);
        } while(!done);
    }
    
    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Game as a parameter");
        return false;
    }
    
    public boolean doAction(int choice, Game game)
    {
        //Verify the choice is between -1 and 59
        if (choice < -1 || choice > 59)
        {
            return false;
        }
        
        //If the choice is -1, then the player does not want to deposit anything
        if (choice == -1)
            return true;
        
        Item item = game.getPlayer().getDepositedItems()[choice];
        int i = 0;
        while((game.getPlayer().getItems()[i] != Item.None) && i < 60)
        {
            i++;
        }
        
        if (i >= 60)
        {
            System.out.println("Unable to withdraw " + item.getItemName() +
                " as you no longer have space in your inventory.");
        }
        else
        {
            game.getPlayer().setItems(i, item);
            System.out.println(item.getItemName() + " withdrawn from the bank.");
        }
        
        return true;
    }

    public void displayInventory(Player player)
    {
        //ITEMS ON HAND
        int counter = 0;        
        this.console.println("\tINVENTORY ON HAND\n");
        this.console.print("\t");
        this.console.printf("%-3s", "#");
        this.console.printf("%-25s", "ITEM NAME");
        this.console.printf("%-10s", "TYPE");
        this.console.printf("%-11s", "SELL PRICE");
        this.console.printf("%-5s", "DAM.");
        this.console.printf("%-5s", "HEAL");
        this.console.printf("%-5s", "MANA");
        this.console.printf("%-6s", "WEIGHT");
        this.console.println();
        this.console.println("\t----------------------------------------------------------------------");
        
        for (Item item : player.getItems())
        {
            if (!(item.equals(Item.None)))
            {
                counter++;
                this.console.print("\t");
                this.console.printf("%-3d", counter);
                this.console.printf("%-25s", item.getItemName());
                this.console.printf("%-10s", item.getType());
                this.console.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
                this.console.printf("%-5d", item.getWeaponDamage());
                this.console.printf("%-5d", item.getHealingAmount());
                this.console.printf("%-5d", item.getManaRestored());
                this.console.printf("%-6d", item.getWeight());
                this.console.println();
            }
        }
        
        counter = 0;
        this.console.println();
        
        //ITEMS IN THE BANK
        this.console.println("\tINVENTORY IN THE BANK\n");
        this.console.print("\t");
        this.console.printf("%-3s", "#");
        this.console.printf("%-25s", "ITEM NAME");
        this.console.printf("%-10s", "TYPE");
        this.console.printf("%-11s", "SELL PRICE");
        this.console.printf("%-5s", "DAM.");
        this.console.printf("%-5s", "HEAL");
        this.console.printf("%-5s", "MANA");
        this.console.printf("%-6s", "WEIGHT");
        this.console.println();
        this.console.println("\t----------------------------------------------------------------------");
        
        for (Item item : player.getDepositedItems())
        {
            if (!(item.equals(Item.None)))
            {
                counter++;
                this.console.print("\t");
                this.console.printf("%-3d", counter);
                this.console.printf("%-25s", item.getItemName());
                this.console.printf("%-10s", item.getType());
                this.console.printf("%-11d", (item.getNoSell() ? 0 : (item.getBuyPrice() / 2)));
                this.console.printf("%-5d", item.getWeaponDamage());
                this.console.printf("%-5d", item.getHealingAmount());
                this.console.printf("%-5d", item.getManaRestored());
                this.console.printf("%-6d", item.getWeight());
                this.console.println();
            }
        }
    }
}
