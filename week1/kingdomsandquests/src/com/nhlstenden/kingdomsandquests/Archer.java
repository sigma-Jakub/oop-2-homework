package com.nhlstenden.kingdomsandquests;

import java.util.List;

public class Archer extends Character
{
    private static final int DAMAGE_MULT_VALUE = 2;

    public Archer(int attackDamage, int defensePoints, List<String> attributes, List<String> abilities)
    {
        super(attackDamage, defensePoints, attributes, abilities);
    }

    @Override
    public void useSpecialAbility()
    {
        this.setAttackDamage(this.getAttackDamage() * DAMAGE_MULT_VALUE);
    }
}
