package com.nhlstenden.stock;

public class Crypto implements TradeableInterface
{
    private String fullName;
    private int numberOfActiveMiners;

    public Crypto(String fullName, int numberOfActiveMiners)
    {
        this.setFullName(fullName);
        this.setNumberOfActiveMiners(numberOfActiveMiners);
    }

    public String getFullName()
    {
        return this.fullName;
    }

    public void setFullName(String fullName)
    {
        if (fullName == null || fullName.isBlank())
        {
            throw new IllegalArgumentException("fullName cannot be null or blank");
        }

        this.fullName = fullName;
    }

    public int getNumberOfActiveMiners()
    {
        return this.numberOfActiveMiners;
    }

    public void setNumberOfActiveMiners(int numberOfActiveMiners)
    {
        if (numberOfActiveMiners < 0)
        {
            throw new IllegalArgumentException("numberOfActiveMiners cannot be negative");
        }

        this.numberOfActiveMiners = numberOfActiveMiners;
    }

    @Override
    public double getValue()
    {
        return this.numberOfActiveMiners;
    }

    @Override
    public String getAbbreviation()
    {
        return this.fullName.substring(0, 3).toUpperCase();
    }
}
