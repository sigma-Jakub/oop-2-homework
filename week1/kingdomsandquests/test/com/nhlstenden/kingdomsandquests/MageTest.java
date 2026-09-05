package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest
{
    @Test
    void constructor_validArguments_setsIncreasedDefenseValue()
    {
        Mage mage = new Mage(8, 6, List.of("wise"), List.of("fireball"), 3);

        assertEquals(3, mage.getIncreasedDefenseValue());
    }

    @Test
    void setIncreasedDefenseValue_zeroValue_throwsIllegalArgumentException()
    {
        Mage mage = new Mage(8, 6, List.of("wise"), List.of("fireball"), 3);

        assertThrows(IllegalArgumentException.class, () -> mage.setIncreasedDefenseValue(0));
    }

    @Test
    void useSpecialAbility_calledOnce_increasesDefensePointsByIncreasedDefenseValue()
    {
        Mage mage = new Mage(8, 6, List.of("wise"), List.of("fireball"), 3);

        mage.useSpecialAbility();

        assertEquals(9, mage.getDefensePoints());
    }
}
