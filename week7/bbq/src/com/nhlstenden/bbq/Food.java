package com.nhlstenden.bbq;

public abstract class Food implements HasTemperature
{
    protected static final double TEMPERATURE_INCREASE_DEGREE_PER_SECOND = 0.5;
    private double currentBrownPercentage;
    private double browningFactor;
    private double currentTemperature;

    public Food(double browningFactor)
    {
        this.browningFactor = browningFactor;
        this.currentBrownPercentage = 0.0;
        this.currentTemperature = 0.0;
    }

    public double getCurrentBrownPercentage()
    {
        return this.currentBrownPercentage;
    }

    public void setCurrentBrownPercentage(double currentBrownPercentage)
    {
        if (currentBrownPercentage < 0.0)
        {
            throw new IllegalArgumentException("currentBrownPercentage cannot be negative");
        }

        this.currentBrownPercentage = currentBrownPercentage;
    }

    public double getBrowningFactor()
    {
        return this.browningFactor;
    }

    public void setBrowningFactor(double browningFactor)
    {
        if (browningFactor < 0.0)
        {
            throw new IllegalArgumentException("browningFactor cannot be negative");
        }

        this.browningFactor = browningFactor;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature)
    {
        if (currentTemperature < 0.0)
        {
            throw new IllegalArgumentException("currentTemperature cannot be negative");
        }

        this.currentTemperature = currentTemperature;
    }

    public abstract void grill(double temperature);
    public abstract String toString();

    @Override
    public double readTemperature()
    {
        return this.currentTemperature;
    }
}
