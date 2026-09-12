package com.nhlstenden.kingdomsandquests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{
    @Test
    void getTitle_afterConstruction_returnsGivenTitle()
    {
        Item item = new Item("Sword of Embers");

        assertEquals("Sword of Embers", item.getTitle());
    }

    @Test
    void constructor_nullTitle_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Item(null));
    }

    @Test
    void constructor_blankTitle_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Item("   "));
    }

    @Test
    void setTitle_validValue_updatesTitle()
    {
        Item item = new Item("Sword of Embers");

        item.setTitle("Shield of Dawn");

        assertEquals("Shield of Dawn", item.getTitle());
    }
}
