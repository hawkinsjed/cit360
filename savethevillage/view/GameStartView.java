/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.model.Game;
import saveTheVillage.model.Scene;

public class GameStartView extends View
{
    GameStartView()
    {
        super("\nWelcome to 'Save The Village'.  Your goal is to locate and "
            + "defeat the main boss before all \nthe townspeople have been "
            + "taken.  Good luck!");
    }
    
    @Override
    public String getInput()
    {
        this.console.println(super.displayMessage);
        return "";
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the Game as a parameter");
        } catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        //Loop displaying scenes until the game has finished
        do
        {
            //Display Scene Menu
            SceneView newSceneView = new SceneView(game);
            newSceneView.display(game);
            
        } while (!game.getGameFinished());
        return true;
    }
}
