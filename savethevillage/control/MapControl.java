/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.control;

import saveTheVillage.model.Map;
import saveTheVillage.model.Scene;
import saveTheVillage.model.NPC;
import saveTheVillage.exceptions.InventoryControlException;
import saveTheVillage.model.Game;
import saveTheVillage.view.BattleView;
import saveTheVillage.exceptions.MapControlException;
import saveTheVillage.view.ErrorView;
import java.io.PrintWriter;
import savethevillage.SaveTheVillage;


public class MapControl
{
    protected final PrintWriter console = SaveTheVillage.getOutFile();
    
    /* ********************************************************
    INITIALIZE MAP
    ********************************************************* */
    public void initializeMap(Map map) throws InventoryControlException
    {
        if (map.getMapName().equals("Forest"))
        {
            //Default NPC Construct
            NPC defaultNPC = new NPC();
            NPC defaultNPCs[] = new NPC[3];
            for (int i = 0; i < defaultNPCs.length; i++)
            {
                defaultNPCs[i] = defaultNPC;
            }

            //Town
            Scene inn = new Scene("Inn",
                  "“Welcome to the Dancing Cartman” reads the elaborately painted sign hanging above the village’s inn\n"
                + "and tap room. Its walls, painted bright orange, have faded a bit from the sun and time, but the\n"
                + "sound of voices and music indicate that the Dancing Cartman is well loved by the local populace.", 
                defaultNPCs, false);
            Scene bank = new Scene("Bank",
                  "The building you see before you is rather nondescript, with simple rock walls and a solid oak door\n"
                + "studded in iron. Posted above the door is an image of a stack of coins. Next to it, in large block\n"
                + "letters is a sign saying: “The Bank.”", 
                defaultNPCs, false);
            Scene store = new Scene("Store",
                  "The building before you appears to be more of a tent than a permanent structure. The walls are draped\n"
                + "in bright and cheerful fabrics. There is a wooden sign hammered into the ground before a split in the\n"
                + "fabric. The sign reads: Galadriel's Exotics.", 
                defaultNPCs, false);
            Scene weaponShop = new Scene("Weapons",
                  "You see a large white washed wall looming in front of you. Across its surface are various paintings\n"
                + "depicting items of war in various shapes and sizes. A burly looking pig is rooting around the ground\n"
                + "outside. Draped across the pig's back is a banner with the words: “Hector’s, Now Open.”",
                defaultNPCs, false);
            
            //Forest Key Places
            Scene dungeonEntrance = new Scene("Entrance",
                  "This section of the forest is interspersed with several large, stone biers. The massive monoliths are\n"
                + "impressive to behold. You have the sense that you are being watched by some malevolent force. As you\n"
                + "pass by one of the biers you hear maniacal laughter that is quickly cut short. You draw your weapon and\n"
                + "cautiously approach the direction that the laughter originated. It starts up again and just before it \n"
                + "stops, you notice that laughing comes from a raven. It cocks its head at your approach, lets out another\n"
                + "maniacal guffaw and flies away, leaving the area in a deathly quiet.\n\n"
                + "As you begin to search the area, you are drawn to the largest of the stone biers. You slowly circle\n"
                + "from a distance and notice a dark opening in one of its sides. Moving closer to the darkness you once\n"
                + "again feel as if you are being watched, but undaunted you press forward. Hidden in the shadows you see\n"
                + "a massive stone door. You can see a large iron key hole set in the center of the door. As you try to\n"
                + "open the door it becomes obvious that it is sealed and locked tight. A key is required to get in.",
                  defaultNPCs, false);
            Scene dungeonKey = new Scene("Key",
                  "A large pond nearly fills the entirety of this glade, next to a trail you see a hand painted sign. The\n"
                + "dark paint is quite faded and a little weather worn, but you can still make out the words “Delmere’s Pond,\n"
                + "best fishing hole you ever seen. Just ask Delmere and he'll tell ya.” The pond would be nice place to \n"
                + "spend a hot summer afternoon at. Unfortunately, you do not have the time to waste on such frivolity.", 
                  defaultNPCs, false);
            Scene tracks1 = new Scene("Tracks1",
                  "There is a large jumble of rocks and boulders spread out around this section of the forest. A large oak\n"
                + "tree stands in the middle of the rock strewn land.", 
                  defaultNPCs, false);
            Scene tracks2 = new Scene("Tracks2",
                  "The forest area here is slightly thin, and you can see wild bushes with flowers\n"
                + "growing about peacefully.", 
                  defaultNPCs, false);
            Scene tracks3 = new Scene("Tracks3",
                  "A picturesque farmhouse lays before you, a white picket fence surrounds a small patch of flowers beneath\n"
                + "one of the windows. You hear birds chirping in the trees and see a small, white butterfly flitting between\n"
                + "blossoms.",
                  defaultNPCs, false);
            Scene defensiveCharm = new Scene("Defensive",
                  "The forest is quite dense in this section of the woods, with some of the trees growing up right next to\n"
                + "the path. It is eerily quiet, save for the occasional rustle of leaves.",
                  defaultNPCs, false);
            Scene offensiveCharm = new Scene("Offensive",
                  "A small clearing is the main feature of this section of the forest. The clearing seems to be well visited,\n"
                + "since most of the grass and flowers are trampled and barren dirt patches are all over.",
                  defaultNPCs, false);
            Scene memento = new Scene("Memento",
                  "As you approach this section of the forest you notice that the grass grows quite high and that the trees\n"
                + "are spread out a bit more than other sections of the forest. You can hear the buzzing of bees and the warble\n"
                + "of songbirds in the trees. You see a wave of grass as something approaches you. You draw your weapon and\n"
                + "prepare yourself for battle and as the ripple nears you a white rabbit hops out. It wiggles its nose as it\n"
                + "studies you and then hops off. You courageously sheath your weapon, sensing no further danger.",
                  defaultNPCs, false);
            Scene ring = new Scene("Ring",
                  "Pines and firs are abundant in this section of the forest. So, too, is the wildlife. As you begin to move\n"
                + "through the trees you see several red squirrels chittering at each other and a family of opossum cross\n"
                + "leisurely in front of you. The largest looks at you briefly before meandering on.", 
                  defaultNPCs, false);
            Scene necklace = new Scene("Necklace",
                  "The ground is a bit swampy in this section of the forest, making travel a bit harder. You step on a\n"
                + "particularly muddy section and as you lift your foot the smell of decay and offal assaults your nose.\n"
                + "You gag and wonder if it is worth continuing on in this direction, but decide that if you were a monster,\n"
                + "then a swamp would be the ideal hiding place since everyone knows monsters like swamps.", 
                  defaultNPCs, false);
            Scene toy = new Scene("Toy",
                  "You see a hill with a large split running through the middle of it. There are several trails running up\n"
                + "and through the hill, indicating that this is a fairly well visited area. There are several fruit trees\n"
                + "growing around the base of the hill as well.",
                  defaultNPCs, false);
            
            //Empty Forest - 21 spots on Forest map
            Scene emptyForest = new Scene("Forest",
                  "This section of the woods is very similar to everywhere else. Massive trees tower above you and the\n"
                + "undergrowth is littered with fallen sticks and wildflowers.",
                  defaultNPCs, false);
            
            //Set each scene originally as Empty Forest
            for (int i = 0; i < map.getTotalRows(); i++)
            {
                for (int j = 0; j < map.getTotalColumns(); j++)
                {
                    //Create a new empty forest scene for each spot on the map
                    //so that each spot has a unique location address when set
                    Scene newEmptyForest = new Scene(emptyForest);
                    newEmptyForest.setRow(i);
                    newEmptyForest.setColumn(j);
                    map.setScene(newEmptyForest, i, j);
                }
            }

            //Randomly place Town Scenes
            Scene sceneGroup[] = new Scene[4];
            sceneGroup[0] = inn;
            sceneGroup[1] = bank;
            sceneGroup[2] = store;
            sceneGroup[3] = weaponShop;
            randomizeTown(map, sceneGroup);
            
            //Randomly place Forest Scenes
            sceneGroup = new Scene[11];
            sceneGroup[0] = dungeonEntrance;
            sceneGroup[1] = dungeonKey;
            sceneGroup[2] = tracks1;
            sceneGroup[3] = tracks2;
            sceneGroup[4] = tracks3;
            sceneGroup[5] = defensiveCharm;
            sceneGroup[6] = offensiveCharm;
            sceneGroup[7] = memento;
            sceneGroup[8] = ring;
            sceneGroup[9] = necklace;
            sceneGroup[10] = toy;
            randomizeForest(map, sceneGroup);
            
            //Create and Place NPC's
            placeNPCs(map, sceneGroup);
        }
        else if (map.getMapName().equals("Dungeon"))
        {
            //Default NPC Construct
            NPC defaultNPC = new NPC();
            NPC defaultNPCs[] = new NPC[1];
            defaultNPCs[0] = defaultNPC;

            //Construct Dungeon Map
            //Construct Dungeon Scenes
            
            Scene noPath = new Scene("NoPath", "No Path", defaultNPCs, false);
            Scene dungeonExit = new Scene("DungeonExit",
                "With the glow of the outside light radiating into the dungeon entrance, your torch begins to\n"
                + "illuminate the cold, damp dungeon that awaits you.",
                defaultNPCs, false);
            Scene dungeonPath = new Scene ("DungeonPath",
                "You hear the whistling of the wind as you venture deeper into the dungeon. Each of your steps echoes\n"
                + "ominously through the vast, emptiness ahead and behind you.",
                defaultNPCs, false);
            Scene branch = new Scene ("Branch",
                "You come upon the first deviation in this dungeon. There are now three directions for you to choose from.\n"
                + "You can either continue going straight or you can now go down a passage to the left or one to the right.",
                defaultNPCs, false);
            Scene miniboss1 = new Scene ("Miniboss1",
                  "Ahead of you, you can hear a deep voice muttering. Since there is only the one voice to be heard you\n"
                + "assume that the being is alone. You approach and see a small minotaur that can only be described as\n"
                + "'feminine.' The female minotaur notices you and snorts throught its bovine nose. She stands up and with\n"
                + "a flick of her head asks, “So are you here to fight me then?”",
                defaultNPCs, false);
            Scene miniboss2 = new Scene ("Miniboss2",
                  "A massive black furred minotaur stomps toward you. He glares at you menacingly while one of his \n"
                + "cloven feet paws the ground restlessly. “Ha, puny man-thing, you have come to fight the mighty Reaver?\n"
                + "Well come on then!”",
                defaultNPCs, false);
            Scene boss = new Scene ("Boss",
                  "A minotaur in a shabby robe is sitting cross legged in front of a fire. He glances up at you as you \n"
                + "walk in. “Welcome friend to my humble abode. I see that you have come through quite a bit. Please have\n"
                + "a seat and some tea.” He motions toward the broken stump of a stalagmite. “Do not worry, I don’t bite.”\n"
                + "He pauses for a moment, then shrugs, “Well, I suppose I actually do bite, but that is only those poor \n"
                + "souls who annoy my hospitality.” He stands up to his full height and bellows, “SO SIT OR BECOME MY NEXT\n"
                + "MEAL!” You decide that then fractured stalagmite would not be overly comfortable so you remain standing.\n"
                + "He roars his displeasure and throws off his robe revealing ornate leather armour beneath. You have a\n"
                + "moment to decide on what you do.",
                  defaultNPCs, false);
            
            //Set each scene originally as noPath
            for (int i = 0; i < map.getTotalRows(); i++)
            {
                for (int j = 0; j < map.getTotalColumns(); j++)
                {
                    //Create a new empty forest scene for each spot on the map
                    //so that each spot has a unique location address when set
                    Scene newNoPath = new Scene(noPath);
                    map.setScene(newNoPath, i, j);
                }
            }
            
            //Create an Array of Dungeon Path Copies
            Scene dungeonPathArray[] = new Scene[12];
            for (int i = 0; i < dungeonPathArray.length; i++)
            {
                dungeonPathArray[i] = new Scene(dungeonPath);
            }

            //Place the dungeon path and branch
            dungeonExit.setRow(4);
            dungeonExit.setColumn(0);
            map.setScene(dungeonExit, 4, 0);
            dungeonPathArray[0].setRow(4);
            dungeonPathArray[0].setColumn(1);
            map.setScene(dungeonPathArray[0], 4, 1);
            dungeonPathArray[1].setRow(4);
            dungeonPathArray[1].setColumn(2);
            map.setScene(dungeonPathArray[1], 4, 2);
            dungeonPathArray[2].setRow(4);
            dungeonPathArray[2].setColumn(3);
            map.setScene(dungeonPathArray[2], 4, 3);
            branch.setRow(4);
            branch.setColumn(4);
            map.setScene(branch, 4, 4);
            dungeonPathArray[3].setRow(3);
            dungeonPathArray[3].setColumn(4);
            map.setScene(dungeonPathArray[3], 3, 4);
            dungeonPathArray[4].setRow(2);
            dungeonPathArray[4].setColumn(4);
            map.setScene(dungeonPathArray[4], 2, 4);
            dungeonPathArray[5].setRow(1);
            dungeonPathArray[5].setColumn(4);
            map.setScene(dungeonPathArray[5], 1, 4);
            dungeonPathArray[6].setRow(5);
            dungeonPathArray[6].setColumn(4);
            map.setScene(dungeonPathArray[6], 5, 4);
            dungeonPathArray[7].setRow(6);
            dungeonPathArray[7].setColumn(4);
            map.setScene(dungeonPathArray[7], 6, 4);
            dungeonPathArray[8].setRow(7);
            dungeonPathArray[8].setColumn(4);
            map.setScene(dungeonPathArray[8], 7, 4);
            dungeonPathArray[9].setRow(4);
            dungeonPathArray[9].setColumn(5);
            map.setScene(dungeonPathArray[9], 4, 5);
            dungeonPathArray[10].setRow(4);
            dungeonPathArray[10].setColumn(6);
            map.setScene(dungeonPathArray[10], 4, 6);
            dungeonPathArray[11].setRow(4);
            dungeonPathArray[11].setColumn(7);
            map.setScene(dungeonPathArray[11], 4, 7);
            
            //Randomize Boss & Miniboss Locations
            Scene sceneGroup[] = new Scene[3];
            sceneGroup[0] = boss;
            sceneGroup[1] = miniboss1;
            sceneGroup[2] = miniboss2;
            randomizeDungeon(map, sceneGroup);

        }
        else  //Invalid Map
        {
            try
            {
                map.setMapName("Invalid");
            }
            catch (Exception e)
            {
                ErrorView.display(this.getClass().getName(), "ERROR:  Attempted to initialize invalid map"
                    + e.getMessage());
            }
        }
    }
    
    /* ********************************************************
    RANDOMIZE TOWN
    ********************************************************* */
    public void randomizeTown(Map map, Scene sceneGroup[])
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[4];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place first town scene
        int randomNumber = (int)(Math.random() * 100) % 4;
        sceneGroup[randomNumber].setRow(2);
        sceneGroup[randomNumber].setColumn(2);
        map.setScene(sceneGroup[randomNumber], 2, 2);
        placed[randomNumber] = true;

        //Place town scenes
        for (int i = 1; i < 4; i++)
        {
            //Determine random town scene to place
            randomNumber = (int)(Math.random() * 100) % 4;
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 3;
                }
                else
                {
                    randomNumber--;
                }
            }
            
            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the scene in the appropriate spot on the map
            switch (i)
            {
                case 1:
                    sceneGroup[randomNumber].setRow(2);
                    sceneGroup[randomNumber].setColumn(3);
                    map.setScene(sceneGroup[randomNumber], 2, 3);
                    break;
                case 2:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(2);
                    map.setScene(sceneGroup[randomNumber], 3, 2);
                    break;
                case 3:
                    sceneGroup[randomNumber].setRow(3);
                    sceneGroup[randomNumber].setColumn(3);
                    map.setScene(sceneGroup[randomNumber], 3, 3);
                    break;
            }
        }
    }
    
    /* ********************************************************
    RANDOMIZE FOREST
    ********************************************************* */
    public void randomizeForest(Map map, Scene[] sceneGroup)
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[32];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place all the scenes on the map
        for (int i = 0; i < sceneGroup.length; i++)
        {
            //Generate a random number for all corresponding scenes
            int randomNumber = (int)(Math.random() * 32000) % 32;
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 31;
                }
                else
                {
                    randomNumber--;
                }
            }

            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the scene - Skips the Town squares which have already been
            //placed
            switch (randomNumber)
            {
                case 0:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 0, 0);
                    break;
                case 1:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 0, 1);
                    break;
                case 2:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 0, 2);
                    break;
                case 3:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 0, 3);
                    break;
                case 4:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 0, 4);
                    break;
                case 5:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 0, 5);
                    break;
                case 6:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 1, 0);
                    break;
                case 7:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 1, 1);
                    break;
                case 8:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 1, 2);
                    break;
                case 9:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 1, 3);
                    break;
                case 10:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 1, 4);
                    break;
                case 11:
                    sceneGroup[i].setRow(1);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 1, 5);
                    break;
                case 12:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 2, 0);
                    break;
                case 13:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 2, 1);
                    break;
                case 14:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 2, 4);
                    break;
                case 15:
                    sceneGroup[i].setRow(2);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 2, 5);
                    break;
                case 16:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 3, 0);
                    break;
                case 17:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 3, 1);
                    break;
                case 18:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 3, 4);
                    break;
                case 19:
                    sceneGroup[i].setRow(3);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 3, 5);
                    break;
                case 20:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 4, 0);
                    break;
                case 21:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 4, 1);
                    break;
                case 22:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 4, 2);
                    break;
                case 23:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 4, 3);
                    break;
                case 24:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 4, 4);
                    break;
                case 25:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 4, 5);
                    break;
                case 26:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(0);
                    map.setScene(sceneGroup[i], 5, 0);
                    break;
                case 27:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(1);
                    map.setScene(sceneGroup[i], 5, 1);
                    break;
                case 28:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(2);
                    map.setScene(sceneGroup[i], 5, 2);
                    break;
                case 29:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(3);
                    map.setScene(sceneGroup[i], 5, 3);
                    break;
                case 30:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 5, 4);
                    break;
                case 31:
                    sceneGroup[i].setRow(5);
                    sceneGroup[i].setColumn(5);
                    map.setScene(sceneGroup[i], 5, 5);
                    break;
            }
        }
    }
    
    /* ********************************************************
    RANDOMIZE DUNGEON
    ********************************************************* */
    public void randomizeDungeon(Map map, Scene sceneGroup[])
    {
        //Tracking what is placed with an array of booleans
        boolean placed[] = new boolean[3];
        for (int i = 0; i < placed.length; i++)
        {
            placed[i] = false;
        }
        
        //Place all the scenes on the map
        for (int i = 0; i < sceneGroup.length; i++)
        {
            //Generate a random number for all corresponding scenes
            int randomNumber = ((int)(Math.random() * 100)) % 3;
            while (placed[randomNumber])  //If already taken
            {
                if (randomNumber == 0)
                {
                    randomNumber = 2;
                }
                else
                {
                    randomNumber--;
                }
            }

            //Deactivate the location to be placed to prevent overwriting
            //another place on top
            placed[randomNumber] = true;
            
            //Place the appropriate scene
            switch (randomNumber)
            {
                case 0:
                    sceneGroup[i].setRow(0);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 0, 4);
                    break;
                case 1:
                    sceneGroup[i].setRow(8);
                    sceneGroup[i].setColumn(4);
                    map.setScene(sceneGroup[i], 8, 4);
                    break;
                case 2:
                    sceneGroup[i].setRow(4);
                    sceneGroup[i].setColumn(8);
                    map.setScene(sceneGroup[i], 4, 8);
                    break;
            }
        }
    }
    
    /* ********************************************************
    GET QUADRANT
    ********************************************************* */
    public String getQuadrant(Scene scene)
    {
        String direction = "";
        
        switch (scene.getRow())
        {
            case 0:
            case 1:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "Northwest";
                        break;
                    case 2:
                    case 3:
                        direction = "North";
                        break;
                    case 4:
                    case 5:
                        direction = "Northeast";
                        break;
                }
                break;
            case 2:
            case 3:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "West";
                        break;
                    case 2:
                    case 3:
                        direction = "Central";
                        break;
                    case 4:
                    case 5:
                        direction = "East";
                        break;
                }
                break;
            case 4:
            case 5:
                switch (scene.getColumn())
                {
                    case 0:
                    case 1:
                        direction = "Southwest";
                        break;
                    case 2:
                    case 3:
                        direction = "South";
                        break;
                    case 4:
                    case 5:
                        direction = "Southeast";
                        break;
                }
                break;
        }
        
        return direction;
    }
    
    /* ********************************************************
    GET QUADRANT
    ********************************************************* */
    public String getQuadrant(int row, int column)
    {
        String direction = "";
        
        switch (row)
        {
            case 0:
            case 1:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "Northwest";
                        break;
                    case 2:
                    case 3:
                        direction = "North";
                        break;
                    case 4:
                    case 5:
                        direction = "Northeast";
                        break;
                }
                break;
            case 2:
            case 3:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "West";
                        break;
                    case 2:
                    case 3:
                        direction = "Central";
                        break;
                    case 4:
                    case 5:
                        direction = "East";
                        break;
                }
                break;
            case 4:
            case 5:
                switch (column)
                {
                    case 0:
                    case 1:
                        direction = "Southwest";
                        break;
                    case 2:
                    case 3:
                        direction = "South";
                        break;
                    case 4:
                    case 5:
                        direction = "Southeast";
                        break;
                }
                break;
        }
        
        return direction;
    }
    
    /* ********************************************************
    PLACE NPC'S
    ********************************************************* */
    public void placeNPCs (Map map, Scene[] sceneGroup)
    {
        //Set an array of blank NPC's
        NPC[] npcList = new NPC[10];
        
        //Construct new NPC's
        NPC bob = new NPC("Bob", "Key", false);
        NPC vixen = new NPC("Vixen", "Tracks1", false);
        NPC sandy = new NPC("Sandy", "Tracks2", false);
        NPC jethro = new NPC("Jethro", "Tracks3", false);
        NPC alvin = new NPC("Alvin", "Defensive", false);
        NPC gaston = new NPC("Gaston", "Offensive", false);
        NPC illes = new NPC("Illes", "Memento", false);
        NPC vera = new NPC("Vera", "Ring", false);
        NPC edgar = new NPC("Edgar", "Necklace", false);
        NPC lucy = new NPC("Lucy", "Toy", false);
        npcList[0] = bob;
        npcList[1] = vixen;
        npcList[2] = sandy;
        npcList[3] = jethro;
        npcList[4] = alvin;
        npcList[5] = gaston;
        npcList[6] = illes;
        npcList[7] = vera;
        npcList[8] = edgar;
        npcList[9] = lucy;
        
        //Place NPC's in town
        int[] countOfNPCs = new int[4];
        for (int i = 0; i < 4; i++)
            countOfNPCs[i] = 0;
        
        for (int i = 0; i < npcList.length; i++)
        {
            //Grid NPC is to be placed in
            int randomNumber = (int)(Math.random() * 100 % 4);
            while (countOfNPCs[randomNumber] >= 3)
            {
                if (randomNumber == 0)
                {
                    randomNumber = 3;
                }
                else
                {
                    randomNumber--;
                }
            }
            
            //Place the NPC
            switch (randomNumber)
            {
                case 0:
                    map.getScene(2, 2).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 1:
                    map.getScene(2, 3).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 2:
                    map.getScene(3, 2).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
                case 3:
                    map.getScene(3, 3).setNPC(npcList[i], 
                        countOfNPCs[randomNumber]);
                    countOfNPCs[randomNumber]++;
                    break;
            }
        }
    }

    /* ********************************************************
    MOVE PLAYER
    ********************************************************* */
    public boolean movePlayer(Game game, int newRow, int newColumn)
    throws MapControlException
    {
        boolean defeated = false;
        
        //Error Trap Invalid Coordinates
        if (!(newRow >= 0 && newColumn >= 0 && newRow <= 
            (game.getIsInDungeon() ? 8 : 5) && newColumn <= 
            (game.getIsInDungeon() ? 8 : 5)))
        {
            throw new MapControlException("ERROR:  Invalid Coordinates - You "
            + "are attempting to move your player to a non-existent location");
        }

        //Random Enemy Encounter
        double randomNumber = Math.random();
        if (randomNumber > .5)
        {
            if (game.getIsInDungeon() == false)  //Forest
            {
                switch (game.getForestMap().getSceneArray()
                    [newRow][newColumn].getName())
                {
                    case "Inn":
                    case "Bank":
                    case "Weapons":
                    case "Shop":
                        //No Enemy Encounter
                        break;
                    default:
                        //Enemy Encounter
                        BattleView newBattleView = new BattleView();
                        defeated = newBattleView.displayBattleView("Forest", 
                            game.getPlayer());
                }
            }
            else  //Dungeon
            {
                //Enemy Encounter
                BattleView newBattleView = new BattleView();
                defeated = newBattleView.displayBattleView("Dungeon", 
                    game.getPlayer());
            }
        }
        
        //If not defeated or did not run away, move player to new spot
        if (game.getPlayer().getCurrentHealth() > 0)
        {
            game.setCurrentRow(newRow);
            game.setCurrentColumn(newColumn);
            
            //Set the new scene to visited
            if (game.getIsInDungeon())
            {
                game.getDungeonMap().getSceneArray()[newRow][newColumn].setVisited(true);
            }
            else
            {
                game.getForestMap().getSceneArray()[newRow][newColumn].setVisited(true);
            }
        }
        else  //Player Defeated
        {
            //Player has already chosen to return to main menu
            game.setGameFinished(true);
        }
            
        return defeated;
    }

    /* ********************************************************
     *******************DO WE USE THIS *********************************************
    ********************************************************* */
    
/*    public void dungeonEncounter()
    {
        double rand = (Math.random() * 100);
        try{
        if(rand > 100 || rand < 1) //Error trapping, random must be between 1 and 100
            ErrorView.display(this.getClass().getName(), "\nInvalid number.");
        
        else if(rand < 50)
            this.console.println("\n"
            + "You hear the whistling of the wind as you venture deeper into the dungeon. Each of your steps echoes ominously\n"
            + "through the vast, emptiness ahead and behind you.");
       
        else if(rand > 50 || rand < 63)
            this.console.println("\n"
            + "You hear moaning and the sound of dragging feet. As the gutteral moans draw near, the stench of decay wafts\n"
            + "across your nose. Then from out of the darkness the form of a desicated zombie launches itself at you. Battle\n"
            + "ensues.");
            
        else if(rand > 63 || rand < 75)
            this.console.println("\n"
            + "Old bones lay scattered across the passageway. As you approach the bones begin to vibrate and slide together.\n"
            + "In seconds a humanoid, skeleton shape is formed and lumbers toward you. Prepare yourself for a fight.");
    
        else if(rand > 75 || rand < 88)
            this.console.println("\n"
            + "This particular section of the dungeon is extremely dark. As you move forward, the reek of rotting flesh assaults\n"
            + "your senses and a pair of glowing green dots flicker into existense. As your eyes adjust to the gloom, you see the\n"
            + "hulking form of troll gnawing on the carcass of something left unknown. The troll is not happy to have you interrupt\n"
            + "its dinner, as a reward it attacks you.");
    
        else
            this.console.println("\n"
            + "Out of the darkness you see a massive bovine head, its horns nearly scratching the ceiling. Your eyes slide down and\n"
            + "take in the human body. The minotaur roars at your intrusion and the battle is on.");    
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
    }*/
}