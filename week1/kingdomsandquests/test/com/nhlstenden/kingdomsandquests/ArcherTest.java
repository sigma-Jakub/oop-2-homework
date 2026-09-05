package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest
{
    @Test
    void useSpecialAbility_calledOnce_doublesAttackDamage()
    {
        Archer archer = new Archer(10, 5, List.of("keen eye"), List.of("aim"));

        archer.useSpecialAbility();

        assertEquals(20, archer.getAttackDamage());
    }
}
