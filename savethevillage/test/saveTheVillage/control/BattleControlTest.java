/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.control.BattleControl;
import saveTheVillage.exceptions.BattleControlException;
import saveTheVillage.model.Actor;
import saveTheVillage.model.Player;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import savethevillage.SaveTheVillage;


public class BattleControlTest
{
    private static final PrintWriter logFile = SaveTheVillage.getLogFile();
    
    /**
     * Test of calcSuccessRate method, of class BattleControl.
     */
    @Test
    /* ********************************************************
    TEST CALCULATE SUCCESS RATE
    ********************************************************* */
    public void testCalcSuccessRate() throws BattleControlException
    {
        System.out.println("calcSuccessRate");

        System.out.println("calcSuccessRate Test #1");
        String action = "attack";
        double playerAttribute = .35;
        double enemyAttribute = .45;
        BattleControl instance = new BattleControl();
        boolean expError = false;
        double result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #2");
        action = "jump";
        playerAttribute = .35;
        enemyAttribute = .45;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #3");
        action = "attack";
        playerAttribute = -1;
        enemyAttribute = .45;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #4");
        action = "attack";
        playerAttribute = 110;
        enemyAttribute = .45;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #5");
        action = "attack";
        playerAttribute = .35;
        enemyAttribute = -1;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #6");
        action = "attack";
        playerAttribute = .35;
        enemyAttribute = 110;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #7");
        action = "attack";
        playerAttribute = -.01;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #8");
        action = "attack";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #9");
        action = "attack";
        playerAttribute = 1;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #10");
        action = "attack";
        playerAttribute = 1.01;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #11");
        action = "attack";
        playerAttribute = 0.0;
        enemyAttribute = -.01;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #12");
        action = "attack";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #13");
        action = "attack";
        playerAttribute = 0.0;
        enemyAttribute = 1;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #14");
        action = "attack";
        playerAttribute = 0.0;
        enemyAttribute = 1.01;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);

        System.out.println("calcSuccessRate Test #15");
        action = "run";
        playerAttribute = -1;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #16");
        action = "run";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #17");
        action = "run";
        playerAttribute = 100;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #18");
        action = "run";
        playerAttribute = 101;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #19");
        action = "run";
        playerAttribute = 0.0;
        enemyAttribute = -1;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #20");
        action = "run";
        playerAttribute = 0.0;
        enemyAttribute = 0.0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #21");
        action = "run";
        playerAttribute = 0.0;
        enemyAttribute = 100;
        instance = new BattleControl();
        expError = false;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
        
        System.out.println("calcSuccessRate Test #22");
        action = "run";
        playerAttribute = 0.0;
        enemyAttribute = 101;
        instance = new BattleControl();
        expError = true;
        result = instance.calcSuccessRate(action, playerAttribute, 
                enemyAttribute);
        if (expError)
            assert(result == -1);
        else
            assert(result >= 0 && result <= 1);
    }

    /**
     * Test of calcTotalDamage method, of class BattleControl.
     */
    @Test
    /* ********************************************************
    TEST CALCULATE TOTAL DAMAGE
    ********************************************************* */
    public void testCalcTotalDamage() throws BattleControlException {
        System.out.println("calcTotalDamage");

        System.out.println("calcTotalDamage Test #1");
        int baseDamage = 10;
        int offensiveAttribute = 10;
        double successRate = .25;
        int defensiveAttribute = 10;
        BattleControl instance = new BattleControl();
        boolean expError = false;
        int result = instance.calcTotalDamage(baseDamage, offensiveAttribute, 
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);
        
        System.out.println("calcTotalDamage Test #2");
        baseDamage = -1;
        offensiveAttribute = 10;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #2");
        baseDamage = 0;
        offensiveAttribute = 10;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #3");
        baseDamage = 10;
        offensiveAttribute = -1;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #4");
        baseDamage = 10;
        offensiveAttribute = 0;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #5");
        baseDamage = 10;
        offensiveAttribute = 100;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #6");
        baseDamage = 10;
        offensiveAttribute = 101;
        successRate = .25;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #7");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = -.01;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #8");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = 0.0;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #9");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = 1;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #10");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = 1.1;
        defensiveAttribute = 10;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #11");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = .25;
        defensiveAttribute = -1;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #12");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = .25;
        defensiveAttribute = 0;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #13");
        baseDamage = 10;
        offensiveAttribute = 10;
        successRate = .25;
        defensiveAttribute = 100;
        instance = new BattleControl();
        expError = false;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
        
        System.out.println("calcTotalDamage Test #14");
        baseDamage = 0;
        offensiveAttribute = 0;
        successRate = 0.0;
        defensiveAttribute = 101;
        instance = new BattleControl();
        expError = true;
        result = instance.calcTotalDamage(baseDamage, offensiveAttribute,
                defensiveAttribute, successRate);
        if (expError)
            assert (result == -1);
        else
            assert (result >= 0);        
    }

}