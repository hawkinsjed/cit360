/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Player implements Serializable {
    private String name;
    private int age;
    private Races race;
    private Item items[];
    private int money;
    private Item weapon;
    private int currentHealth;
    private int currentMana;
    private Item depositedItems[];
    private int depositedMoney;
    private Stats playerStats;
    private int playerWeight;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Player()
    {
        this.name = "No Name";
        this.race = Races.HUMAN;
        this.age = 0;
        this.items = new Item[60];
        for (int i = 0; i < this.items.length; i++)
        {
            this.items[i] = Item.None;
        }
        this.money = 0;
        this.weapon = Item.WoodenSword;
        this.currentHealth = 0;
        this.currentMana = 0;
        this.depositedItems = new Item[60];
        for (int i = 0; i < this.depositedItems.length; i++)
        {
            this.depositedItems[i] = Item.None;
        }
        this.depositedMoney = 0;
        this.playerStats = new Stats();
        this.playerWeight = 0;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Player(String name, Races race, int age, Item[] items, int money,
        Item weapon, int currentHealth,int currentMana, Item[] depositedItems, 
        int depositedMoney,Stats playerStats, int playerWeight)
    {
        this.name = name;
        this.race = race;
        this.age = age;
        this.items = new Item[items.length];
        for (int i = 0; i < this.items.length; i++)
        {
            this.items[i] = items[i];
        }
        this.money = money;
        this.weapon = weapon;
        this.currentHealth = currentHealth;
        this.currentMana = currentMana;
        this.depositedItems = new Item[depositedItems.length];
        for (int i = 0; i < this.depositedItems.length; i++)
        {
            this.depositedItems[i] = depositedItems[i];
        }
        this.depositedMoney = depositedMoney;
        this.playerStats = playerStats;
        this.playerWeight = playerWeight;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Player(Player otherPlayer)
    {
        this.name = otherPlayer.name;
        this.race = otherPlayer.race;
        this.age = otherPlayer.age;
        this.items = new Item[otherPlayer.items.length];
        for (int i = 0; i < this.items.length; i++)
        {
            this.items[i] = otherPlayer.items[i];
        }
        this.money = otherPlayer.money;
        this.weapon = otherPlayer.weapon;
        this.currentHealth = otherPlayer.currentHealth;
        this.currentMana = otherPlayer.currentMana;
        this.depositedItems = new Item[otherPlayer.depositedItems.length];
        for (int i = 0; i < this.depositedItems.length; i++)
        {
            this.depositedItems[i] = otherPlayer.depositedItems[i];
        }
        this.depositedMoney = otherPlayer.depositedMoney;
        this.playerStats = otherPlayer.playerStats;
        this.playerWeight = otherPlayer.playerWeight;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Races getRace() {
        return race;
    }

    public void setRace(Races race) {
        this.race = race;
    }

    public Item[] getItems() {
        return items;
    }
    
    public int getItemMax() {
        return items.length;
    }

    public void setItems(int itemNumber, Item item)
    {
        this.items[itemNumber] = item;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon)
    {
        this.weapon = weapon;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

     public Item[] getDepositedItems() {
        return depositedItems;
    }

    public void setDepositedItems(int itemNumber, Item item)
    {
        this.depositedItems[itemNumber] = item;
    }

    public int getDepositedMoney() {
        return depositedMoney;
    }

    public void setDepositedMoney(int money) {
        this.depositedMoney = money;
    }
    
    public Stats getPlayerStats()
    {
        return playerStats;
    }
    
    public void setPlayerStats(Stats playerStats)
    {
        this.playerStats = playerStats;
    }
    
    public int getPlayerWeight()
    {
        return this.playerWeight;
    }
    
    public void setPlayerWeight(int playerWeight)
    {
        this.playerWeight = playerWeight;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.age;
        hash = 89 * hash + Objects.hashCode(this.race);
        hash = 89 * hash + Arrays.deepHashCode(this.items);
        hash = 89 * hash + this.money;
        hash = 89 * hash + Objects.hashCode(this.weapon);
        hash = 89 * hash + this.currentHealth;
        hash = 89 * hash + this.currentMana;
        hash = 89 * hash + Arrays.deepHashCode(this.depositedItems);
        hash = 89 * hash + this.depositedMoney;
        hash = 89 * hash + Objects.hashCode(this.playerStats);
        hash = 89 * hash + this.playerWeight;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (this.currentHealth != other.currentHealth) {
            return false;
        }
        if (this.currentMana != other.currentMana) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.race, other.race)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        if (!Arrays.deepEquals(this.items, other.items)) {
            return false;
        }
        if (!Arrays.deepEquals(this.depositedItems, other.depositedItems)) {
            return false;
        }
        if (this.depositedMoney != other.depositedMoney){
            return false;
        }
        if (!Objects.equals(this.playerStats, other.playerStats))
        {
            return false;
        }
        if (this.playerWeight != other.playerWeight)
        {
            return false;
        }
        return true;
    }

   @Override
    public String toString() {
        String returnString =  "Player{" + "name=" + name + ", age=" + age + 
                ", race=" + race.getRaceName() + ", items=";
        
        for (int i = 0; i < items.length; i++)
        {
            returnString += items[i].toString();
        }
        
        returnString += ", money=" + money + ", weapon=" + weapon.toString() + 
            ", currentHealth=" + currentHealth + ", currentMana=" + 
            currentMana + ", ";
        
        for (int i = 0; i < depositedItems.length; i++)
        {
            returnString += depositedItems[i].toString();
        }
        
        returnString += ", depositedMoney=" + depositedMoney;
        
        returnString += "\n" + playerStats.toString();
        
        returnString += ", playerWeight=" + playerWeight + '}';
        
        return returnString;
    }
}
