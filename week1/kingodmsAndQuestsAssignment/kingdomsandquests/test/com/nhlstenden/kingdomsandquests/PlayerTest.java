package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
    private Character createCharacter()
    {
        return new Archer(10, 5, List.of("keen eye"), List.of("aim"));
    }

    @Test
    void constructor_validCharacter_startsWithZeroXpAndNoQuests()
    {
        Player player = new Player(this.createCharacter());

        assertEquals(0, player.getTotalXp());
        assertTrue(player.getAvailableQuests().isEmpty());
    }

    @Test
    void constructor_nullCharacter_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }

    @Test
    void setTotalXp_negativeValue_throwsIllegalArgumentException()
    {
        Player player = new Player(this.createCharacter());

        assertThrows(IllegalArgumentException.class, () -> player.setTotalXp(-1));
    }

    @Test
    void getLevel_totalXpBelowRequiredAmount_returnsZero()
    {
        Player player = new Player(this.createCharacter());

        player.setTotalXp(150);

        assertEquals(0, player.getLevel());
    }

    @Test
    void getLevel_totalXpReaches200_returnsOne()
    {
        Player player = new Player(this.createCharacter());

        player.setTotalXp(200);

        assertEquals(1, player.getLevel());
    }

    @Test
    void addQuest_nullQuest_throwsIllegalArgumentException()
    {
        Player player = new Player(this.createCharacter());

        assertThrows(IllegalArgumentException.class, () -> player.addQuest(null));
    }

    @Test
    void addQuest_validQuest_appearsInAvailableQuests()
    {
        Player player = new Player(this.createCharacter());
        Quest quest = new RegularQuest(30, 0);

        player.addQuest(quest);

        assertTrue(player.getAvailableQuests().contains(quest));
    }

    @Test
    void removeQuest_existingQuest_noLongerAppearsInAvailableQuests()
    {
        Player player = new Player(this.createCharacter());
        Quest quest = new RegularQuest(30, 0);
        player.addQuest(quest);

        player.removeQuest(quest);

        assertFalse(player.getAvailableQuests().contains(quest));
    }

    @Test
    void getAvailableQuests_questRequiresMoreXpThanPlayerHas_isExcluded()
    {
        Player player = new Player(this.createCharacter());
        Quest quest = new RegularQuest(30, 5);
        player.addQuest(quest);

        assertFalse(player.getAvailableQuests().contains(quest));
    }

    @Test
    void setAvailableQuests_nullList_throwsIllegalArgumentException()
    {
        Player player = new Player(this.createCharacter());

        assertThrows(IllegalArgumentException.class, () -> player.setAvailableQuests(null));
    }
}
