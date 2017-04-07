package saveTheVillage.view;


import saveTheVillage.control.MapControl;
import saveTheVillage.model.Game;
import saveTheVillage.model.Map;
import saveTheVillage.model.Scene;

public class MapView extends View
{
    public MapView()
    {
        super("\n"
                + "\nChoose the map you wish to view:"
                + "\n\tF = Forest"
                + "\n\tD = Dungeon"
                + "\n\tE = Exit");
    }
    
    @Override
    public boolean doAction(String choice)
    {
        ErrorView.display(this.getClass().getName(),"ERROR:  Required to pass Game as a parameter");
        return false;
    }
    
    @Override
    public boolean doAction(String choice, Game game) {
        choice = choice.toUpperCase();
        
        try{
        switch(choice)
        {
            case "F":
                displayMap(game.getForestMap());
                break;
            case "D":
                displayMap(game.getDungeonMap());
                break;
            case "E":
                return true;
            default:
                ErrorView.display(this.getClass().getName(),"Sorry, what was that?");
        }} catch(Exception e){
            ErrorView.display(this.getClass().getName(), "Error reading input: "
                    + e.getMessage());
        }
        
        return false;
    }
    
    /* ********************************************************
    DISPLAY MAP
    ********************************************************* */
    public void displayMap(Map map)
    {
        String mapOutput = "";
        switch (map.getMapName())
        {
            //***************FOREST MAP**********************
            case "Forest":
                //Map Header
                mapOutput += 
                        "\t|---------------------------------------|"
                    + "\n\t|         Village Wood Forest           |"
                    + "\n\t|---------------------------------------|"
                    + "\n\t| ------------------------------------- |";
                
                //Display Map Contents
                for (Scene[] sceneRow : map.getSceneArray())
                {
                    mapOutput += "\n\t| |";
                    for (Scene thisScene : sceneRow)
                    {
                        //Coordinates
                        mapOutput += " " + (thisScene.getRow() + 1) + "," + 
                            (thisScene.getColumn() + 1) + " |";
                    }
                    mapOutput += " |";
                    mapOutput += "\n\t| |";
                    for (Scene thisScene : sceneRow)
                    {
                        mapOutput += " ";
                        //Forest/Town Indicator
                        if ((thisScene.getRow() == 2 && thisScene.getColumn() == 2) ||
                            (thisScene.getRow() == 2 && thisScene.getColumn() == 3) ||
                            (thisScene.getRow() == 3 && thisScene.getColumn() == 2) ||
                            (thisScene.getRow() == 3 && thisScene.getColumn() == 3))
                        {
                            mapOutput += "T,";
                        }
                        else
                        {
                            mapOutput += "F,";
                        }
                        
                        //Scene Class Indicator
                        if (thisScene.getVisited())
                        {
                            switch (thisScene.getName())
                            {
                                case "Inn":
                                    mapOutput += "I";
                                    break;
                                case "Bank":
                                    mapOutput += "B";
                                    break;
                                case "Store":
                                    mapOutput += "S";
                                    break;
                                case "Weapons":
                                    mapOutput += "W";
                                    break;
                                case "Entrance":
                                    mapOutput += "E";
                                    break;
                                case "Tracks1":
                                    mapOutput += "C";
                                    break;
                                case "Tracks2":
                                    mapOutput += "C";
                                    break;
                                case "Tracks3":
                                    mapOutput += "C";
                                    break;
                                case "Defensive":
                                    mapOutput += "C";
                                    break;
                                case "Offensive":
                                    mapOutput += "C";
                                    break;
                                case "Memento":
                                    mapOutput += "C";
                                    break;
                                case "Ring":
                                    mapOutput += "C";
                                    break;
                                case "Necklace":
                                    mapOutput += "C";
                                    break;
                                case "Toy":
                                    mapOutput += "C";
                                    break;
                                case "Forest":
                                    mapOutput += "N";
                                    break;
                                default:
                                    mapOutput += "N";
                            }
                            
                            mapOutput += " |";
                        }
                        else
                        {
                            mapOutput += "? |";
                        }
                    }
                    
                    //Border
                    mapOutput += " |";
                    mapOutput += "\n\t| ------------------------------------- |";
                }
                
                //Map Legend
                mapOutput +=
                      "\n\t|---------------------------------------|"
                    + "\n\t  F = Forest            T = Town"
                    + "\n\t|---------------------------------------|"
                    + "\n\t  X - Dungeon Entrance  I = Inn"
                    + "\n\t  C - Clue              B = Bank"
                    + "\n\t  N - Normal Scene      S = Item Shop"
                    + "\n\t  ? - Not Yet Visited   W = Weapon Shop"
                    + "\n\t| ------------------------------------- |";
                break;
            //***************DUNGEON MAP**********************
            case "Dungeon":
                //Header
                mapOutput += 
                        "\t|-----------------------------------------------------------------|"
                    + "\n\t|                       The Minotaur's Lair                       |"
                    + "\n\t|-----------------------------------------------------------------|";
                
                //Map
                for (Scene[] sceneRow : map.getSceneArray())
                {
                    //First Row
                    mapOutput += "\n\t| ";
                    for (Scene thisScene : sceneRow)
                    {
                        switch (thisScene.getName())
                        {
                            case "DungeonExit":
                            case "DungeonPath":
                            case "Branch":
                            case "Miniboss1":
                            case "Miniboss2":
                            case "Boss":
                                mapOutput += "| " + (thisScene.getRow() + 1) + "," +
                                    (thisScene.getColumn() + 1) + " |";
                                break;
                            default:  //NoPath
                                mapOutput += "       ";
                        }
                    }
                    mapOutput += " |";

                    //Second Row
                    mapOutput += "\n\t| ";

                    for (Scene thisScene : sceneRow)
                    {
                        if (thisScene.getVisited())
                        {
                            switch (thisScene.getName())
                            {
                                case "DungeonExit":
                                    mapOutput += "| D,E |";
                                    break;
                                case "DungeonPath":
                                    mapOutput += "| D,P |";
                                    break;
                                case "Branch":
                                    mapOutput += "| D,B |";
                                    break;
                                case "Miniboss1":
                                    mapOutput += "| D,1 |";
                                    break;
                                case "Miniboss2":
                                    mapOutput += "| D,2 |";
                                    break;
                                case "Boss":
                                    mapOutput += "| D,M |";
                                    break;
                                default:  //NoPath
                                    mapOutput += "       ";
                            }
                        }
                        else
                        {
                            if (thisScene.getName().equals("NoPath"))
                            {
                                mapOutput += "       ";
                            }
                            else
                            {
                                mapOutput += "| ?,? |";
                            }
                        }
                    }
                    
                    mapOutput += " |";
                    mapOutput += "\n\t| --------------------------------------------------------------- |";
                }
                mapOutput +=
                      "\n\t|-----------------------------------------------------------------|"
                    + "\n\t  E - Dungeon Exit  P = Dungeon Path   ? - Not Yet Visited"
                    + "\n\t  B - Branch        1 = Miniboss 1"
                    + "\n\t  M - Dungeon Boss  2 = Miniboss 2"
                    + "\n\t|-----------------------------------------------------------------|";
                break;
            default:
                mapOutput = "ERROR:  Illegal Map - Map must be for Forest or "
                    + "Dungeon";
        }
        
        this.console.println(mapOutput);
    }
}
