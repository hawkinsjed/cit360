/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;
import saveTheVillage.control.MapControl;

import java.util.Scanner;



public class DungeonView extends View{
    
    public DungeonView(){
        
        super("\n"
            + "You hear the whistling of the wind as you venture deeper "
            + "into the dungeon. Each of your steps echoes ominously through "
            + "the vast, emptiness ahead and behind you."
            + "\nWhat do you choose to do?");
        // Need to pull dungeonEncounter
    }
    
    @Override
    public boolean doAction(String choice){
        
        choice = choice.toUpperCase();
        
        switch(choice){
            case "X":
                this.explore();
                break;
            case "M":
                this.move();
                break;
            case "Q":
                this.quit();
        }
        return false;
    }

    private void explore()
    {
        this.console.println("You search");
    }

    private void move()
    {
        this.console.println("You move");
    }

    private void quit()
    {
        System.exit(0);
    }
}