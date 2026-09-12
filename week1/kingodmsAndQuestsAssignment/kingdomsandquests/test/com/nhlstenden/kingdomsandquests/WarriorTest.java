package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest
{
    @Test
    void constructor_validArguments_setsIncreasedDamageFields()
    {
        Warrior warrior = new Warrior(10, 5, List.of("strong"), List.of("cleave"), 4, 1);

        assertEquals(4, warrior.getIncreasedDamageValue());
        assertEquals(1, warrior.getIncreasedDamageValueLengthInSeconds());
    }

    @Test
    void setIncreasedDamageValue_zeroValue_throwsIllegalArgumentException()
    {
        Warrior warrior = new Warrior(10, 5, List.of("strong"), List.of("cleave"), 4, 1);

        assertThrows(IllegalArgumentException.class, () -> warrior.setIncreasedDamageValue(0));
    }

    @Test
    void setIncreasedDamageValueLengthInSeconds_negativeValue_throwsIllegalArgumentException()
    {
        Warrior warrior = new Warrior(10, 5, List.of("strong"), List.of("cleave"), 4, 1);

        assertThrows(IllegalArgumentException.class, () -> warrior.setIncreasedDamageValueLengthInSeconds(-1));
    }

    @Test
    void useSpecialAbility_afterDurationElapses_attackDamageReturnsToOriginalValue()
    {
        Warrior warrior = new Warrior(10, 5, List.of("strong"), List.of("cleave"), 4, 1);
        int originalAttackDamage = warrior.getAttackDamage();

        warrior.useSpecialAbility();

        assertEquals(originalAttackDamage, warrior.getAttackDamage());
    }
}
