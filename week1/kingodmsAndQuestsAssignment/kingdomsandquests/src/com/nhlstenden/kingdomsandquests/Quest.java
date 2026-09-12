package com.nhlstenden.kingdomsandquests;

abstract public class Quest
{
    static final int MIN_XP_REQUIRED_MULT_VALUE = 10;
    private int xpReward;
    private int difficultyLevel;
    private int minXpRequirement;

    public Quest(int xpReward, int difficultyLevel)
    {
        this.setXpReward(xpReward);
        this.setDifficultyLevel(difficultyLevel);
        this.setMinXpRequirement(difficultyLevel * MIN_XP_REQUIRED_MULT_VALUE);
    }

    public int getXpReward()
    {
        return this.xpReward;
    }

    public void setXpReward(int xpReward)
    {
        if (xpReward <= 0)
        {
            throw new IllegalArgumentException("xpReward cannot be equal to 0 or negative");
        }

        this.xpReward = xpReward;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel)
    {
        if (difficultyLevel < 0)
        {
            throw new IllegalArgumentException("difficultyLevel cannot be negative");
        }

        this.difficultyLevel = difficultyLevel;
    }

    public int getMinXpRequirement()
    {
        return this.minXpRequirement;
    }

    public void setMinXpRequirement(int minXpRequirement)
    {
        if (minXpRequirement < 0)
        {
            throw new IllegalArgumentException("minXpRequirement cannot be negative");
        }

        this.minXpRequirement = minXpRequirement;
    }

    public void completeQuest(Player player)
    {
        player.removeQuest(this);
        player.setTotalXp(player.getTotalXp() + this.getXpReward());
    }
}
