/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.control.PlayerControl;
import saveTheVillage.exceptions.PlayerControlException;
import saveTheVillage.model.Player;
import saveTheVillage.model.Stats;
import saveTheVillage.model.Item;
import saveTheVillage.model.Races;
import saveTheVillage.view.ErrorView;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerControlTest {
    
    public PlayerControlTest() {
    }

    /**
     * Test of initializeNewPlayer method, of class PlayerControl.
     */
    @Test
    /* ********************************************************
    TEST INITIALIZE NEW PLAYER
    ********************************************************* */
    public void testInitializeNewPlayer() {
        System.out.println("initializeNewPlayer");
        
        // **** TEST CASE 1 ****
        System.out.println("Test Case 1");
        
        //Variables
        String username = "Name";
        Races race = Races.HUMAN;
        int age = 35;
        
        //Create an instance
        PlayerControl instance = new PlayerControl();
        
        //Call the Function to Create a Player
        Player result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        Stats resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());

        // **** TEST CASE 2 ****
        System.out.println("Test Case 2");
        
        //Variables
        username = "Name";
        race = Races.HUMAN;
        age = 35;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */

        // **** TEST CASE 3 ****
        System.out.println("Test Case 3");
        
        /* NOTE:
        Test Case 3 on the test matrix will not be allowed to run as you
        cannot pass a string in as described in the place of an integer
        */
        System.out.println("ERROR:  Age must be an integer");

        // **** TEST CASE 4 ****
        System.out.println("Test Case 4");
        
        //Variables
        username = "None";
        race = Races.HUMAN;
        age = 24;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */

        // **** TEST CASE 5 ****
        System.out.println("Test Case 5");
        
        //Variables
        username = "None";
        race = Races.HUMAN;
        age = 76;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals("Invalid"));
        
        /* NOTE:
        No other attributes would be set with this function as it returns
        "Invalid" as the name once it determines the variables are
        not valid.
        */


        // **** TEST CASE 6 ****
        System.out.println("Test Case 6");
        
        //Variables
        username = "None";
        race = Races.HUMAN;
        age = 25;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());

        // **** TEST CASE 7 ****
        System.out.println("Test Case 7");
        
        //Variables
        username = "None";
        race = Races.HUMAN;
        age = 75;
        
        //Create an instance
        instance = new PlayerControl();
        
        //Call the Function to Create a Player
        result = instance.initializeNewPlayer(username, race, age);

        //Expected Results & Assertions
        assert(result.getName().equals(username));
        assert(result.getRace().equals(race));
        assert(result.getAge() == age);
        resultStats = result.getPlayerStats();
        assert (resultStats.getHealth() >= 100 && 
                resultStats.getHealth() <= 300);
        assert (resultStats.getMana() >= 50 && 
                resultStats.getMana() <= 200);
        assert (resultStats.getStrength() >= 10 && 
                resultStats.getStrength() <=100);
        assert (resultStats.getHitRate() >= .10 && 
                resultStats.getHitRate() <=1);
        assert (resultStats.getMagic() >= 10 && 
                resultStats.getMagic() <=100);
        assert (resultStats.getDodgeRate() >= .10 && 
                resultStats.getDodgeRate() <=1);
        assert (resultStats.getDefense() >= 10 && 
                resultStats.getDefense() <=100);
        assert (resultStats.getMagicDefense() >= 10 && 
                resultStats.getMagicDefense() <=100);
        assert (resultStats.getSpeed() >= 10 && 
                resultStats.getSpeed() <=100);
        assert (resultStats.getSpeedPenalty() >= 0);
        assert (result.getMoney() == 100);  //Starting Gold
        //Test weapon after inserting equivalence operator overloading for Item
        assert (result.getCurrentHealth() == resultStats.getHealth());
        assert (result.getCurrentMana() == resultStats.getMana());
    }
    
    /**
     * Test of determineSpeedPenalty method, of class PlayerControl.
     */
    @Test
    /* ********************************************************
    TEST DETERMINE SPEED PENALTY
    ********************************************************* */
    public void testDetermineSpeedPenalty()
    {
        try {
            System.out.println("determineSpeedPenalty Test #1");
            int speed = 50;
            int strength = 50;
            int weight = 50;
            int expResult = 0;
            PlayerControl instance = new PlayerControl();
            int result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #2");
            speed = -1;
            strength = 50;
            weight = 50;
            expResult = -1;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #3");
            speed = 50;
            strength = 0;
            weight = 50;
            expResult = -2;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #4");
            speed = 0;
            strength = 50;
            weight = 150;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #5");
            speed = 50;
            strength = 1;
            weight = 150;
            expResult = 50;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #6");
            speed = 100;
            strength = 100;
            weight = 0;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #7");
            speed = 100;
            strength = 100;
            weight = 100;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            System.out.println(result);
            assertEquals(expResult, result);
        } catch (PlayerControlException e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
    }
}
