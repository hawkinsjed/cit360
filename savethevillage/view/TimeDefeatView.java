/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;


public class TimeDefeatView extends View
{
    public TimeDefeatView()
    {
        super("You have unfortunately run out of time for the game.  All of the"
            + "villagers have been captured and taken away by the monster."
            + "\n\nWould you like to return to the main menu?  (Y/N)");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        try
        {
            switch (choice)
            {
                case "Y":
                    return true;
                case "N":
                    this.console.print("Thank you for playing 'Save the Village'!  Come "
                        + "save our village again anytime!");
                    System.exit(0);
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
        return false;
    }
}
