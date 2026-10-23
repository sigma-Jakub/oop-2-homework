package com.nhlstenden.bbq;

public abstract class Vegetable extends Food
{
    private static final double DEFAULT_MOIST_PERCENTAGE = 100.0;
    private double moistPercentage;
    private double moistFactor;

    public Vegetable(double browningFactor, double moistFactor)
    {
        super(browningFactor);
        this.moistFactor = moistFactor;
        this.moistPercentage = DEFAULT_MOIST_PERCENTAGE;
    }

    public double getMoistFactor()
    {
        return this.moistFactor;
    }

    public void setMoistFactor(double moistFactor)
    {
        if (moistFactor <= 0.0)
        {
            throw new IllegalArgumentException("moistFactor cannot be zero or negative");
        }

        this.moistFactor = moistFactor;
    }

    public double getMoistPercentage()
    {
        return this.moistPercentage;
    }

    public void setMoistPercentage(double moistPercentage)
    {
        if (moistPercentage < 0.0 || moistPercentage > DEFAULT_MOIST_PERCENTAGE)
        {
            throw new IllegalArgumentException("moistPercentage must be between 0 and 100");
        }

        this.moistPercentage = moistPercentage;
    }

    public void decreaseMoistPercentage(double difference)
    {
        if (difference < 0.0)
        {
            throw new IllegalArgumentException("difference cannot be negative");
        }

        double updatedMoistPercentage = this.moistPercentage - difference;

        this.moistPercentage = Math.max(updatedMoistPercentage, 0.0);
    }

    @Override
    public void grill(double temperature)
    {
        if (temperature <= 0.0)
        {
            throw new IllegalArgumentException("temperature cannot be zero or negative");
        }

        this.setCurrentTemperature(this.getCurrentTemperature() + TEMPERATURE_INCREASE_DEGREE_PER_SECOND);
        this.setCurrentBrownPercentage(this.getCurrentBrownPercentage() + (this.getBrowningFactor() * temperature));
        this.decreaseMoistPercentage(this.moistFactor * temperature);
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
