/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable
{
    private String name;
    private String type;  //Regular, Miniboss, or Boss
    private Item item;
    private int gold;
    private Stats enemyStats;
    private int currentHealth;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Actor()
    {
        this.name = "No Name";
        this.type = "No Type";
        this.item = Item.None;
        this.gold = 0;
        this.enemyStats = new Stats();
        this.currentHealth = 0;
    }
    
    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Actor(String name, String type, Item item, int gold,
            Stats enemyStats, int currentHealth)
    {
        this.name = name;
        this.type = type;
        this.item = item;
        this.gold = gold;
        this.enemyStats = enemyStats;
        this.currentHealth = currentHealth;
        
    }
    
    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Actor(Actor otherActor)
    {
        this.name = otherActor.name;
        this.type = otherActor.type;
        this.item = otherActor.item;
        this.gold = otherActor.gold;
        this.enemyStats = otherActor.enemyStats;
        this.currentHealth = otherActor.currentHealth;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public Stats getEnemyStats()
    {
        return enemyStats;
    }
    
    public void setEnemyStats(int health, int mana, int strength,
    double hitRate, int magic, double dodgeRate, int defense,
    int magicDefense, int speed, int speedPenalty)
    {
        enemyStats.setHealth(health);
        enemyStats.setMana(mana);
        enemyStats.setStrength(strength);
        enemyStats.setHitRate(hitRate);
        enemyStats.setMagic(magic);
        enemyStats.setDodgeRate(dodgeRate);
        enemyStats.setDefense(defense);
        enemyStats.setMagicDefense(magicDefense);
        enemyStats.setSpeed(speed);
        enemyStats.setSpeedPenalty(speedPenalty);
    }
    
    public int getCurrentHealth()
    {
        return this.currentHealth;
    }
    
    public void setCurrentHealth(int currentHealth)
    {
        this.currentHealth = currentHealth;
    }


    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.item);
        hash = 53 * hash + this.gold;
        hash = 53 * hash + Objects.hashCode(this.enemyStats);
        hash = 53 * hash + this.currentHealth;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        if (this.gold != other.gold) {
            return false;
        }
        if (this.enemyStats != other.enemyStats)
        {
            return false;
        }
        if (this.currentHealth != other.currentHealth)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String returnString =  "Actor{" + "name=" + name + ", type=" + 
                type + ", item=" + item.toString() + ", gold=" + gold;
        
        returnString += enemyStats.toString() + ", currentHealth= " + 
                currentHealth;
        
        returnString += '}';
        
        return returnString;
    }
}
