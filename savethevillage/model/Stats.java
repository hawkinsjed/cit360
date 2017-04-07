/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;


public class Stats implements Serializable
{
    //class instance variables
    private int health;
    private int mana;
    private int strength;
    private double hitRate;
    private int magic;
    private double dodgeRate;
    private int defense;
    private int magicDefense;
    private int speed;
    private int speedPenalty;
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Stats() {
        health = 0;
        mana = 0;
        strength = 0;
        hitRate = 0;
        magic = 0;
        dodgeRate = 0;
        defense = 0;
        magicDefense = 0;
        speed = 0;
        speedPenalty = 0;
    }
    
    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Stats(int health, int mana, int strength, double hitRate,
            int magic, double dodgeRate, int defense, int magicDefense,
            int speed, int speedPenalty)
    {
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.hitRate = hitRate;
        this.magic = magic;
        this.dodgeRate = dodgeRate;
        this.defense = defense;
        this.magicDefense = magicDefense;
        this.speed = speed;
        this.speedPenalty = speedPenalty;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Stats(Stats otherStats)
    {
        this.health = otherStats.health;
        this.mana = otherStats.mana;
        this.strength = otherStats.strength;
        this.hitRate = otherStats.hitRate;
        this.magic = otherStats.magic;
        this.dodgeRate = otherStats.dodgeRate;
        this.defense = otherStats.defense;
        this.magicDefense = otherStats.magicDefense;
        this.speed = otherStats.speed;
        this.speedPenalty = otherStats.speedPenalty;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }
    
    public double getDodgeRate() {
        return dodgeRate;
    }

    public void setDodgeRate(double dodgeRate) {
        this.dodgeRate = dodgeRate;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getSpeedPenalty()
    {
        return speedPenalty;
    }
    
    public void setSpeedPenalty(int speedPenalty)
    {
        this.speedPenalty = speedPenalty;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.health;
        hash = 29 * hash + this.strength;
        hash = 29 * hash + (int)this.hitRate;
        hash = 29 * hash + this.magic;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.dodgeRate) ^ (Double.doubleToLongBits(this.dodgeRate) >>> 32));
        hash = 29 * hash + this.defense;
        hash = 29 * hash + this.magicDefense;
        hash = 29 * hash + this.speed;
        hash = 29 * hash + this.speedPenalty;
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
        final Stats other = (Stats) obj;
        if (this.health != other.health) {
            return false;
        }
        if (this.mana != other.mana) {
            return false;
        }
        if (this.strength != other.strength) {
            return false;
        }
        if (this.hitRate != other.hitRate) {
            return false;
        }
        if (this.magic != other.magic) {
            return false;
        }
        if (Double.doubleToLongBits(this.dodgeRate) != Double.doubleToLongBits(other.dodgeRate)) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.magicDefense != other.magicDefense) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.speedPenalty != other.speedPenalty)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stats{" + "health=" + health + ", mana=" + mana + 
                ", strength=" + strength + ", hitRate=" + hitRate + 
                ", magic=" + magic + ", dodgeRate=" + dodgeRate + 
                ", defense=" + defense + ", magicDefense=" + magicDefense + 
                ", speed=" + speed + ", speedPenalty=" + speedPenalty +'}';
    }
}
