/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.view;

import saveTheVillage.control.InventoryControl;
import saveTheVillage.model.Game;
import saveTheVillage.model.NPC;
import saveTheVillage.model.Clue;
import saveTheVillage.model.Item;
import saveTheVillage.control.SceneControl;
import saveTheVillage.exceptions.InventoryControlException;
import saveTheVillage.exceptions.SceneControlException;


public class CommunicationsView extends View
{
    int npcCount;
    
    CommunicationsView()
    {
        npcCount = 0;
        ErrorView.display(this.getClass().getName(), "ERROR:  Cannot use default constructor for "
            + "SceneView");
    }
    
    CommunicationsView(Game game)
    {
        npcCount = 0;
        String npcList = "";
        for(NPC thisNPC : (game.getIsInDungeon() ? game.getDungeonMap().getScene(game.getCurrentRow(), game.getCurrentColumn()).getNPC() :
            game.getForestMap().getScene(game.getCurrentRow(), game.getCurrentColumn()).getNPC()))
        {
            if (!thisNPC.getNPCName().equals("None") && !thisNPC.getCaptured())
            {
                npcCount++;
                npcList += (npcCount > 0 ? "\n" : "") + thisNPC.getNPCName();
            }
        }

        this.console.println((npcCount > 0 ? "The following NPC" + (npcCount == 
            1 ? " is " : "'s are ") + "available for conversation:\n" + npcList 
            + "\nWhich " + "NPC would you like to converse with?  Enter "
            + "\"None\" to Quit\n (Note:  Names are case-sensitive)" : "There are "
            + "no NPC's with whom you can converse right now"));
    }
    
    @Override
    public String getInput()
    {
        String value = null;
        boolean valid = false;
        
        try{
        while(!valid){
            this.console.println("\n" + this.displayMessage);
            value = this.keyboard.readLine();
            value = value.trim();
            
            if(value.length() < 1){ //blank value entered
                ErrorView.display(this.getClass().getName(), "\nSorry? What was that?");
                continue;
            }
            break;
        }
        } catch (Exception e){
            ErrorView.display(this.getClass().getName(), "Unable to determine your needs " + e.getMessage());
        }
        return value;
    }

    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(), "ERROR:  Required to pass Game as a parameter");
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game)
    {
        //No conversations can take place if no NPC's exist at the location
        //No NPC's exist in the dungeon
        if (npcCount < 1 || game.getIsInDungeon())
            return false;
        
        //If player said None, then no need to continue here
        if (choice.equals("None"))
            return true;
        
        //Test to see if the NPC actually exists
        NPC thisNPC = new NPC();
        SceneControl newSceneControl = new SceneControl();
        try
        {
            thisNPC = newSceneControl.validateNPC(choice, game.getForestMap().getScene(
            game.getCurrentRow(), game.getCurrentColumn()));
        }
        catch (SceneControlException sce)
        {
            ErrorView.display(this.getClass().getName(), sce.getMessage());
            return true;
        }
        
        //If the NPC has been captured, you cannot converse with them
        if (thisNPC.getCaptured())
        {
            ErrorView.display(this.getClass().getName(), "ERROR:  This person has "
                + "been captured.  You must free this person to ever have a chance "
                + "to speak to them again.");
            return true;
        }
        
        //Choice between NPC's Clue and Completed Quest Dialogue
        Clue currentClue = game.getClue(thisNPC.getAssociatedScene());
        if (currentClue.getClueObtained() && currentClue.getRetrieved())
        {
            //If original clue was obtained and item received indicator set,
            //display the completed quest dialogue
            this.console.println(currentClue.getCompletedQuest());
            
            //If not previously completed, set completed to true and receive item
            if (!currentClue.getCompleted())
            {
                game.getClue(thisNPC.getAssociatedScene()).setCompleted(true);
            
                //If there is an item reward associated with the clue, load it
                //into inventory
                InventoryControl newInventoryControl = new InventoryControl();
                try
                {
                    Item npcReward = newSceneControl.retrieveClue(game).getNPCReward();
                    
                    //Add the Item to Inventory
                    newSceneControl.retrieveClue(game).setRetrieved(
                    newInventoryControl.addItemToInventory(npcReward,game.getPlayer()));
                }
                catch (InventoryControlException ice)
                {
                    ErrorView.display(this.getClass().getName(),ice.getMessage());
                }
            }
        }
        else
        {
            //Display the NPC's clue
            this.console.println(currentClue.getNPCClue());
            
            //Set the clue to having been viewed if not already done so in game
            game.getClue(thisNPC.getAssociatedScene()).setClueObtained(true);
        }
        
        return true;
    }
}
