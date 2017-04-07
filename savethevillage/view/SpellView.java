/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Races;
import saveTheVillage.model.Player;
import saveTheVillage.model.Actor;
import saveTheVillage.model.Spell;
import saveTheVillage.model.Item;
import static java.lang.Integer.parseInt;


public class SpellView extends View
{
    SpellView()
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Cannot use default constructor for "
            + "SpellView");
    }
    
    SpellView(Races race)
    {
        super("The following spells are available for you to use:"
            + "\nSpell 1:  " + race.getSpell1().getSpellName()
            + "\n" + race.getSpell1().getSpellDescription()
            + "\n\nSpell 2:  " + race.getSpell2().getSpellName()
            + "\n" + race.getSpell2().getSpellDescription()
            + "\n\nSpell 3:  " + race.getSpell3().getSpellName()
            + "\n" + race.getSpell3().getSpellDescription()
            + "\n\nPlease enter the spell number you would like to use, or 0 to Exit:");
    }
    
    SpellView(Item scroll)
    {
        super("You are using the following spell from a scroll:\n" + 
            scroll.getAssociatedSpell().getSpellName() + "\n" + 
            scroll.getAssociatedSpell().getSpellDescription());
    }
    
    public void display(Player player, Actor enemy, int damageBonus,
        double hitRateBonus, double dodgeRateBonus, int speedBonus,
        int defenseBonus)
    {
        //Unable to use a spell if the player doesn't have enough mana
        if (player.getCurrentMana() < 10)
        {
            ErrorView.display(this.getClass().getName(), "Insufficient Mana to Cast Spells");
        }
        boolean done = false;
        do
        {
            int value = parseInt(this.getInput());
            //Determine the spell to be used
            Spell spell = Spell.HealingWind;  //Base Initialization
            boolean valid = false;
            switch (value)
            {
                case 0:
                    done = true;
                    break;
                case 1:
                    spell = player.getRace().getSpell1();
                    valid = true;
                    break;
                case 2:
                    spell = player.getRace().getSpell2();
                    valid = true;
                    break;
                case 3:
                    spell = player.getRace().getSpell3();
                    valid = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "Invalid Spell Selection Choice");
            }
            
            if (valid)
            {
                done = this.doAction(spell, player, enemy, damageBonus, 
                    hitRateBonus, dodgeRateBonus, speedBonus, defenseBonus);
            }
        } while(!done);
    }
    
    public void display(Item scroll, Player player, Actor enemy, int damageBonus,
        double hitRateBonus, double dodgeRateBonus, int speedBonus,
        int defenseBonus)
    {
        boolean done = false;
        do
        {
            done = this.doAction(scroll.getAssociatedSpell(), player, enemy,
                damageBonus, hitRateBonus, dodgeRateBonus, speedBonus, defenseBonus);
        } while(!done);
    }
    
    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Multiple Items as a parameter");
        return false;
    }
    
    public boolean doAction(Spell spell, Player player, Actor enemy,
        int damageBonus, double hitRateBonus, double dodgeRateBonus,
        int speedBonus, int defenseBonus)
    {
        //Use the spell
        switch (spell)
        {
            case HealingWind:
                //Heal the player for 50 points of health
                this.console.println("You use the spell Healing Wind, healing "
                    + "yourself for 50 health points.");
                int newPlayerHealth = player.getCurrentHealth() + 50;
                if (newPlayerHealth > player.getPlayerStats().getHealth())
                    newPlayerHealth = player.getPlayerStats().getHealth();
                player.setCurrentHealth(newPlayerHealth);
                break;
            case Fireburst:
                //75 Points Damage to Enemy
                this.console.println("You use the spell Fireburst, inflicting "
                    + "75 points of damage to the enemy.");
                enemy.setCurrentHealth(enemy.getCurrentHealth() - 75);
                break;
            case SteelBlade:
                //35 Points Bonus Damage per Attack
                this.console.println("You use the spell Steel Blade, increasing "
                    + "your total attack damage output each turn by 35.");
                damageBonus += 35;
                break;
            case SwiftWind:
                //Increase Hit Rate by 15%
                this.console.println("You use the spell Swift Wind, increasing "
                    + "your accuracy by 15%.");
                hitRateBonus += .15;
                break;
            case BlindingLight:
                //Increase Dodge Rate by 15%
                this.console.println("You use the spell Blinding Light, increasing "
                    + "your ability to dodge by 15%");
                dodgeRateBonus += .15;
                break;
            case IceBlade:
                //Deal 30 Points Damage and Slow Enemy by 10 Points
                this.console.println("You use the spell Ice Blade, dealing 30 "
                    + "points of damage while slowing the enemy 10 points.");
                enemy.setCurrentHealth(enemy.getCurrentHealth() - 30);
                int newEnemySpeed = enemy.getEnemyStats().getSpeed() - 10;
                if (newEnemySpeed <1)
                    newEnemySpeed = 1;
                enemy.getEnemyStats().setSpeed(newEnemySpeed);
                break;
            case Earthquake:
                this.console.println("You use the spell Earthquake, sacrificing "
                    + "25 points in health to deal 100 points of damage.");
                player.setCurrentHealth(player.getCurrentHealth() - 25);
                enemy.setCurrentHealth(enemy.getCurrentHealth() - 100);
                break;
            case IronBody:
                this.console.println("You use the spell Iron Body, increasing "
                    + "your defense by 15 points.");
                defenseBonus += 15;
                break;
            case DecimatingBlow:
                this.console.println("You use the spell Decimating Blow, inflicting "
                    + "10 points of damage and increasing attack damage by 25 points.");
                enemy.setCurrentHealth(enemy.getCurrentHealth() - 10);
                damageBonus += 25;
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Spell");
                return false;
        }
        
        //Reduce Mana
        player.setCurrentMana(player.getCurrentMana() - 10);
        return true;
    }
}
