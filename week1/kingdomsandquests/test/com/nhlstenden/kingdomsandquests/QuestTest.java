package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest
{
    @Test
    void constructor_validArguments_setsXpRewardDifficultyLevelAndMinXpRequirement()
    {
        Quest quest = new Quest(50, 3) {};

        assertEquals(50, quest.getXpReward());
        assertEquals(3, quest.getDifficultyLevel());
        assertEquals(30, quest.getMinXpRequirement());
    }

    @Test
    void constructor_zeroXpReward_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Quest(0, 3) {});
    }

    @Test
    void constructor_negativeDifficultyLevel_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Quest(50, -1) {});
    }

    @Test
    void setXpReward_negativeValue_throwsIllegalArgumentException()
    {
        Quest quest = new Quest(50, 3) {};

        assertThrows(IllegalArgumentException.class, () -> quest.setXpReward(-10));
    }

    @Test
    void setMinXpRequirement_negativeValue_throwsIllegalArgumentException()
    {
        Quest quest = new Quest(50, 3) {};

        assertThrows(IllegalArgumentException.class, () -> quest.setMinXpRequirement(-1));
    }

    @Test
    void completeQuest_playerHasQuest_removesQuestAndAddsXpReward()
    {
        Player player = new Player(new Archer(10, 5, List.of("keen eye"), List.of("aim")));
        Quest quest = new Quest(50, 0) {};
        player.addQuest(quest);

        quest.completeQuest(player);

        assertEquals(50, player.getTotalXp());
        assertFalse(player.getAvailableQuests().contains(quest));
    }
}
