package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularQuestTest
{
    @Test
    void constructor_validArguments_setsXpRewardAndDifficultyLevel()
    {
        RegularQuest quest = new RegularQuest(40, 2);

        assertEquals(40, quest.getXpReward());
        assertEquals(2, quest.getDifficultyLevel());
        assertEquals(20, quest.getMinXpRequirement());
    }
}
