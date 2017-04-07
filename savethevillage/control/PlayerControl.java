/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.exceptions.PlayerControlException;
import saveTheVillage.model.Item;
import saveTheVillage.model.Player;
import saveTheVillage.model.Stats;
import saveTheVillage.model.Races;
import saveTheVillage.view.ErrorView;


public class PlayerControl {

    public PlayerControl()
    {
        //No Functions or Attributes
    }
    
    /* ********************************************************
    INITIALIZE NEW PLAYER
    ********************************************************* */
    public Player initializeNewPlayer(String username, Races race, int age)
    {        
        //Error Trapping
        if (!(race == Races.HUMAN || race == Races.ELF || race == Races.DWARF))
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Invalid Race - Race must be Human, "
                    + "Elf, or Dwarf");
            Player newPlayer = new Player();
            newPlayer.setName("Invalid");
            return newPlayer;
        }
        if (age < 25 || age > 75)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Invalid Age - Age must be between "
                    + "25 and 75");
            Player newPlayer = new Player();    
            newPlayer.setName("Invalid");
            return newPlayer;
        }
        if (username.equals("Invalid"))
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Invalid Name = 'Invalid' is a reserved "
                    + "keyword");
            Player newPlayer = new Player();    
            newPlayer.setName("Invalid");
            return newPlayer;
        }
        
        //Attributes
        Item defaultItems[] = new Item[60];
        for (int i = 0; i < defaultItems.length; i++)
        {
            defaultItems[i] = Item.None;
        }
        
        int defaultMoney = 100;
        Item defaultWeapon = Item.WoodenSword;
        
        Item defaultDepositedItems[] = new Item[60];
        for (int i = 0; i < defaultDepositedItems.length; i++)
        {
            defaultDepositedItems[i] = Item.None;
        }
        int defaultDepositedMoney = 0;
        
        
        //Player Stats, Health, and Mana
        Stats playerStats = initializeNewPlayerStats(race, age);
        int currentHealth = playerStats.getHealth();
        int currentMana = playerStats.getMana();
                
        //Apply Speed Penalty
        int currentWeight = determineWeight(defaultItems, defaultWeapon, 
                defaultMoney);
        try {playerStats.setSpeedPenalty(
        determineSpeedPenalty(playerStats.getSpeed(), playerStats.getStrength(),
                currentWeight));
            } catch (PlayerControlException e){
                ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
            username = "Invalid";
        }
        //Initialize New Player & Return
        Player newPlayer = new Player(username, race, age, defaultItems,
            defaultMoney, defaultWeapon, currentHealth, currentMana, 
            defaultDepositedItems, defaultDepositedMoney, playerStats,
            currentWeight);
        
        return newPlayer;
    }
    
    /* ********************************************************
    INITIALIZE NEW PLAYER STATS
    ********************************************************* */
    private Stats initializeNewPlayerStats (Races race, int age)
    {
        //Calculate Player Stats
        //HEALTH
        int health = (int)(Math.random() * 300);
        if (health < 100)
            health = 100;
        health += (race.getRaceName().equals("Human") ? 50 : 0);
        if (health > 300)
            health = 300;
        
        //MANA
        int mana = (int) (Math.random() * 200);
        if (mana < 50)
            mana = 50;
        mana += (race.getRaceName().equals("Elf") ? 50 : 0);
        if (mana > 200)
            mana = 200;
        
        //STRENGTH
        int strength = (int) (Math.random() * 100);
        if (strength < 10)
            strength = 10;
        strength += (race.getRaceName().equals("Dwarf") ? 10 : 0);
        if (strength > 100)
            strength = 100;

        //HIT RATE
        double hitRate = Math.random();
        if (hitRate < .1)
            hitRate = .1;
        if (hitRate > 1)
            hitRate = 1;
        
        //MAGIC
        int magic = (int) (Math.random() * 100 * age / 50);
        if (magic < 10)
            magic = 10;
        if (magic > 100)
            magic = 100;
        
        //DODGE RATE
        double dodgeRate = Math.random();
        if (dodgeRate < .1)
            dodgeRate = .1;
        if (dodgeRate > 1)
            dodgeRate = 1;

        //DEFENSE
        int defense = (int) (Math.random() * 100);
        if (defense < 10)
            defense = 10;
        defense += (race.getRaceName().equals("Dwarf") ? 10 : 0);
        if (defense > 100)
            defense = 100;

        //MAGIC DEFENSE
        int magicDefense = (int) (Math.random() * 100);
        if (magicDefense < 10)
            magicDefense = 10;
        if (magicDefense > 100)
            magicDefense = 100;

        //SPEED
        int speed = (int) (Math.random() * 100 * (100 - age) / 50);
        if (speed < 10)
            speed = 10;
        if (speed > 100)
            speed = 100;
        
        //***CALCULATE SPEED PENALTY SEPARATELY
        int speedPenalty = 0;
        
        Stats playerStats = new Stats(health, mana, strength, hitRate, magic, 
                dodgeRate, defense, magicDefense, speed, speedPenalty);
        
        return playerStats;
    }
    
    /* ********************************************************
    DETERMINE SPEED PENALTY
    ********************************************************* */
    public int determineSpeedPenalty(int speed, int strength, int weight)
    throws PlayerControlException
    {
        if(speed < 0)
            throw new PlayerControlException("You have to be faster than that.");
        
        if(strength < 1)
            throw new PlayerControlException("Invalid strength input.");

        int weightMinusStrength = weight - strength;
        //otherwise there is a penalty for any weight, this way speed is only 
        //penalized if weight is more than strength if(weightMinusStrengh < 0)
        if (weightMinusStrength < 0)
            return 0; 
        
        int penalty = (int) (speed * Math.pow(((weight - strength) / 
                (strength * strength)),2));
        
        if(penalty < 0)
            return 0;

        if(penalty > speed)
            return speed;

        return penalty;
    }
    
    /* ********************************************************
    DETERMINE WEIGHT
    ********************************************************* */
    public static int determineWeight (Item[] currentItems, Item currentWeapon, int money)
    {
        int weight = 0;
        
        for (Item items : currentItems)
        {
            weight += items.getWeight();
        }
        
        weight += currentWeapon.getWeight();
        
        weight += money / 100;  //Loss of precision from int is OK
        
        return weight;
    }
    
    /* ********************************************************
    DETERMINE WEIGHT LIMIT
    ********************************************************* */
    public int determineWeightLimit(int strength)
    {
        //Used for determining whether you can acquire new items or pick up
        //more money
        return strength * 3;
    }
    
    /* ********************************************************
    DETERMINE PLAYER WEIGHT
    ********************************************************* */
    public int determinePlayerCurrentWeight(Player player)
    {
        return determineWeight(player.getItems(), player.getWeapon(), 
                player.getMoney());
    }
    
    /* ********************************************************
    DETERMINE PLAYER WEIGHT LIMIT
    ********************************************************* */
    public int determinePlayerWeightLimit(Player player)
    {
        return determineWeightLimit(player.getPlayerStats().getStrength());
    }
}
