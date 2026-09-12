package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public abstract class Character
{
    private int attackDamage;
    private int defensePoints;
    private List<String> attributes;
    private List<String> abilities;
    private String stance;

    public Character(int attackDamage, int defensePoints, List<String> attributes, List<String> abilities)
    {
        this.setAttackDamage(attackDamage);
        this.setDefensePoints(defensePoints);
        this.setAttributes(attributes);
        this.setAbilities(abilities);
    }

    public int getAttackDamage()
    {
        return this.attackDamage;
    }

    public void setAttackDamage(int attackDamage)
    {
        if (attackDamage <= 0)
        {
            throw new IllegalArgumentException("attackDamage cannot be zero or negative");
        }

        this.attackDamage = attackDamage;
    }

    public int getDefensePoints()
    {
        return this.defensePoints;
    }

    public void setDefensePoints(int defensePoints)
    {
        if (defensePoints < 0)
        {
            throw new IllegalArgumentException("defensePoints cannot be negative");
        }

        this.defensePoints = defensePoints;
    }

    public List<String> getAttributes()
    {
        return this.attributes;
    }

    public void setAttributes(List<String> attributes)
    {
        if (attributes == null || attributes.isEmpty())
        {
            throw new IllegalArgumentException("attributes cannot be null or empty");
        }

        for (String attributesItem : attributes)
        {
            if (attributesItem == null)
            {
                throw new IllegalArgumentException("attributes cannot be null");
            }
        }

        this.attributes = new ArrayList<>(attributes);
    }

    public List<String> getAbilities()
    {
        return this.abilities;
    }

    public void setAbilities(List<String> abilities)
    {
        if (abilities == null || abilities.isEmpty())
        {
            throw new IllegalArgumentException("abilities cannot be null or empty");
        }

        for (String abilitiesItem : abilities)
        {
            if (abilitiesItem == null)
            {
                throw new IllegalArgumentException("abilities cannot be null");
            }
        }

        this.abilities = new ArrayList<>(abilities);
    }

    public void attack()
    {
        this.stance = "attacking";
    }

    public void defend()
    {
        this.stance = "defending";
    }

    public String getStance()
    {
        return this.stance;
    }

    public abstract void useSpecialAbility();
}
