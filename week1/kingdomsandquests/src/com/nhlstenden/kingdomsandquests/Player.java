package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private static final int REQUIRED_XP_TO_LEVEL_UP = 200;
    private Character character;
    private List<Quest> availableQuests;
    private int totalXp;

    public Player(Character character)
    {
        this.setCharacter(character);
        this.setAvailableQuests(new ArrayList<>());
    }

    public Character getCharacter()
    {
        return this.character;
    }

    public void setCharacter(Character character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("character cannot be null");
        }

        this.character = character;
    }

    public List<Quest> getAvailableQuests()
    {
        List<Quest> availableQuests = new ArrayList<>();

        for (Quest quest : this.availableQuests)
        {
            if (quest.getMinXpRequirement() <= this.totalXp)
            {
                availableQuests.add(quest);
            }
        }

        return availableQuests;
    }

    public void setAvailableQuests(List<Quest> availableQuests)
    {
        if (availableQuests == null)
        {
            throw new IllegalArgumentException("availableQuests cannot be null");
        }

        for (Quest availableQuestsItem : availableQuests)
        {
            if (availableQuestsItem == null)
            {
                throw new IllegalArgumentException("availableQuests cannot be null");
            }
        }

        this.availableQuests = new ArrayList<>(availableQuests);
    }

    public int getLevel()
    {
        return this.totalXp / REQUIRED_XP_TO_LEVEL_UP;
    }

    public int getTotalXp()
    {
        return this.totalXp;
    }

    public void setTotalXp(int totalXp)
    {
        if (totalXp < 0)
        {
            throw new IllegalArgumentException("totalXp cannot be negative");
        }

        this.totalXp = totalXp;
    }

    public void addQuest(Quest quest)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("quest cannot be null");
        }

        this.availableQuests.add(quest);
    }

    public void removeQuest(Quest quest)
    {
        this.availableQuests.remove(quest);
    }
}
