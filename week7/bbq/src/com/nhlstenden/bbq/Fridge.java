package com.nhlstenden.bbq;

import java.util.HashSet;

public class Fridge implements HasTemperature
{
    private static final int DEFAULT_FRIDGE_TEMPERATURE = 8;
    private static Fridge instance;
    private HashSet<Food> foodInFridge;
    private int temperature;

    private Fridge()
    {
        this.foodInFridge = new HashSet<>();
        this.temperature = DEFAULT_FRIDGE_TEMPERATURE;
    }

    public static Fridge getInstance()
    {
        if (instance == null)
        {
            instance = new Fridge();
        }

        return instance;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public HashSet<Food> getFoodInFridge()
    {
        return this.foodInFridge;
    }

    public void setFoodInFridge(HashSet<Food> foodInFridge)
    {
        if (foodInFridge == null)
        {
            throw new IllegalArgumentException("foodInFridge cannot be null");
        }

        for (Food foodItem : foodInFridge)
        {
            if (foodItem == null)
            {
                throw new IllegalArgumentException("foodItem cannot be null");
            }
        }

        this.foodInFridge = foodInFridge;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("food cannot be null");
        }

        this.foodInFridge.add(food);
    }

    public Meat getNextMeat()
    {
        this.validateFridge();

        for (Food food : this.foodInFridge)
        {
            if (food instanceof Meat meat)
            {
                this.foodInFridge.remove(food);
                return meat;
            }
        }

        throw new NoMoreFoodException("no more meat in the fridge");
    }

    public Vegetable getNextVegetable()
    {
        this.validateFridge();

        for (Food food : this.foodInFridge)
        {
            if (food instanceof Vegetable vegetable)
            {
                this.foodInFridge.remove(food);
                return vegetable;
            }
        }

        throw new NoMoreFoodException("no more vegetables in the fridge");
    }

    private void validateFridge()
    {
        if (this.foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException("there is no more food in the fridge");
        }
    }

    @Override
    public double readTemperature()
    {
        return this.temperature;
    }
}
