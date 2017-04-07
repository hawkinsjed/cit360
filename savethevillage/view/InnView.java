/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.GameControl;
import saveTheVillage.control.SceneControl;
import saveTheVillage.model.Game;
import static java.lang.Integer.parseInt;



public class InnView extends View
{
    public InnView()
    {
        super ("As you enter the front foor of the Cartman, the faces of several people greet you. A jovial man at the counter\n"
            + "smiles and asks, “Would you like to take a break?  It’ll only cost you 5 gold per hour. The rooms are warm and\n"
            + "comfortable.”\nY or N:");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            //This function is not used - requires the doAction with the game
            ErrorView.display(this.getClass().getName(),"ERROR:  Must pass the Game as a parameter");
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        boolean exitMenu = false;
        choice = choice.toUpperCase();
        try
        {
            switch(choice)
            {
                case "Y":
                    this.restAtInn(game);
                    break;
                case "N":
                    exitMenu = true;
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\nYeah, that didn't work. Try again.");
            }
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                + e.getMessage());
        }
        return exitMenu;
    }

    /* ********************************************************
    REST AT INN
    ********************************************************* */
    private void restAtInn(Game game)
    {
        int value = 0;
        try
        {
            this.console.println("How many hours would you like to stay at our inn today?");
            value = parseInt(this.keyboard.readLine());
        }
        catch (Exception e)
        {
            ErrorView.display(this.getClass().getName(), e.getMessage());
        }
        
        //No need to do anything if not sleeping
        if (value == 0)
            return;
        
        if (value < 0 || value > 8)
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  You must "
            + "choose to sleep between 0 and 8 hours");
            
            return;
        }
        
        //Run the restAtInn function if player has enough money (5g per hour)
        if ((5 * value) <= game.getPlayer().getMoney())
        {
            SceneControl newSceneControl = new SceneControl();
            newSceneControl.restAtInn(game.getPlayer(), value);
            
            //Increment Time
            GameControl timeControl = new GameControl();
            timeControl.addTime(game, value * 60);

            
            this.console.println("After resting at the inn, your health has "
            + "recovered to " + game.getPlayer().getCurrentHealth() + " points.");
        }
        else
        {
            ErrorView.display(this.getClass().getName(), "Error:  Insufficient "
                + "money to complete transaction.");
        }
    }
}