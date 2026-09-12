package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialQuestTest
{
    @Test
    void constructor_validArguments_setsItemsReward()
    {
        SpecialQuest quest = new SpecialQuest(60, 2, List.of(new Item("Ring of Vigor")));

        assertEquals(1, quest.getItemsReward().size());
        assertEquals("Ring of Vigor", quest.getItemsReward().get(0).getTitle());
    }

    @Test
    void constructor_nullItemsReward_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new SpecialQuest(60, 2, null));
    }

    @Test
    void constructor_emptyItemsReward_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new SpecialQuest(60, 2, List.of()));
    }

    @Test
    void setItemsReward_listContainingNull_throwsIllegalArgumentException()
    {
        SpecialQuest quest = new SpecialQuest(60, 2, List.of(new Item("Ring of Vigor")));
        List<Item> itemsWithNull = new ArrayList<>();
        itemsWithNull.add(null);

        assertThrows(IllegalArgumentException.class, () -> quest.setItemsReward(itemsWithNull));
    }

    @Test
    void completeQuest_playerHasQuest_removesQuestAndAddsXpReward()
    {
        Player player = new Player(new Archer(10, 5, List.of("keen eye"), List.of("aim")));
        SpecialQuest quest = new SpecialQuest(60, 0, List.of(new Item("Ring of Vigor")));
        player.addQuest(quest);

        quest.completeQuest(player);

        assertEquals(60, player.getTotalXp());
        assertFalse(player.getAvailableQuests().contains(quest));
    }
}
