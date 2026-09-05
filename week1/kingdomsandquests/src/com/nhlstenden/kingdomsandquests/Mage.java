package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class Mage extends Character
{
    private int increasedDefenseValue;

    public Mage(int attackDamage, int defensePoints, List<String> attributes, List<String> abilities, int increasedDefenseValue)
    {
        super(attackDamage, defensePoints, attributes, abilities);
        this.increasedDefenseValue = increasedDefenseValue;
    }

    public int getIncreasedDefenseValue()
    {
        return this.increasedDefenseValue;
    }

    public void setIncreasedDefenseValue(int increasedDefenseValue)
    {
        if (increasedDefenseValue <= 0)
        {
            throw new IllegalArgumentException("increasedDefenseValue cannot be zero or negative");
        }

        this.increasedDefenseValue = increasedDefenseValue;
    }

    @Override
    public void useSpecialAbility()
    {
        this.setDefensePoints(this.getDefensePoints() + this.increasedDefenseValue);
    }
}
