/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Actor;
import saveTheVillage.model.Item;
import saveTheVillage.model.Player;
import static java.lang.Integer.parseInt;


public class UseItemView extends View
{
    UseItemView()
    {
        super("Please select which inventory item to use or enter 0 to Exit:");
    }
    
    public void display(Player player)
    {
        boolean done = false;
        do
        {
            int counter = 0;
            this.console.print("\t");
            this.console.printf("%-3s", "#");
            this.console.printf("%-25s", "ITEM NAME");
            this.console.println("--------------------------------");
            for (Item item : player.getItems())
            {
                if (!item.equals(Item.None))
                {
                    counter++;
                    this.console.print("\t");
                    this.console.printf("%-3d", counter);
                    this.console.printf("%-25s", item.getItemName());
                 }
            }
            
            int value = parseInt(this.getInput());
            //Error Trapping
            if (value < 0 || value > 60)
            {
                ErrorView.display(this.getClass().getName(), "Invalid Input:  "
                    + "Value Must Be Between 0 and 60");
                return;
            }
            
            //Exit out if user input '0'
            if (value == 0)
                return;
            
            //Shift the value by -1 to align with array numbers
            value -= 1;
            
            done = this.doAction(value, player);
        }while(!done);
    }
    
    public void display(Player player, Actor enemy,int damageBonus, 
        double hitRateBonus, double dodgeRateBonus, int speedBonus, 
        int defenseBonus)
    {
        boolean done = false;
        do
        {
            int counter = 0;
            this.console.print("\t");
            this.console.printf("%-3s", "#");
            this.console.printf("%-25s", "ITEM NAME");
            this.console.println("--------------------------------");
            for (Item item : player.getItems())
            {
                if (!item.equals(Item.None))
                {
                    counter++;
                    this.console.print("\t");
                    this.console.printf("%-3d", counter);
                    this.console.printf("%-25s", item.getItemName());
                 }
            }
            
            int value = parseInt(this.getInput());
            //Error Trapping
            if (value < 0 || value > 60)
            {
                ErrorView.display(this.getClass().getName(), "Invalid Input:  "
                    + "Value Must Be Between 0 and 60");
                return;
            }
            
            //Exit out if user input '0'
            if (value == 0)
                return;
            
            //Shift the value by -1 to align with array numbers
            value -= 1;
            
            done = this.doAction(value, player, enemy, damageBonus, hitRateBonus,
                dodgeRateBonus, speedBonus, defenseBonus);
        }while(!done);
    }
    
    @Override
    public boolean doAction(String value)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Multiple Items as a parameter");
        return false;
    }
    
    public boolean doAction(int value, Player player)
    {
        Item item = player.getItems()[value];
        
        //Check to see if the selected item is a potion -- only potions can be
        //used outside of battle to restore health and mana
        if (!item.getType().equals("potion"))
        {
            ErrorView.display(this.getClass().getName(), "Invalid Selection:  "
                + "Only potions can be used outside of battles.");
            return false;
        }
        
        int newHealth = player.getCurrentHealth() + item.getHealingAmount();
        if (newHealth > player.getPlayerStats().getHealth())
            newHealth = player.getPlayerStats().getHealth();
        int newMana = player.getCurrentMana() + item.getManaRestored();
        if (newMana > player.getPlayerStats().getMana())
            newMana = player.getPlayerStats().getMana();

        //Remove the item from the list
        player.setItems(value, Item.None);
        return true;
    }

    public boolean doAction(int value, Player player, Actor enemy,
        int damageBonus, double hitRateBonus, double dodgeRateBonus,
        int speedBonus, int defenseBonus)
    {
        Item item = player.getItems()[value];
        
        //Check to see if the selected item is a potion -- only potions can be
        //used outside of battle to restore health and mana
        
        switch(item.getType())
        {
            case "potion":
                int newHealth = player.getCurrentHealth() + item.getHealingAmount();
                if (newHealth > player.getPlayerStats().getHealth())
                    newHealth = player.getPlayerStats().getHealth();
                int newMana = player.getCurrentMana() + item.getManaRestored();
                if (newMana > player.getPlayerStats().getMana())
                    newMana = player.getPlayerStats().getMana();
                this.console.println("You use a " + item.getItemName() + " which "
                    + "restores " + item.getHealingAmount() + " health and " +
                    item.getManaRestored() + " mana.");
                break;
            case "scroll":
                SpellView newSpellView = new SpellView(item);
                newSpellView.display(item, player, enemy, damageBonus, 
                    hitRateBonus, dodgeRateBonus, speedBonus, defenseBonus);
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Selection:  "
                + "Only Potions and Scrolls may be used.");
                return false;
        }
        
        //Remove the item from the list
        player.setItems(value, Item.None);
        return true;
    }
}
