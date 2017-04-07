/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.model.Item;
import saveTheVillage.exceptions.InventoryControlException;
import saveTheVillage.exceptions.PlayerControlException;
import saveTheVillage.model.Player;
import saveTheVillage.model.Stats;
import java.io.IOException;
import java.io.PrintWriter;


public class InventoryControl
{
    /* ********************************************************
    RANDOMIZE ITEM
    ********************************************************* */
    public Item randomizeItem(int random) throws InventoryControlException
    {
        if ((random < 0) || (random > 100))
            throw new InventoryControlException("Invalid Random Number");
        
        if (random <= 35)
        {
            return Item.None;
        }
        else if (random <= 48)
        {
            return Item.SmallHealthPotion;
        }
        else if (random <= 60)
        {
            return Item.SmallManaPotion;
        }
        else if (random <= 71)
        {
            return Item.MediumHealthPotion;
        }
        else if (random <= 82)
        {
            return Item.MediumManaPotion;
        }
        else if (random <= 84)
        {
            return Item.LargeHealthPotion;
        }
        else if (random <= 86)
        {
            return Item.LargeManaPotion;
        }
        else if (random <= 88)
        {
            return Item.HealingWindScroll;
        }
        else if (random <= 90)
        {
            return Item.FireburstScroll;
        }
        else if (random <= 92)
        {
            return Item.SteelBladeScroll;
        }
        else if (random <= 94)
        {
            return Item.IceBladeScroll;
        }
        else if (random <= 96)
        {
            return Item.SwiftWindScroll;
        }
        else if (random <= 98)
        {
            return Item.BlindingLightScroll;
        }
        else if (random <= 98)
        {
            return Item.EarthquakeScroll;
        }
        else if (random <= 98)
        {
            return Item.IronBodyScroll;
        }
        else
        {
            return Item.DecimatingBlowScroll;
        }
    }
    
    /* ********************************************************
    ADD ITEM TO INVENTORY
    ********************************************************* */
    public static boolean addItemToInventory(Item item, Player player)
    throws InventoryControlException
    {
        //Determine if weight limit would be exceeded
        PlayerControl newPlayerControl = new PlayerControl();
        boolean exceededWeight = false;
        int currentWeight = newPlayerControl.determinePlayerCurrentWeight(player);
        int weightLimit = newPlayerControl.determinePlayerWeightLimit(player);
        
        if ((currentWeight + item.getWeight()) > weightLimit)
        {
            throw new InventoryControlException("You are unable to add this "
                + "item to your inventory as it would exceed your weight limit.");
        }
        
        //Browse inventory to find the first open slot available
        boolean space = false;
        if (!(item == Item.None))
        {
            int itemSlot = 0;
            while (itemSlot < 60 && space == false)
            {
                if (player.getItems()[itemSlot] == Item.None)
                {
                    space = true;
                }
                else
                {
                    itemSlot++;
                }
            }
            
            if (space)
            {
                //Add the item
                player.setItems(itemSlot, item);
                System.out.println("You successfully added " + 
                    item.getItemName() + " to your inventory.");
            }
            else
            {
                throw new InventoryControlException("Sorry, seems like you "
                    + "didn't budget your inventory well enough - you have no "
                    + "space to store this item.");
            }
        }
        
        //Calculate and Set New Weight
        player.setPlayerWeight(currentWeight + item.getWeight());
        System.out.println("Your new weight is:  " + (currentWeight + item.getWeight()));
        
        //Calculate and Set New Speed Penalty
        Stats newStats = new Stats(player.getPlayerStats());
        try
        {
            newStats.setSpeedPenalty(newPlayerControl.determineSpeedPenalty
                (player.getPlayerStats().getSpeed(), 
                player.getPlayerStats().getStrength(),
                player.getPlayerWeight()));
        }
        catch (PlayerControlException me)
        {
            throw new InventoryControlException("Your speed seems wrong...");
        }

        player.setPlayerStats(newStats);
        System.out.println("Your new speed penalty is:  " +
            player.getPlayerStats().getSpeedPenalty());
        
        return true;
    }
    
    /* ********************************************************
    PRINT WEAPON REPORT
    ********************************************************* */

    public static void printWeaponReport (String outputLocation)
    {         
        try (PrintWriter outFile = new PrintWriter(outputLocation))
        {
            outFile.println("\n          Weapon List         ");
            outFile.printf("%n%-30s%10s%10s", "Name", "Buy Price", "Damage");
            outFile.printf("%n%-30s%10s%10s", "____", "________", "______");
            int i = 0;   

            Item[] items = Item.values();
            for (Item item : items)
            {
                if (item.getAssociation()== "Weapons Shop") {
                    i++;  
                    outFile.printf("\n" + "%n%-30s%10s%10s", item.getItemName(),
                    item.getBuyPrice(),item.getWeaponDamage());

                }
            }   
            System.out.println("\n\nFile written");
        }
        catch (IOException ex)
        {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }
}