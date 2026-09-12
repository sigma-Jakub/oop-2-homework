package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class Warrior extends Character
{
    private int increasedDamageValue;
    private int increasedDamageValueLengthInSeconds;

    public Warrior(int attackDamage, int defensePoints, List<String> attributes, List<String> abilities, int increasedDamageValue, int increasedDamageValueLengthInSeconds)
    {
        super(attackDamage, defensePoints, attributes, abilities);
        this.increasedDamageValue = increasedDamageValue;
        this.increasedDamageValueLengthInSeconds = increasedDamageValueLengthInSeconds;
    }

    public int getIncreasedDamageValue()
    {
        return this.increasedDamageValue;
    }

    public void setIncreasedDamageValue(int increasedDamageValue)
    {
        if (increasedDamageValue <= 0)
        {
            throw new IllegalArgumentException("increasedDamageValue cannot be zero or negative");
        }

        this.increasedDamageValue = increasedDamageValue;
    }

    public int getIncreasedDamageValueLengthInSeconds()
    {
        return this.increasedDamageValueLengthInSeconds;
    }

    public void setIncreasedDamageValueLengthInSeconds(int increasedDamageValueLengthInSeconds)
    {
        if (increasedDamageValueLengthInSeconds <= 0)
        {
            throw new IllegalArgumentException("increasedDamageValueLengthInSeconds cannot be zero or negative");
        }

        this.increasedDamageValueLengthInSeconds = increasedDamageValueLengthInSeconds;
    }

    @Override
    public void useSpecialAbility()
    {
        this.setAttackDamage(this.getAttackDamage() + this.increasedDamageValue);

        try
        {
            Thread.sleep(this.increasedDamageValueLengthInSeconds * 1000L);
        }
        catch (InterruptedException exception)
        {
            Thread.currentThread().interrupt();
        }

        this.setAttackDamage(this.getAttackDamage() - this.increasedDamageValue);
    }
}
