/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.model.Game;
import saveTheVillage.model.Map;
import saveTheVillage.model.Player;
import saveTheVillage.model.Clue;
import saveTheVillage.model.Scene;
import saveTheVillage.model.NPC;
import saveTheVillage.exceptions.GameControlException;
import saveTheVillage.exceptions.InventoryControlException;
import saveTheVillage.model.Item;
import saveTheVillage.view.ErrorView;
import saveTheVillage.view.TimeDefeatView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GameControl
{
    /* ********************************************************
    INITIALIZE NEW GAME
    ********************************************************* */
    public Game initializeNewGame(Player player)
        throws InventoryControlException
    {
        //Create a new random forest and dungeon map
        MapControl mapControl = new MapControl();
        Map forestMap = new Map("Forest");
        Map dungeonMap = new Map("Dungeon");
        
        try
        {
            mapControl.initializeMap(forestMap);
            mapControl.initializeMap(dungeonMap);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Set the Clues
        Clue[] clues = new Clue[11];
        
        for (Clue clue : clues)
        {
            clue = new Clue();
        }
        setClues(forestMap, clues);
        
        
        //Set the starting scene as visited
        forestMap.getScene(2, 2).setVisited(true);
        
        //Create the new game
        Game newGame = new Game(0, (60*60), false, clues, forestMap, dungeonMap, player);

        return newGame;
    }
    
    /* ********************************************************
    SET CLUES
    ********************************************************* */
    public void setClues(Map forestMap, Clue clues[]) 
    throws InventoryControlException
    {
        String direction = "";
        int clueCounter = 0;
        MapControl newMapControl = new MapControl();
        boolean dungeonLocated = false;
        
        InventoryControl inventoryControl = new InventoryControl();

        //Create item rewards
        Item defaultItem = Item.None;
        Item healthReward = Item.LargeHealthPotion;
        Item manaReward = Item.LargeManaPotion;
        Item scrollReward1 = Item.None;
        Item scrollReward2 = Item.None;
        try
        {
            scrollReward1 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
            scrollReward2 = inventoryControl.randomizeItem((int)
                (Math.random() * 1200 % 12) + 88);
        }
        catch (InventoryControlException ice)
        {
            throw new InventoryControlException(ice);
        }
        
        //Loop through the forest map until the dungeon entrance has been located
        for (Scene[] sceneRow : forestMap.getSceneArray())
        {
            for (Scene scene : sceneRow)
            {
                if (scene.getName().equals("Entrance"))
                {
                    direction = newMapControl.getQuadrant(scene);
                    dungeonLocated = true;
                }
                
                if (dungeonLocated)
                {
                    break;
                }
            }
            if (dungeonLocated)
            {
                break;
            }
        }

        //Loop through the forest map until all 10 clues have been found & loaded
        for (Scene[] sceneRow : forestMap.getSceneArray())
        {
            for (Scene scene : sceneRow)
            {
                switch (scene.getName())
                {
                    case "Key":
                        clues[clueCounter] = new Clue("Key",
                        //NPC Comment
                        "“My friend took his mule out that way <<" + newMapControl.getQuadrant(scene) + ">>"
                        + "\nto go and gather some wood from the ol’ oak.” Bob leans in and \n"
                        + "whispers, “‘Round here it is well known that any wood gathered \n"
                        + "from the ol’ oak will burn brighter and ‘otter than any other wood \n"
                        + "in the entirety of the forest.” He nods sagely and leans back, \n"
                        + "“Anyhow, my friend and his mule went out there about a \n"
                        + "fortnight ago and ain’t been seen back since. I was just \n"
                        + "about to head out that way to see if I could help ‘im out, but \n"
                        + "if your headed out that way I s’pose I won’t need to. Quite \n"
                        + "obliged to ya.” He then smiles, places a toothpick in his \n"
                        + "mouth and begins to hum as he wanders away.",
                        //Scene Description
                        "You see a fish arc out of the water, a spray of drops reflecting the \n"
                        + "light from the sun. As it splashes back into the pond, you see the \n"
                        + "reflection of a metallic object in the water. You reach down and pull out\n" 
                        + "the <<Dungeon Key>>. You also find the half eaten carcass of a rather large\n"
                        + "fish sitting on a rock not too far from where you found the key.\n",
                        //Completed Quest Dialogue
                        "Quest Completed", 
                        Item.DungeonKey, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks1":
                        clues[clueCounter] = new Clue("Tracks1",
                        //NPC Comment
                        "“As I was out hanging up my wash the other week, I noticed a strange \n"
                        + "looking shadow staring toward town. It was over there,” Vixen \n"
                        + "points toward <<" + newMapControl.getQuadrant(scene) + ">> and then continues, “It was a \n"
                        + "big shape and had, now don’t think that I’m telling tales now, but \n"
                        + "it looked like it had some huge horns. Do you think it may have been\n"
                        + "a demon sent to punish me for spreading tales?” She then sits down on \n"
                        + "a nearby basket and begins to brood. There is no more that she will say.",
                        //Scene Description
                        "You look around, and as you near the oak tree you notice what looks like a \n"
                        + "wide, straight line of disturbed rocks heading to the <<" + direction + ">>.", 
                        //Completed Quest Dialogue
                        "Quest Completed", 
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks2":
                        clues[clueCounter] = new Clue("Tracks2",
                        //NPC Comment
                        "As you approach, you find Sandy appears extremely distraught. Her \n"
                        + "cheeks are tear stained and her eyes are extremely puffy. She \n"
                        + "looks at you and, between sobs, says, “My husband, Farmer Joe, he \n"
                        + "went out to check on the farm two mornings back. He is a wonderful \n"
                        + "man, my Farmer Joe, never has he been gone as long as this. \n"
                        + "Everyone told him not to go, I even begged him mighty fierce, but \n"
                        + "he just said that the crops need to be taken care of else no one \n"
                        + "was going to have anything to eat this winter. He is such a kind \n"
                        + "man, my husband, always thinking of others. Anyway, the farm is \n"
                        + "over there <<" + newMapControl.getQuadrant(scene) + ">>. Please, please find \n"
                        + "and save my husband.” She falls down on her knees, sobbing.",
                        //Scene Description
                        "A thorough search of the area reveals a set of deep imprints in the \n"
                        + "ground next to a tree. A trail leads to and from <<" + direction + ">>.", 
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Tracks3":
                        clues[clueCounter] = new Clue("Tracks3",
                        //NPC Comment
                        "As you approach, Jethro removes his large straw hat, reaches \n"
                        + "up with his other hand and scratches the top of his bald head. He \n"
                        + "returns the hat to its original place, inhales deeply and looks at \n"
                        + "you. “I tell you what, young one, I hear tell that you are out \n"
                        + "searching for the Beast of the Woods. Well, yesterday I was out \n"
                        + "doing some fishing at Delmere’s pond and after I had caught the \n"
                        + "biggest mackerel you ever done seen. Anyway, I was getting ready to \n"
                        + "come back to town when I saw it. The Beast was nearly twelve feet \n"
                        + "tall and he was staring intently down in the water. Well, I skedaddled \n"
                        + "as fast and as quite as I could, ‘course I had to leave that fish \n"
                        + "there just in case the Beast got hungry, I didn’t want it coming \n"
                        + "after me.” He looks at you for a moment, then speaks again, “Oh, \n"
                        + "nearly forgot, you ain’t from around here. Delmere’s Pond is just \n"
                        + "over that way.” He points <<" + newMapControl.getQuadrant(scene) + ">>.",
                        //Scene Description
                        "Upon closer inspection of the yard, you notice that one of the windows \n"
                        + "has been smashed in and glass lays all scattered across the floor. You \n"
                        + "also notice that the flower patch has several large footprints leading\n"
                        + "to the <<" + direction + ">>.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.None, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Defensive":
                        clues[clueCounter] = new Clue("Defensive",
                        //NPC Comment
                        "Approaching a villager, you hear “It took my friends!” Alvin cries out, “We \n"
                        + "were out in the forest picking herbs for old Jethro when the Beast \n"
                        + "came roaring out of the trees. It was terrifying, we all ran off in \n"
                        + "different directions. I could hear the shouts and screams as the \n"
                        + "Beast found my friends. It spent several minutes searching for me \n"
                        + "as well, but luckily I had the medallion that my da’ gave me before \n"
                        + "he headed off to the War. Too bad, that I lost it as I was running \n"
                        + "home. If you do go out in the forest, DO NOT go to \n"
                        + "<<" + newMapControl.getQuadrant(scene) + ">> since that is where the Beast abducted \n"
                        + "my friends, Simon and Theodore.”" ,
                        //Scene Description
                        "The darkness of the overgrowth makes searching this area difficult, but \n"
                        + "as you are about to give up and decide that there is nothing worth \n"
                        + "finding, you spy a bronze medallion caught in the branches several feet\n"
                        + "off the trail. You pick up the <<Defensive Charm>>.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.DefensiveCharm, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Offensive":
                        clues[clueCounter] = new Clue("Offensive",
                        //NPC Comment
                        "As you approach Gaston, he flexes his muscles, then raises his \n"
                        + "massive Flamberge sword and stares at his reflection for a moment. \n"
                        + "He lowers the blade and smiles charmingly at you, impressively the \n"
                        + "light actually seems to sparkle on his perfect teeth. He then begins \n"
                        + "to talk in a deep, basso voice, “Listen well friend. I was out one \n"
                        + "morning practicing my sword skills, since you know ladies love sword \n"
                        + "skills, nunchuck skills, and so on. As I was perfecting my perfect \n"
                        + "swings when the Beast charged in with its massive paws and killer \n"
                        + "jaws. Don’t tell the ladies this, but it nearly overpowered me. That \n"
                        + "is until I threw a rock over its shoulder and when it looked that way \n"
                        + "I quickly hid inside a hollowed out tree. Obviously my cunning was too \n"
                        + "great for the Beast, since it quickly went off about an hour later. \n"
                        + "If you wish to see the place of this great battle, it was right over \n"
                        + "there <<" + newMapControl.getQuadrant(scene) + ">>. Maybe when you come back \n"
                        + "we can have a drink or two to celebrate my awesomeness?”" ,
                        //Scene Description
                        "As you search the clearing you begin to feel dizzy and stumble over a \n"
                        + "hollowed out tree. Sitting down to rest, you see the glimmer of metal \n"
                        + "out of the corner of your eye. You look closer at the tree, seeing\n"
                        + "something you reach your hand in and pull out the silver <<Offensive Charm>>.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.OffensiveCharm, Item.None,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Memento":
                        clues[clueCounter] = new Clue("Memento",
                        //NPC Comment
                        "You notice another villager, Illes, who is sitting in the middle of road, \n"
                        + "pushing a rock around with a stick. He looks up and says, “We was \n"
                        + "playing, Bart and me, out in the forest ‘bout two weeks ago. Bart’s \n"
                        + "my brother, he’s big and strong and will be turning ten next summer. \n"
                        + "We were playing hide ‘n’ seek ya see, well he went out that way \n" 
                        + "<<" + newMapControl.getQuadrant(scene) + ">> to hide but when I went out to find him, \n"
                        + "well, no one has been able to find him since.” He turns away from you \n"
                        + "and begins to kick a rock around the ground. He glances back over \n"
                        + "his shoulder and says, “If you happen to find him there, tell ‘im that \n"
                        + "I tried to find him for a good, long while and that we can play tag \n"
                        + "next time instead.” With that he runs off toward his house.",
                        //Scene Description
                        "Moving through the tall grass you stumble upon something soft. You look down\n"
                        + "at the object and see a stuffed animal of some sort. You pick up the \n"
                        + "<<Child’s Memento>> thinking that this might be of use for something.", 
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.KidsMemento, healthReward,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Ring":
                        clues[clueCounter] = new Clue("Ring",
                        //NPC Comment
                        "Vera starts out saying, “I was out with my friends a couple of days ago \n"
                        + "when we got separated. I tried to get back to my friends, when I \n"
                        + "heard something weird.” Vera pauses for a moment, then continues, \n"
                        + "“My ma taught me that weird noises usually have weird sources and \n"
                        + "since the sound was coming closer, I slid underneath the boughs of \n"
                        + "a low hanging evergreen. That’s when I saw the Beast. It stomped by \n"
                        + "making this loud snuffling noise, like a cow does sometimes, you know? \n"
                        + "I waited a few minutes after it had gone by before I left my hiding \n"
                        + "place. Just then my friends came by, after I told them what had \n"
                        + "happened we all ran straight back to the village. It wasn’t until a \n"
                        + "few hours later that I realized that I had lost my grandmother’s \n"
                        + "diamond ring. If you happen to find it, would you be ever-so-kind as \n"
                        + "to bring it back to me? I’m sure I could find something to give you \n"
                        + "that might interest you. My friends told me that we were at this \n"
                        + "place <<" + newMapControl.getQuadrant(scene) + ">>.”" ,
                        //Scene Description
                        "You begin to push pine boughs out of your way in a random manner. As you\n"
                        + "shift one branch, something falls and bounces off your head. You look \n"
                        + "around on the ground for a moment and come up with a <<Diamond Ring>>.\n"
                        + "You pocket it, thinking diamonds falling from the sky must be extremely valuable.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.DiamondRing, manaReward,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Necklace":
                        clues[clueCounter] = new Clue("Necklace",
                        //NPC Comment
                        "As you approach him, Edgar sizes you up for a moment, then laughs \n"
                        + "heartily saying, “You sure look like the person I need. You see, a \n"
                        + "week back my beloved Francine went out to her secret mushroom \n"
                        + "gathering place. She does love her ‘shrooms, everyone agrees that she \n"
                        + "makes the best Mushroom Soufflé in the world. As I was saying,” he \n"
                        + "once again looks you up and down, “you look like the one that might be \n"
                        + "able to find her out in forest. She took me out there once, but I’m not \n"
                        + "too sure exactly where her ‘shroom cache is.” He thinks for a moment, \n"
                        + "nods and then says, “it is over in this <<" + newMapControl.getQuadrant(scene)
                        + ">>\narea. You’ll know her from the jade necklace she is always wearing.”",
                        //Scene Description
                        "As you search the area, you see a blurry pink shape move ahead of you. You\n"
                        + "approach cautiously and looking around a particularly mossy boulder, you\n"
                        + "see a large pink pig happily munching away at patch of mushrooms.  Lying\n"
                        + "in the mud next to the mushrooms is a green object. You shoo the pig away\n"
                        + "and pick up the green object.  Wiping away the mud and grime you reveal\n"
                        + "that the object is a <<Jade Necklace>>. You slip it around your neck and move on.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.Necklace, scrollReward1,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                    case "Toy":
                        clues[clueCounter] = new Clue("Toy",
                        //NPC Comment
                        "As you approach lucy, you see Lucy’s worried face peering at you through\n"
                        + "her long red hair as she speaks. “My husband, Ricky, and son, Ricky \n"
                        + "Jr., went out on a camping trip a few weeks ago. They often go out \n"
                        + "for long camping excursions by Splittop Hill, here <<"+ newMapControl.getQuadrant(scene) 
                        + ">>\n, but they are usually back after a week. And what with that creature \n"
                        + "running around out there I am just sick with worry. Please would you find\n"
                        + "them? Ricky Jr. has a small wooden toy horse that he always carries around with him.”",
                        //Scene Description
                        "After looking around the hill, you find an abandoned campsite. The tent is\n"
                        + "torn in several places and the few supplies you can see are scattered and\n"
                        + "crushed. As you move out of the campsite you brush up against one of the \n"
                        + "tent’s support ropes and notice a wooden <<Child’s Toy>>. You pick up the\n"
                        + "horse and pocket it, just in case someone might want it back.",
                        //Completed Quest Dialogue
                        "Quest Completed",
                        Item.ChildsToy, scrollReward2,
                        false, false, false);
                        
                        clueCounter++;
                        break;
                }
            }
        }
        
        //The last Clue, is a default clue when there is nothing special in the scene
        clues[clueCounter] = new Clue("None", "", 
        "You search the area and only find a lot of useless dirt.",
        "", Item.None, Item.None, 
        false, true, true);
    }
    
    /* ********************************************************
    SAVE GAME
    ********************************************************* */
    public void saveGame(Game game, String fileName)
    throws GameControlException
    {
        try (FileOutputStream fout = new FileOutputStream(fileName))
        {
            ObjectOutputStream output = new ObjectOutputStream(fout);
            output.writeObject(game);
        }
        catch (Exception e)
        {
            throw new GameControlException(e.getMessage());
        }
    }
    
    /* ********************************************************
    LOAD GAME
    ********************************************************* */
    public Game loadGame(String fileName) throws GameControlException
    {
        //Empty Game
        Game game = null;
        
        try (FileInputStream fin = new FileInputStream(fileName))
        {
            ObjectInputStream input = new ObjectInputStream(fin);
            
            game = (Game)input.readObject();
        }
        catch (Exception e)
        {
            throw new GameControlException(e.getMessage());
        }
        
        return game;
    }
    
    /* ********************************************************
    ADD TIME
    ********************************************************* */
    public boolean addTime(Game game, int minutes)
    {
        int currentTime = game.getElapsedTime();
        int newTime = currentTime + minutes;
        
        //Set the new time
        game.setElapsedTime(newTime);
        
        //Test to see if the game time limit has been passed
        if (newTime > game.getTimeLimit())
        {
            //Lost Game - Timed Out
            TimeDefeatView newTimeDefeat = new TimeDefeatView();
            newTimeDefeat.display();
            
            //If reached this point, then the player wants to return to main menu
            return true;  //Defeated
        }
        
        //Test to see if a 4th hour was passed
        if ((currentTime % 240) > (newTime % 240))
        {
            //Load the current status of all NPC's and town scenes into an array
            int counter = -1;
            boolean[] status = new boolean[14];
            Scene currentScene;
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    //Test the current scene to see if it is closed
                    currentScene = game.getForestMap().getScene(i + 2, j + 2);
                    counter++;
                    
                    //Test each NPC in the scene to see if they have been captured
                    status[counter] = currentScene.getClosed();
                    for (NPC npc : currentScene.getNPC())
                    {
                        if (!(npc.getNPCName().equals("None")))
                        {
                            status[counter] = npc.getCaptured();
                            counter++;
                        }
                    }
                }
            }
            
            //Choose a random number between 0 and 13
            //There are only 10 NPC's and 4 Town Scenes
            boolean looped = false;
            int random = (int)(Math.random() * 1400);
            if (status[random])
            {
                random++;
                if (random >= 14)
                {
                    //Test if Already Looped
                    if (looped)
                    {
                        //Should not loop more than once
                        ErrorView.display(this.getClass().getName(), "Error:  "
                           + "This function has looped more than once and is an "
                           + "infinite loop.");
                        return false;
                    }
                    random = 0;
                    looped = true;
                }
            }
            
            //Close the building or capture the NPC
            counter = -1;
            boolean completed = false;
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    //Test the current scene to see if it is closed
                    currentScene = game.getForestMap().getScene(i + 2, j + 2);
                    counter++;
                    
                    //Test to see if the counter matches the random number
                    if (counter == random)
                    {
                        //Close the building
                        game.getForestMap().getScene(i + 2, j + 2).setClosed(true);
                        
                        System.out.println("Your innate intuition tells you that "
                        + "something has happened to one of the building owners "
                        + "in the village.");
                        
                        //End of Function - Exit
                        return false;
                    }
                    
                    //Test each NPC in the scene to see if they have been captured
                    status[counter] = currentScene.getClosed();
                    for (NPC npc : game.getForestMap().getScene(i + 2, j + 2).getNPC())
                    {
                        if (!(npc.getNPCName().equals("None")))
                        {
                            status[counter] = npc.getCaptured();
                            counter++;
                            
                            //Test to see if the counter matches the random number
                            if (counter == random)
                            {
                                //Capture the NPC
                                npc.setCaptured(true);
                                System.out.println("Your innate intuition tells you that "
                                + "something has happened to one of the people "
                                + "in the village.");
                        
                                
                                //End of Function - Exit
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean timeDefeat(Game game)
    {
        return game.getElapsedTime() > game.getTimeLimit();
    }
}