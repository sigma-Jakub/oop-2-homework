package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingdomsAndQuestsTest
{
    private Player createPlayer()
    {
        return new Player(new Archer(10, 5, List.of("keen eye"), List.of("aim")));
    }

    @Test
    void constructor_default_startsWithNoPlayers()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();

        assertTrue(kingdomsAndQuests.getPlayers().isEmpty());
    }

    @Test
    void addPlayer_nullPlayer_throwsIllegalArgumentException()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();

        assertThrows(IllegalArgumentException.class, () -> kingdomsAndQuests.addPlayer(null));
    }

    @Test
    void addPlayer_validPlayer_appearsInPlayersList()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();
        Player player = this.createPlayer();

        kingdomsAndQuests.addPlayer(player);

        assertTrue(kingdomsAndQuests.getPlayers().contains(player));
    }

    @Test
    void removePlayer_existingPlayer_noLongerAppearsInPlayersList()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();
        Player player = this.createPlayer();
        kingdomsAndQuests.addPlayer(player);

        kingdomsAndQuests.removePlayer(player);

        assertFalse(kingdomsAndQuests.getPlayers().contains(player));
    }

    @Test
    void setPlayers_nullList_throwsIllegalArgumentException()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();

        assertThrows(IllegalArgumentException.class, () -> kingdomsAndQuests.setPlayers(null));
    }

    @Test
    void setPlayers_listContainingNull_throwsIllegalArgumentException()
    {
        KingdomsAndQuests kingdomsAndQuests = new KingdomsAndQuests();
        List<Player> playersWithNull = new ArrayList<>();
        playersWithNull.add(null);

        assertThrows(IllegalArgumentException.class, () -> kingdomsAndQuests.setPlayers(playersWithNull));
    }
}
