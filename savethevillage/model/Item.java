/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;


public enum Item implements Serializable
{
    None("None", "none", 0, true, false, "Starting Equipment", 0, 0, 0, Spell.NoSpell, 0),
    WoodenSword("Wooden Sword", "weapon", 0, true, false, "Starting Equipment", 1, 0, 0, Spell.NoSpell, 5),
    BambooSword("Bamboo Sword", "weapon", 100, false, false, "Weapons Shop", 2, 0, 0, Spell.NoSpell, 3),
    Sabre("Sabre", "weapon", 1000, false, false, "Weapons Shop", 5, 0, 0, Spell.NoSpell, 5),
    Scimitar("Scimitar", "weapon", 5000, false, false, "Weapons Shop", 10, 0, 0, Spell.NoSpell, 8),
    Broadsword("Broadsword", "weapon", 10000, false, false, "Weapons Shop", 20, 0, 0, Spell.NoSpell, 35),
    Katana("Katana", "weapon", 25000, false, false, "Weapons Shop", 35, 0, 0, Spell.NoSpell, 25),
    HeavensSword("Heavens Sword", "weapon", 0, true, false, "Dungeon", 100, 0, 0, Spell.NoSpell, 5),
    SmallHealthPotion("Small Health Potion", "potion", 50, false, false, "Item Shop", 0, 5, 0, Spell.NoSpell, 1),
    MediumHealthPotion("Medium Health Potion", "potion", 150, false, false, "Item Shop", 0, 20, 0, Spell.NoSpell, 1),
    LargeHealthPotion("Large Health Potion", "potion", 300, false, false, "Item Shop", 0, 50, 0, Spell.NoSpell, 1),
    SmallManaPotion("Small Mana Potion", "potion", 50, false, false, "Item Shop", 0, 0, 5, Spell.NoSpell, 1),
    MediumManaPotion("Medium Mana Potion", "potion", 150, false, false, "Item Shop", 0, 0, 20, Spell.NoSpell, 1),
    LargeManaPotion("Large Mana Potion", "potion", 300, false, false, "Item Shop", 0, 0, 50, Spell.NoSpell, 1),
    HealingWindScroll("Healing Wind Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.HealingWind, 1),
    FireburstScroll("Fireburst Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.Fireburst, 1),
    SteelBladeScroll("Steel Blade Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.SteelBlade, 1),
    IceBladeScroll("Ice Blade Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.IceBlade, 1),
    SwiftWindScroll("Swift Wind Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.SwiftWind, 1),
    BlindingLightScroll("Blinding Light Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.BlindingLight, 1),
    EarthquakeScroll("Earthquake Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.Earthquake, 1),
    IronBodyScroll("Iron Body Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.IronBody, 1),
    DecimatingBlowScroll("Decimating Blow Scroll", "scroll", 400, false, false, "Item Shop", 0, 0, 0, Spell.DecimatingBlow, 1),
    DungeonKey("Dungeon Key", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 0),
    DefensiveCharm("Defensive", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1),
    OffensiveCharm("Offensive", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1),
    KidsMemento("Memento", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1),
    DiamondRing("Ring", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1),
    Necklace("Necklace", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1),
    ChildsToy("Toy", "key", 0, true, true, "Clue", 0, 0, 0, Spell.NoSpell, 1);

    private final String itemName;
    private final String type;
    private final int buyPrice;
    private final boolean noBuy;
    private final boolean noSell;
    private final String association;
    private final int weaponDamage;
    private final int healingAmount;
    private final int manaRestored;
    private final Spell associatedSpell;
    private final int weight;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Item(String itemName, String type, int buyPrice, boolean noBuy, 
        boolean noSell, String association, int weaponDamage, int healingAmount,
        int manaRestored, Spell associatedSpell, int weight)
    {
        this.itemName = itemName;
        this.type = type;
        this.buyPrice = buyPrice;
        this.noBuy = noBuy;
        this.noSell = noSell;
        this.association = association;
        this.weaponDamage = weaponDamage;
        this.healingAmount = healingAmount;
        this.manaRestored = manaRestored;
        this.associatedSpell = associatedSpell;
        this.weight = weight;
    }
    
    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getItemName()
    {
        return itemName;
    }
    
    public String getType()
    {
        return type;
    }

    public int getBuyPrice()
    {
        return buyPrice;
    }
    
    public int getSellPrice()
    {
        int sell = buyPrice/2;
        return sell;
    }
    
    public boolean getNoBuy()
    {
        return noBuy;
    }

    public boolean getNoSell()
    {
        return noSell;
    }

    public String getAssociation()
    {
        return association;
    }

    public int getWeaponDamage()
    {
        return weaponDamage;
    }

    public int getHealingAmount()
    {
        return healingAmount;
    }

    public int getManaRestored()
    {
        return manaRestored;
    }
    
    public Spell getAssociatedSpell()
    {
        return associatedSpell;
    }

    public int getWeight()
    {
        return this.weight;
    }
}
