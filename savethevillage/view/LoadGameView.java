/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.GameControl;
import saveTheVillage.exceptions.GameControlException;
import saveTheVillage.model.Game;


public class LoadGameView extends View
{
    LoadGameView()
    {
        super("Do you wish to load a new game?  Enter Y or N");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        Game loadedGame = null;
        
        if (choice.equals("Y"))
        {
            //Get the File Name
            String fileName = promptFileName();
            
            try
            {
                GameControl newGameControl = new GameControl();
                loadedGame = newGameControl.loadGame(fileName);
            }
            catch (GameControlException e)
            {
                ErrorView.display(this.getClass().getName(), e.getMessage());
            }
        }
        
        //Load the Game into View
        GameStartView newGameStartView = new GameStartView();
        newGameStartView.display(loadedGame);

        return true;
    }
    
    public String promptFileName()
    {
        String fileName = "";
        this.console.println("Please enter the file name you would like to "
            + "load:  ");
        
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
