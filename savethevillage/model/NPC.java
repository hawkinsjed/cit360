/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;


public class NPC implements Serializable
{
    private String npcName;
    private String associatedScene;
    private boolean captured;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    public NPC()
    {
        this.npcName = "None";
        this.associatedScene = "None";
        this.captured = false;
    }

    /* ********************************************************
    NON-DEFAULT CONSTRUCTOR
    ********************************************************* */
    public NPC(String npcName, String associatedScene, boolean captured)
    {
        this.npcName = npcName;
        this.associatedScene = associatedScene;
        this.captured = captured;
    }

    /* ********************************************************
    COPY CONSTRUCTOR
    ********************************************************* */
    public NPC(NPC otherNPC)
    {
        this.npcName = otherNPC.npcName;
        this.associatedScene = otherNPC.associatedScene;
        this.captured = otherNPC.captured;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getNPCName()
    {
        return this.npcName;
    }
    
    public void setNPCName(String npcName)
    {
        this.npcName = npcName;
    }
    
    public String getAssociatedScene()
    {
        return this.associatedScene;
    }
    
    public void setAssociatedScene(String associatedScene)
    {
        this.associatedScene = associatedScene;
    }

    public boolean getCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }
    
    /* ********************************************************
    OTHER
    ********************************************************* */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.captured ? 1 : 0);
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
        final NPC other = (NPC) obj;
        if (this.captured != other.captured) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "NPC{npcName=" + npcName + ", associatedScene=" + 
            associatedScene +", captured=" + captured + '}';
    }
}