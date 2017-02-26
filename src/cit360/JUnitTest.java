/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.saveTheVillage.control;

import byui.cit260.saveTheVillage.exceptions.PlayerControlException;
import byui.cit260.saveTheVillage.model.Player;
import byui.cit260.saveTheVillage.model.Stats;
import byui.cit260.saveTheVillage.model.Item;
import byui.cit260.saveTheVillage.model.Races;
import byui.cit260.saveTheVillage.view.ErrorView;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerControlTest {
    
    public PlayerControlTest() {
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
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #2");
            speed = -1;
            strength = 50;
            weight = 50;
            expResult = -1;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #3");
            speed = 50;
            strength = 0;
            weight = 50;
            expResult = -2;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #4");
            speed = 0;
            strength = 50;
            weight = 150;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #5");
            speed = 50;
            strength = 1;
            weight = 150;
            expResult = 50;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #6");
            speed = 100;
            strength = 100;
            weight = 0;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
            
            System.out.println("determineSpeedPenalty Test #7");
            speed = 100;
            strength = 100;
            weight = 100;
            expResult = 0;
            result = instance.determineSpeedPenalty(speed, strength, weight);
            assertNotNull(result);
            System.out.println(result);
            assertEquals(expResult, result);
        } catch (PlayerControlException e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
                /********************************
         * Additional Test Cases
         */
            // Below are examples of other test cases found on the following URL
            // https://github.com/junit-team/junit4/wiki/Assertions
            
            // This will be true as the byte array will be identical between the two using the same input of "trial"
            System.out.println("\tTest case - assertArrayEquals");
            byte[] expected = "trial".getBytes();
            byte[] actual = "trial".getBytes();
            assertArrayEquals(expected, actual);
            
            // This will be true, since it is being handed the boolean value of false
            System.out.println("\tTest case - assertFalse");
            assertFalse(false);
            
            // These will not be the same as they are different instantiations of the class Object
            System.out.println("\tTest case - assertNotSame");
            assertNotSame(new Object(), new Object());
            
            // This will be true, since it is being handed no value at all
            System.out.println("\tTest case - assertNull");
            assertNull(null);
            
            // This will be true since you are comparing the exact same object to itself.
            System.out.println("\tTest case - assertSame");
            Integer aNumber = 768;
            assertSame(aNumber, aNumber);
            
            // This will be true, since it is being handed the boolean value of true
            System.out.println("\tTest case - assertTrue");
            assertTrue(true);
    }
    }
}
