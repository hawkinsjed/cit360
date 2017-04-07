/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;


public class Scene extends Location implements Serializable
{
    //class instance variables
    private String sceneName;
    private String sceneDescription;
    private NPC[] npcs;
    private boolean closed;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Scene()
    {
        super();  //Call superclass Location constructor
        this.sceneName = "No Name";
        this.sceneDescription = "No Description";
       this.npcs = new NPC[1];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = new NPC();
        }
        this.closed = false;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Scene(int row, int column, boolean visited, String sceneName, 
            String sceneDescription, Clue clue, NPC[] npcs, boolean closed)
    {
        super(row, column, visited);  //Call Location non-default constructor
        this.sceneName = sceneName;
        this.sceneDescription = sceneDescription;
        this.npcs = new NPC[npcs.length];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = npcs[i];
        }
        this.closed = closed;
    }

    public Scene(String sceneName, String sceneDescription, NPC[] npcs, 
    boolean closed)
    {
        super();  //Call Location non-default constructor
        this.sceneName = sceneName;
        this.sceneDescription = sceneDescription;
        this.npcs = new NPC[npcs.length];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = npcs[i];
        }
        this.closed = closed;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Scene(Scene otherScene)
    {
        super(otherScene);
        this.sceneName = otherScene.sceneName;
        this.sceneDescription = otherScene.sceneDescription;
        this.npcs = new NPC[otherScene.npcs.length];
        for (int i = 0; i < this.npcs.length; i++)
        {
            this.npcs[i] = otherScene.npcs[i];
        }
        this.closed = otherScene.closed;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getName() {
        return sceneName;
    }

    public void setName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getDescription() {
        return sceneDescription;
    }

    public void setDescription(String sceneDescription) {
        this.sceneDescription = sceneDescription;
    }

    public NPC[] getNPC() {
        return npcs;
    }

    public void setNPC(NPC npcs, int position) {
        this.npcs[position] = npcs;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.sceneName);
        hash = 31 * hash + Objects.hashCode(this.sceneDescription);
        hash = 31 * hash + Arrays.deepHashCode(this.npcs);
        hash = 31 * hash + (this.closed ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.sceneName, other.sceneName)) {
            return false;
        }
        if (!Objects.equals(this.sceneDescription, other.sceneDescription)) {
            return false;
        }
        if (!Arrays.deepEquals(this.npcs, other.npcs)) {
            return false;
        }
        if (this.closed != other.closed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        String returnString = "Scene{" + "row=" + super.getRow() + " column=" +
                super.getColumn() + " visited=" + super.getVisited() +
                "sceneName=" + sceneName + ", sceneDescription=" +
                sceneDescription + ", npcs=";
        
        for (int i = 0; i < npcs.length; i++)
        {
            returnString += npcs[i].toString();
        }
        
        returnString += ", closed=" + closed + '}';
        
        return returnString;
    }
}
