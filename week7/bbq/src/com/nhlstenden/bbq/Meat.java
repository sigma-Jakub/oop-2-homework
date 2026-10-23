package com.nhlstenden.bbq;

public abstract class Meat extends Food
{
    private double currentCookedPercentage;
    private double cookingFactor;
    private MeatType meatType;

    public Meat(MeatType meatType, double cookingFactor, double browningFactor)
    {
        super(browningFactor);
        this.meatType = meatType;
        this.cookingFactor = cookingFactor;
        this.currentCookedPercentage = 0.0;
    }

    public double getCookingFactor()
    {
        return this.cookingFactor;
    }

    public void setCookingFactor(double cookingFactor)
    {
        if (cookingFactor <= 0.0)
        {
            throw new IllegalArgumentException("cookingFactor cannot be zero or negative");
        }

        this.cookingFactor = cookingFactor;
    }

    public double getCurrentCookedPercentage()
    {
        return this.currentCookedPercentage;
    }

    public void setCurrentCookedPercentage(double currentCookedPercentage)
    {
        if (currentCookedPercentage < 0.0)
        {
            throw new IllegalArgumentException("currentCookedPercentage cannot be negative");
        }

        this.currentCookedPercentage = currentCookedPercentage;
    }

    public MeatType getMeatType()
    {
        return this.meatType;
    }

    public void setMeatType(MeatType meatType)
    {
        if (meatType == null)
        {
            throw new IllegalArgumentException("meatType cannot be null");
        }

        this.meatType = meatType;
    }

    @Override
    public void grill(double temperature)
    {
        if (temperature <= 0.0)
        {
            throw new IllegalArgumentException("temperature cannot be zero or negative");
        }

        this.setCurrentTemperature(this.getCurrentTemperature() + TEMPERATURE_INCREASE_DEGREE_PER_SECOND);
        this.currentCookedPercentage += ((1.0 / (this.cookingFactor * Math.PI)) * temperature);
        this.setCurrentBrownPercentage(this.getCurrentBrownPercentage() + (this.getBrowningFactor() * (temperature / 100.0)));
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
