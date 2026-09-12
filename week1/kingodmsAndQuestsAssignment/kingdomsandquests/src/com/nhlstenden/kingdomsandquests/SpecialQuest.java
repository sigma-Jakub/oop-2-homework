package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class SpecialQuest extends Quest
{
    private List<Item> itemsReward;

    public SpecialQuest(int xpReward, int difficultyLevel, List<Item> itemsReward)
    {
        super(xpReward, difficultyLevel);
        this.setItemsReward(itemsReward);
    }

    public List<Item> getItemsReward()
    {
        return this.itemsReward;
    }

    public void setItemsReward(List<Item> itemsReward)
    {
        if (itemsReward == null || itemsReward.isEmpty())
        {
            throw new IllegalArgumentException("itemsReward cannot be null or empty");
        }

        for (Item itemsRewardItem : itemsReward)
        {
            if (itemsRewardItem == null)
            {
                throw new IllegalArgumentException("itemsReward cannot be null");
            }
        }

        this.itemsReward = new ArrayList<>(itemsReward);
    }

    @Override
    public void completeQuest(Player player)
    {
        super.completeQuest(player);

        System.out.println("You have received additional loot:");
        for (Item item : this.getItemsReward())
        {
            System.out.println(item.getTitle());
        }
    }
}
