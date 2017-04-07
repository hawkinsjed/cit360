/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import saveTheVillage.control.GameControl;
import saveTheVillage.exceptions.GameControlException;
import java.io.IOException;


public class SaveGameView extends View
{
    SaveGameView()
    {
        super("Do you wish to save the current game?  Enter Y or N");
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
        
        return true;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        switch (choice)
        {
                case "Y":
                //Get the File Name
                String fileName = promptFileName();
                
                try
                {
                    GameControl newGameControl = new GameControl();
                    newGameControl.saveGame(game, fileName);
                }
                catch (GameControlException e)
                {
                    ErrorView.display(this.getClass().getName(), e.getMessage());
                }
            
                return true;
            case "N":
                //Exit the menu
                return true;
            default:
                return false;
        }
    }
    
    public String promptFileName()
    {
        String fileName = "";
        this.console.println("Please enter the file name you would like to "
            + "save this game under:  ");
        
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
