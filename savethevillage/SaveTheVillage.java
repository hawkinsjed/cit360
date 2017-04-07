package savethevillage;



import saveTheVillage.model.Actor;
import saveTheVillage.model.Game;
import saveTheVillage.model.Item;
import saveTheVillage.model.Map;
import saveTheVillage.model.Player;
import saveTheVillage.model.Location;
import saveTheVillage.model.NPC;
import saveTheVillage.model.Scene;
import saveTheVillage.model.Stats;
import saveTheVillage.model.Races;
import saveTheVillage.model.Spell;
import saveTheVillage.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveTheVillage {
 
    private static Game currentGame = null;
    private static Player player = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    
    public static void main(String args[]){
    
        try
        {
            SaveTheVillage.inFile = new BufferedReader(new InputStreamReader(System.in));
            SaveTheVillage.outFile = new PrintWriter(System.out, true);
            
            // Open log file
            String filePath = "log.txt";
            SaveTheVillage.logFile = new PrintWriter(filePath);
        
            //Create Start Program and display the program view
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.displayStartProgramView();
            return;
        }
        catch (Throwable e)
        {
            System.out.println("Exception: " + e.toString()
                + "\nCause: " + e.getCause()
                + "\nMessage: " + e.getMessage());
            e.printStackTrace();;
        }
        finally
        {
            try
            {
                if (SaveTheVillage.inFile != null)
                    SaveTheVillage.inFile.close();
                    
                if (SaveTheVillage.outFile != null)
                    SaveTheVillage.outFile.close();
                
                if (SaveTheVillage.logFile != null)
                    SaveTheVillage.logFile.close();
            }
            catch (IOException ex)
            {
                System.out.println("Error closing files");
                return;
            }
        }
    }
    
    /* ********************************************************
    GETTER / SETTER FUNCTIONS
    ********************************************************* */
    public static PrintWriter getOutFile()
    {
        return outFile;
    }
    
    public static void setOutFile(PrintWriter outFile)
    {
        SaveTheVillage.outFile = outFile;
    }
    
    public static BufferedReader getInFile()
    {
        return inFile;
    }
    
    public static void setInFile(BufferedReader inFile)
    {
        SaveTheVillage.inFile = inFile;
    }
    
    public static PrintWriter getLogFile()
    {
        return logFile;
    }
    
    public static void setLogFile(PrintWriter logFile)
    {
        SaveTheVillage.logFile = logFile;
    }

    public static void setCurrentGame(Game game)
    {
        SaveTheVillage.currentGame = currentGame;
    }

    public static Game getGetCurrentGame()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}