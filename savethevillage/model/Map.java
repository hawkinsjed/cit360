/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Map implements Serializable {
    
    private String mapName;
    private int totalRows;
    private int totalColumns;
    private Scene sceneArray[][];
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Map()
    {
        this.mapName = "No Map";
        this.totalRows = 0;
        this.totalColumns = 0;
        this.sceneArray = new Scene[1][1];
        this.sceneArray[0][0] = new Scene();
    }

   /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Map(String mapName)
    {
        //Only 2 types of maps constructed from non-default constructor:
        //Forest and Dungeon
        this.mapName = mapName;
        if (mapName.equals("Forest"))
        {
            this.totalRows = 6;
            this.totalColumns = 6;
            this.sceneArray = new Scene[totalRows][totalColumns];
            for (int i = 0; i < totalRows; i++)
            {
                for (int j = 0; j < totalColumns; j++)
                {
                    this.sceneArray[i][j] = new Scene();
                }
            }
        }
        else if(mapName.equals("Dungeon"))
        {
            this.totalRows = 9;
            this.totalColumns = 9;
            this.sceneArray = new Scene[totalRows][totalColumns];
            for (int i = 0; i < totalRows; i++)
            {
                for (int j = 0; j < totalColumns; j++)
                {
                    this.sceneArray[i][j] = new Scene();
                }
            }
        }
        else  //Invalid Map Name
        {
            this.mapName = "Invalid";
            this.totalRows = 0;
            this.totalColumns = 0;
            this.sceneArray = new Scene[1][1];
            this.sceneArray[0][0] = new Scene();
        }
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Map(Map otherMap)
    {
        this.mapName = otherMap.mapName;
        this.totalRows = otherMap.totalRows;
        this.totalColumns = otherMap.totalColumns;
        this.sceneArray = otherMap.sceneArray;
    }


    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }
    
    public Scene[][] getSceneArray()
    {
        return this.sceneArray;
    }
    
    public void setSceneArray(Scene[][] sceneArray)
    {
        this.sceneArray = sceneArray;
    }
    
    public Scene getScene(int row, int column)
    {
        return this.sceneArray[row][column];
    }
    
    public void setScene(Scene scene, int row, int column)
    {
        this.sceneArray[row][column] = scene;
    }
    
    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.mapName);
        hash = 97 * hash + this.totalRows;
        hash = 97 * hash + this.totalColumns;
        hash = 97 * hash + Arrays.deepHashCode(this.sceneArray);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.totalRows != other.totalRows) {
            return false;
        }
        if (this.totalColumns != other.totalColumns) {
            return false;
        }
        if (!Objects.equals(this.mapName, other.mapName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.sceneArray, other.sceneArray))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String returnString = "Map{" + "mapName=" + mapName +
        ", totalRows=" + totalRows + ", totalColumns=" + totalColumns + "(";
        
        for (Scene[] sceneRow : sceneArray)
        {
            for (Scene scene : sceneRow)
            {
                returnString += scene.toString();
            }
        }
      
        returnString += ")}";
    
        return returnString;
    }
    
    
}
