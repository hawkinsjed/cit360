/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import saveTheVillage.model.Player;
import saveTheVillage.model.Stats;
import java.io.PrintWriter;


public class PrintPlayerStatisticsView extends View
{
    PrintPlayerStatisticsView()
    {
        super("Would you like to print this report to a file? (Y/N)");
    }
    
    public void display(Player player)
    {
        boolean done = false;
        do
        {
            String value = this.getInput();
            done = this.doAction(value, player);
        } while(!done);
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the "
                + "Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }

    public boolean doAction(String choice, Player player)
    {
        boolean valid = false;
        switch (choice)
        {
            case "Y":
                printStatistics(player);
                break;
            case "N":
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\nSorry? "
                    + "What was that?");
                return false;
        }
        
        return true;
    }

    /* ********************************************************
    PRINT STATISTICS
    ********************************************************* */
    private void printStatistics(Player player)
    {
            //Get the File Name
            String fileName = promptFileName();
            
            try (PrintWriter out = new PrintWriter(fileName))
            {
                out.println("PLAYER STATISTICS FOR:  " + player.getName());
                
                out.println("\n\tHEALTH & MANA\n");
                out.printf("%-19s","\tHEALTH:");
                out.printf("%-4d", player.getCurrentHealth());
                out.print(" / ");
                out.printf("%-4d", player.getPlayerStats().getHealth());
                out.println();
                out.printf("%-19s", "\tMANA:");
                out.printf("%-4d", player.getCurrentMana());
                out.print(" / ");
                out.printf("%-4d", player.getPlayerStats().getMana());
                out.println();
                
                out.println("\n\tPLAYER STATS\n");
                out.printf("%-19s", "\tSTRENGTH:");
                out.printf("%-2d", player.getPlayerStats().getStrength());
                out.println();
                out.printf("%-19s", "\tHIT RATE:");
                out.printf("%1.2f", player.getPlayerStats().getHitRate());
                out.println();
                out.printf("%-19s", "\tMAGIC:");
                out.printf("%-2d", player.getPlayerStats().getMagic());
                out.println();
                out.printf("%-19s", "\tDODGE RATE:");
                out.printf("%1.2f", player.getPlayerStats().getDodgeRate());
                out.println();
                out.printf("%-19s", "\tDEFENSE:");
                out.printf("%-2d", player.getPlayerStats().getDefense());
                out.println();
                out.printf("%-19s", "\tMAGIC DEFENSE:");
                out.printf("%-2d", player.getPlayerStats().getMagicDefense());
                out.println();
                out.printf("%-19s", "\tSPEED:");
                out.printf("%-19s", (player.getPlayerStats().getSpeed() -
                player.getPlayerStats().getSpeedPenalty()));
                out.println();
                
                this.console.println("Successfully Printed Player Statistics to"
                    + " " + fileName);
            }
            catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "Print Player " +
                    "Statistics Report Failure:  " + e.getMessage());
            }
    }
    
    public String promptFileName()
    {
        String fileName = "";
        this.console.println("Please enter the file name where you would like "
            + "to save the player statistics:  ");
        
        try
        {
            fileName = this.keyboard.readLine();
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  Unable to "
                + "read from console");
        }
        
        return fileName;
    }
}
