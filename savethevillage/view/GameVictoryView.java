/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;


public class GameVictoryView extends View
{
    GameVictoryView()
    {
        super("Congratulations!  You have defeated the Minotaur boss!  The "
            + "captured villagers have bee freed, and the village can now "
            + "peacefully continue because of your help.\n\nWould you like to "
            + "return to the main menu?  (Y/N)");
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
