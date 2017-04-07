/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import java.util.Scanner;


    /* ********************************************************
    HELP MENU
    ********************************************************* */
public class HelpMenuView extends View{

    public HelpMenuView()
    {
        super(
              "\n\t------HELP--MENU------"
            + "\n\t| C – Basic Commands |"
            + "\n\t| G – Game Menu      |"
            + "\n\t| B – Battle         |"
            + "\n\t| E – Exit Menu      |"
            + "\n\t----------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        try
        {
            switch(choice)
            {
                case "C": // display 'basic commands menu'
                    this.displayBasicMenu();
                    break;
                case "G": // display 'game menu'
                    this.displayGameMenu();
                    break;
                case "B": // display 'battle menu'
                    this.displayBattleMenu();
                    break;
                case "E":
                    //Exit Menu
                    return true;
                default:
                    ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
            }
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        return false;
    }

    private void displayBasicMenu()
    {
        this.console.println(
                  "\n\t-----BASIC--COMMANDS-----"
                + "\n\t| B - Enter (Building)  |"
                + "\n\t| N – Move North        |"
                + "\n\t| S – Move South        |"
                + "\n\t| E – Move East         |"
                + "\n\t| W – Move West         |"
                + "\n\t| D - Enter/Exit Dungeon|"
                + "\n\t| X – Search            |"
                + "\n\t| P – Pick up an item   |"
                + "\n\t| U – Use an item       |"
                + "\n\t| C – Converse          |"
                + "\n\t| G – Game Menu         |"
                + "\n\t-------------------------");
        }

    private void displayBattleMenu()
    {
        this.console.println(
                  "\n\t---BATTLE--COMMANDS---"
                + "\n\t| A - Attack         |"
                + "\n\t| M - Use Magic      |"
                + "\n\t| I - Use Item       |"
                + "\n\t| R - Run Away       |"
                + "\n\t----------------------");
    }

    private void displayGameMenu()
    {
        //Create new 'Game Menu'
        GameMenuView gameMenu = new GameMenuView();        
        //Display 'Game Menu'
        gameMenu.display();
    }
}
