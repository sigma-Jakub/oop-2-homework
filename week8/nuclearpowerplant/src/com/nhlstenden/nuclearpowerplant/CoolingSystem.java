package com.nhlstenden.nuclearpowerplant;

public class CoolingSystem implements Building
{
    private static final double WATER_TEMPERATURE_VALUE = 0.4;
    private double waterTemperature;
    private static final double MAX_TEMPERATURE_THRESHOLD = 90.0;
    private static final double SAFE_TEMPERATURE_THRESHOLD = 80.0;

    public CoolingSystem()
    {
        this.setWaterTemperature(0.0);
    }

    public double getWaterTemperature()
    {
        return this.waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature)
    {
        if (waterTemperature < 0.0)
        {
            throw new IllegalArgumentException("waterTemperature cannot be negative");
        }

        this.waterTemperature = waterTemperature;
    }

    public void abductResidualHeat(double residualHeat)
    {
        if (residualHeat < 0.0)
        {
            throw new IllegalArgumentException("residualHeat cannot be negative");
        }

        this.waterTemperature = residualHeat * WATER_TEMPERATURE_VALUE;
    }

    @Override
    public Status getStatus()
    {
        if (this.waterTemperature >= MAX_TEMPERATURE_THRESHOLD)
        {
            return Status.UNSTABLE;
        }

        if (this.waterTemperature < MAX_TEMPERATURE_THRESHOLD && this.waterTemperature >= SAFE_TEMPERATURE_THRESHOLD)
        {
            return Status.NEEDS_ATTENTION;
        }

        return Status.STABLE;
    }
}
