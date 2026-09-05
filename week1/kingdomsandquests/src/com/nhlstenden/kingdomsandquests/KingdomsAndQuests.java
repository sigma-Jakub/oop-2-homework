package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class KingdomsAndQuests
{
    private List<Player> players;

    public KingdomsAndQuests()
    {
        this.setPlayers(new ArrayList<>());
    }

    public List<Player> getPlayers()
    {
        return this.players;
    }

    public void setPlayers(List<Player> players)
    {
        if (players == null)
        {
            throw new IllegalArgumentException("players cannot be null");
        }

        for (Player playersItem : players)
        {
            if (playersItem == null)
            {
                throw new IllegalArgumentException("players cannot be null");
            }
        }

        this.players = new ArrayList<>(players);
    }

    public void addPlayer(Player player)
    {
        if (player == null)
        {
            throw new IllegalArgumentException("player cannot be null");
        }

        this.players.add(player);
    }

    public void removePlayer(Player player)
    {
        this.players.remove(player);
    }
}
