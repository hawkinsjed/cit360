/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;
import java.util.Objects;


public class Clue implements Serializable
{
    private String clueName;
    private String npcClue;
    private String sceneClue;
    private String completedQuest;
    private Item sceneItem;
    private Item npcReward;
    private boolean clueObtained;
    private boolean retrieved;  //Retrieve item from scene if any
    private boolean completed;  //Complete quest clue
    
    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Clue()
    {
        this.clueName = "None";
        this.npcClue = "";
        this.sceneClue = "";
        this.completedQuest = "";
        this.sceneItem = Item.None;
        this.npcReward = Item.None;
        this.clueObtained = false;
        this.retrieved = true;
        this.completed = true;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public Clue(String clueName, String npcClue, String sceneClue, 
        String completedQuest, Item sceneItem, Item npcReward, 
        boolean clueObtained, boolean retrieved, boolean completed)
    {
        this.clueName = clueName;
        this.npcClue = npcClue;
        this.sceneClue = sceneClue;
        this.completedQuest = completedQuest;
        this.sceneItem = sceneItem;
        this.npcReward = npcReward;
        this.clueObtained = clueObtained;
        this.retrieved = retrieved;
        this.completed = completed;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public Clue(Clue otherClue)
    {
        this.clueName = otherClue.clueName;
        this.npcClue = otherClue.npcClue;
        this.sceneClue = otherClue.sceneClue;
        this.completedQuest = otherClue.completedQuest;
        this.sceneItem = otherClue.sceneItem;
        this.npcReward = otherClue.npcReward;
        this.clueObtained = otherClue.clueObtained;
        this.retrieved = otherClue.retrieved;
        this.completed = otherClue.completed;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getClueName()
    {
        return this.clueName;
    }
    
    public void setClueName(String clueName)
    {
        this.clueName = clueName;
    }
    
    public String getNPCClue()
    {
        return npcClue;
    }
    
    public void setNPCClue(String npcClue)
    {
        this.npcClue = npcClue;
    }
    
    public String getSceneClue()
    {
        return sceneClue;
    }
    
    public void setSceneClue(String sceneClue)
    {
        this.sceneClue = sceneClue;
    }
    
    public String getCompletedQuest()
    {
        return completedQuest;
    }
    
    public void setCompletedQuest(String completedQuest)
    {
        this.completedQuest = completedQuest;
    }
    
    public Item getSceneItem()
    {
        return sceneItem;
    }
    
    public void setSceneItem(Item sceneItem)
    {
        this.sceneItem = sceneItem;
    }
    
    public Item getNPCReward()
    {
        return npcReward;
    }
    
    public void setNPCReward(Item npcReward)
    {
        this.npcReward = npcReward;
    }
    
    public boolean getClueObtained()
    {
        return clueObtained;
    }
    
    public void setClueObtained(boolean clueObtained)
    {
        this.clueObtained = clueObtained;
    }
    
    public boolean getRetrieved()
    {
        return retrieved;
    }
    
    public void setRetrieved(boolean retrieved)
    {
        this.retrieved = retrieved;
    }
    
    public boolean getCompleted()
    {
        return completed;
    }
    
    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }
    
    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.clueName);
        hash = 23 * hash + Objects.hashCode(this.npcClue);
        hash = 23 * hash + Objects.hashCode(this.sceneClue);
        hash = 23 * hash + Objects.hashCode(this.completedQuest);
        hash = 23 * hash + Objects.hashCode(this.sceneItem);
        hash = 23 * hash + Objects.hashCode(this.npcReward);
        hash = 23 * hash + Objects.hashCode(this.clueObtained);
        hash = 23 * hash + Objects.hashCode(this.retrieved);
        hash = 23 * hash + Objects.hashCode(this.completed);
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
        final Clue other = (Clue) obj;
        if (!Objects.equals(this.clueName, other.clueName)) {
            return false;
        }
        if (!Objects.equals(this.npcClue, other.npcClue)) {
            return false;
        }
        if (!Objects.equals(this.sceneClue, other.sceneClue)) {
            return false;
        }
        if (!Objects.equals(this.completedQuest, other.completedQuest))
        {
            return false;
        }
        if (this.sceneItem != other.sceneItem) {
            return false;
        }
        if (this.npcReward != other.npcReward) {
            return false;
        }
        if (this.clueObtained != other.clueObtained)
        {
            return false;
        }
        if (this.retrieved != other.retrieved)
        {
            return false;
        }
        if (this.completed != other.completed)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clue{" + "clueName=" + clueName + ", npcClue=" + npcClue + 
            ", sceneClue=" + sceneClue + ", completedQuest=" + completedQuest +
            ", sceneItem=" + sceneItem + ", npcReward=" + npcReward + 
            ", clueObtained=" + clueObtained +
            ", retrieved=" + retrieved + ", completed=" + completed + '}';
    }
    
}
