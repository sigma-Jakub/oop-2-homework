package com.nhlstenden.bbq;

import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class SmartBBQ implements HasTemperature
{
    private static final int BBQ_CAPACITY = 6;
    private static final int MAXIMUM_TEMPERATURE = 250;
    private HashSet<Food> food;
    private int temperature;

    public SmartBBQ()
    {
        this.food = new HashSet<>();
        this.temperature = 0;
    }

    public HashSet<Food> getFood()
    {
        return this.food;
    }

    public void setFood(HashSet<Food> food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("food cannot be null");
        }

        for (Food foodItem : food)
        {
            if (foodItem == null)
            {
                throw new IllegalArgumentException("foodItem cannot be null");
            }
        }

        this.food = food;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        if (temperature < 0 || temperature > MAXIMUM_TEMPERATURE)
        {
            throw new IllegalArgumentException("temperature must be between 0 and 250");
        }

        this.temperature = temperature;
    }

    public void turnOn(int temperature)
    {
        if (temperature <= 0 || temperature > MAXIMUM_TEMPERATURE)
        {
            throw new IllegalArgumentException("temperature must be between 1 and 250");
        }

        if (this.temperature > 0)
        {
            throw new IllegalStateException("smartBBQ is already turned on");
        }

        this.temperature = temperature;
    }

    public void turnOff()
    {
        this.temperature = 0;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("food cannot be null");
        }

        if (this.food.size() == BBQ_CAPACITY)
        {
            throw new IllegalStateException("bbq is currently full");
        }

        this.food.add(food);
    }

    @Override
    public double readTemperature()
    {
        return this.temperature;
    }
}
