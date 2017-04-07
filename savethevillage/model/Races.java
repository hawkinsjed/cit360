/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveTheVillage.model;

import java.io.Serializable;


public enum Races implements Serializable
{
    HUMAN("Human", Spell.HealingWind, Spell.Fireburst, Spell.SteelBlade),
    ELF("Elf", Spell.IceBlade, Spell.SwiftWind, Spell.BlindingLight),
    DWARF("Dwarf", Spell.Earthquake, Spell.IronBody, Spell.DecimatingBlow);
    
    private String raceName;
    private Spell spell1;
    private Spell spell2;
    private Spell spell3;

    /* ********************************************************
    DEFAULT CONSTRUCTOR
    ********************************************************* */
    Races(String raceName, Spell spell1, Spell spell2, Spell spell3)
    {
        this.raceName="human";
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.spell3 = spell3;
    }

    /* ********************************************************
    ACCESSORS & MUTATORS
    ********************************************************* */
    public String getRaceName() {
        return raceName;
    }

    public Spell getSpell1()
    {
        return spell1;
    }
    
    public Spell getSpell2()
    {
        return spell2;
    }
    
    public Spell getSpell3()
    {
        return spell3;
    }
}                    