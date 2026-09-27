package com.nhlstenden.flightbooking.luggage;

public class Luggage
{
    private double weight;
    private LuggageType type;

    public Luggage(double weight, LuggageType type)
    {
        this.setWeight(weight);
        this.setType(type);
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight(double weight)
    {
        if (weight <= 0.0)
        {
            throw new IllegalArgumentException("weight cannot be zero or negative");
        }

        this.weight = weight;
    }

    public LuggageType getType()
    {
        return this.type;
    }

    public void setType(LuggageType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        this.type = type;
    }
}
