/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;


public enum Spell implements Serializable
{
    //Human racial spells are Healing Wind, Fireburst, and Steel Blade
    HealingWind("Healing Wind", "Heals the player for a meduim amount of health.", 
            0, 50, "None", 0),
    Fireburst("Fireburst", "Creates a burst of fire dealing high fire damage to "
            + "the enemey.", 75, 0, "None", 0),
    SteelBlade("Steel Blade", "Increases the base damage of your weapon.", 0, 0,
            "Damage", 35),
    //Elf racial spells are Swift Wind, Blinding Light, and Ice Blade
    SwiftWind("Swift Wind", "Increases your accuracy for the duration of the fight",
            0, 0, "Hit Rate", .15),
    BlindingLight("Blinding Light", "Produces a flash of light, increasing your "
            + "chance of dodging.",
            0, 0, "Dodge Rate", .15),
    IceBlade("Ice Blade", "Deals some ice damage to enemy while slowing the "
            + "enemy.", 30, 0, "Speed", -.5),
    //Dwarf racial spells are Earthquake, Iron Body, and Decimating Blow
    Earthquake("Earthquake", "Sacrifice 25 health points to deal  high levels of "
            + "earth damage.", 100, -25, "None", 0),
    IronBody("Iron Body", "Increases the player's defense for the duration"
            + " of the battle.", 0, 0, "Defense", 15),
    DecimatingBlow("Decimating Blow", "Inflicts minor damage to the enemy and "
            + "increase attack damage.", 10, 0, "Damage",
            25),
    NoSpell("None", "", 0, 0, "None", 0);
    
    private final String spellName;
    private final String spellDescription;
    private final int damageDealt;
    private final int amountHealed;
    private final String attributeBoosted;
    private final double attributeBoostAmount;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Spell(String spellName, String description, int damageDealt, int healed, 
        String attBoost, double attBoostAmnt)
    {
        this.spellName = spellName;
        this.spellDescription = description;
        this.damageDealt = damageDealt;
        this.amountHealed = healed;
        this.attributeBoosted = attBoost;
        this.attributeBoostAmount = attBoostAmnt;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getSpellName()
    {
        return spellName;
    }
    
    public String getSpellDescription()
    {
        return spellDescription;
    }
    
    public int getDamageDealt()
    {
        return damageDealt;
    }

    public int getAmountHealed()
    {
        return amountHealed;
    }

    public String getAttributeBoosted()
    {
        return attributeBoosted;
    }

    public double getAttributeBoostAmount()
    {
        return attributeBoostAmount;
    }
    
    public static void printSpellList(String outputLocation) {
    
        try (PrintWriter out = new PrintWriter(outputLocation)){
            
            //Print title and column headings
            out.println("\n\t\t\t\tSpell List");
            out.printf("%n%-20s%10s%10s%20s%10s", "Name", "Damage", "Healed", "Attribute", "Amount");
            out.printf("%n%-20s%10s%10s%20s%10s", "----------", "------", "------", "---------", "------");
            int i = 0;
            //print description of spells
            Spell[] spells = Spell.values();
            for (Spell spell : spells){
                i++;
                out.printf("\n" + "%n%-20s%10d%10d%20s%10d"
                                  , spell.getSpellName()
                                  , spell.getDamageDealt()
                                  , spell.getAmountHealed()
                                  , spell.getAttributeBoosted()
                                  , spell.getAttributeBoostAmount());
            }
            System.out.println("\nFile Written");
        }
        catch (IOException e){
            System.out.println("I/O Error: " + e.getMessage());
        }

    }
}