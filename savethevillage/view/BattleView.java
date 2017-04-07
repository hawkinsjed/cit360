/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Actor;
import saveTheVillage.model.Player;
import saveTheVillage.control.BattleControl;
import saveTheVillage.exceptions.BattleControlException;
import saveTheVillage.exceptions.InventoryControlException;


public class BattleView extends View
{
    private boolean validView;
    private Actor enemy;
    private BattleControl newBattleControl;
    private String battleMenu;
    private boolean playerTurn;
    private boolean defeated;
    private int damage;
    
    private int damageBonus;
    private double hitRateBonus;
    private double dodgeRateBonus;
    private int speedBonus;
    private int defenseBonus;
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public BattleView()
    {
        battleMenu = ("\n\t---BATTLE--COMMANDS---"
                + "\n\t| A - Attack         |"
                + "\n\t| M - Use Magic      |"
                + "\n\t| I - Use Item       |"
                + "\n\t| R - Run Away       |"
                + "\n\t----------------------");
        double random = Math.random();
        if (random >= .5)
        {
            playerTurn = true;
        }
        else
        {
            playerTurn = false;
        }
        defeated = false;
    
        damageBonus = 0;
        hitRateBonus = 0;
        dodgeRateBonus = 0;
        speedBonus = 0;
        defenseBonus = 0;
    
    }
    
    /* ********************************************************
    DISPLAY BATTLE VIEW
    ********************************************************* */
    public boolean displayBattleView(String scene, Player player)
    {
        //Error Trapping
        if (scene.equals("Invalid"))
        {
            validView = false;
        }
        else
        {
            validView = true;
        }
        
        //Create a new enemy
        newBattleControl = new BattleControl();
        try
        {
            enemy = newBattleControl.initializeEnemy(scene);
        }
        catch (InventoryControlException ice)
        {
            this.console.println(ice.getMessage());
            return false;
        }
        //This view will only display if the non-default constructor was used

        this.console.println("While traveling through this area, you have "
                + "encountered an enemy " + enemy.getName() +
                ".  Prepare for battle...");

        if (validView)
        {
            boolean done = false;
            
            //The battle view will loop until the player or enemy's HP drops
            //to zero or the player successfully runs away
            do
            {
                if (playerTurn)
                {
                    this.console.println("Current Health:  " + 
                            player.getCurrentHealth());
                    this.console.println("Current Mana:  " + 
                            player.getCurrentMana());
                    String menuOption = this.getPlayerAction();
                    if(menuOption.toUpperCase().equals("R"))
                    {
                        done = doRun(player);
                    }
                    else
                    {
                        doAction(menuOption, player);
                        
                        if (enemy.getCurrentHealth() <= 0)
                        {
                            //Victory
                            done = true;
                            gotoBattleVictoryView(player);
                        }
                    }
                }
                else //Enemy Turn
                {
                    doAttack(false, player);
                    
                    if (player.getCurrentHealth() <= 0)
                    {
                        //Defeated
                        done = true;
                        defeated = true;
                        gotoBattleDefeatView();
                        this.console.println("Doesn't look like it's your day "
                                + "- You have been defeated.");
                    }
                }
                
                //Switch Turns
                playerTurn = !playerTurn;
            }while(!done);
        }
        else
        {
            //Player has not been defeated, but no battle scene occurred and
            //game would continue as normal
            return defeated;
        }
        
        //Return victory or defeat
        return defeated;
    }
    
    /* ********************************************************
    GET PLAYER ACTION
    ********************************************************* */
    public String getPlayerAction()
    {
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid){
            this.console.println("\n" + this.battleMenu);
            value = this.keyboard.readLine(); //get the next lined entered from keyboard
            value = value.trim();
            value = value.toUpperCase();
            
            if(value.length() < 1){
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }} catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return value;
    }
    
    /* ********************************************************
    DO ACTION
    ********************************************************* */
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
    
    public boolean doAction(String menuOption, Player player)
    {
        menuOption = menuOption.toUpperCase();
        try
        {
            switch(menuOption)
            {
                case "A":  //Attack
                    doAttack(true, player);
                    break;
                case "M":  //Use Magic
                    doMagic(player);
                    break;
                case "I":  //Use Item
                    doItem(player);
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
            }
        }
        catch(Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        return false;
    }
    
    /* ********************************************************
    DO ATTACK
    ********************************************************* */
    public void doAttack(boolean playerTurn, Player player)
    {
        BattleControl thisControl = new BattleControl();
        
        if (playerTurn)  //Player Attack
        {
            this.console.println("You attack the enemy " + enemy.getName() + ".");
            try
            {
                //Set Bonus Caps
                double hitRate = player.getPlayerStats().getHitRate() + hitRateBonus;
                if (hitRate > 1)
                    hitRate = 1;
                
                //Determine Success Rate & Damage
                double successRate = thisControl.calcSuccessRate("A", hitRate,
                        enemy.getEnemyStats().getDodgeRate());
                int damage = thisControl.calcTotalDamage(
                        player.getWeapon().getWeaponDamage() + damageBonus,
                        player.getPlayerStats().getStrength(),
                        enemy.getEnemyStats().getDefense(), successRate);
                if (damage > 0)
                {
                    //Deal Damage
                    enemy.setCurrentHealth((enemy.getCurrentHealth()
                            - damage) < 0 ? 0 : enemy.getCurrentHealth() -
                                    damage);
                }
                
                this.console.println("Attack Damage Dealt: " +
                        damage);
            }
            catch (BattleControlException ex)
            {
                this.console.println(ex.getMessage());
            }
        }
        else          
        {
            this.console.println("The enemy " + enemy.getName() + " attacks you.");
            try //Enemy Attack
            {
                //Set Bonus Caps
                double dodgeRate = player.getPlayerStats().getDodgeRate() + dodgeRateBonus;
                if (dodgeRate > 1)
                    dodgeRate = 1;
                int defense = player.getPlayerStats().getDefense() + defenseBonus;
                if (defenseBonus > 100)
                    defense = 100;
                
                //Determine Success Rate & Damage
                double successRate = thisControl.calcSuccessRate("A",
                        enemy.getEnemyStats().getHitRate(), dodgeRate);
                
                int damage = thisControl.calcTotalDamage(0,
                        enemy.getEnemyStats().getStrength(), defense,
                        enemy.getEnemyStats().getHitRate());
                
                if (damage > 0)
                {
                    //Deal Damage
                    player.setCurrentHealth((player.getCurrentHealth()
                            - damage) < 0 ? 0 : player.getCurrentHealth() -
                                    damage);
                }
                
                this.console.println("Attack Damage Received: " + damage);
            }
            catch (BattleControlException ex)
            {
                this.console.println(ex.getMessage());
            }
        }
    }
    
    /* ********************************************************
    DO MAGIC
    ********************************************************* */
    public void doMagic(Player player)
    {
        //Call Spell View
        SpellView newSpellView = new SpellView(player.getRace());
        newSpellView.display(player, enemy, damageBonus, hitRateBonus, 
            dodgeRateBonus, speedBonus, defenseBonus);
    }
    
    /* ********************************************************
    DO ITEM
    ********************************************************* */
    public void doItem(Player player)
    {
        UseItemView newUseItemView = new UseItemView();
        newUseItemView.display(player, enemy, damageBonus, hitRateBonus, 
            dodgeRateBonus, speedBonus, defenseBonus);
    }
    
    /* ********************************************************
    DO RUN
    ********************************************************* */
    public boolean doRun(Player player)
    {
        //Determine if player successfully runs away
        BattleControl thisControl = new BattleControl();
        try
        {
            //Bonus Caps
            int speed = player.getPlayerStats().getSpeed() + speedBonus;
            if (speed > 100)
                speed = 100;
            
            if (thisControl.calcSuccessRate("R",
                player.getPlayerStats().getSpeed(), 
                enemy.getEnemyStats().getSpeed()) >= .5)
            { 
                this.console.println("You have successfully escaped"
                    + "the enemy - You will live to see another "
                    + "day.");
                return true; 
            }
            else
            {
                this.console.println("Sorry, you were not able to get "
                    + "away - try again if you survive this "
                    + "next round.");
            }
        
        }
        catch (BattleControlException ex)
        {
                this.console.println(ex.getMessage());
        }
    return false;
    }
    
    /* ********************************************************
    GO TO BATTLE VICTORY VIEW
    ********************************************************* */
    public void gotoBattleVictoryView(Player player)
    {
        BattleVictoryView newBattleVictory = new BattleVictoryView();
        newBattleVictory.display(player, enemy);
    }

    /* ********************************************************
    GO TO BATTLE VICTORY VIEW
    ********************************************************* */
    public void gotoBattleDefeatView()
    {
        BattleDefeatView newBattleDefeat = new BattleDefeatView();
        newBattleDefeat.display();
    }
}
