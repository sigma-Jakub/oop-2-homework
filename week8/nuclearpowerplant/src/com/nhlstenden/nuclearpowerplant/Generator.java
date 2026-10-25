package com.nhlstenden.nuclearpowerplant;

public class Generator implements Building
{
    private static final double ENERGY_GENERATION_VALUE = 8.0;
    private double totalProducedKwh;
    private static final double MAX_ENERGY_PRODUCTION_THRESHOLD = 560.0;

    public Generator()
    {
        this.setTotalProducedKwh(0.0);
    }

    public double getTotalProducedKwh()
    {
        return this.totalProducedKwh;
    }

    public void setTotalProducedKwh(double totalProducedKwh)
    {
        if (totalProducedKwh < 0.0)
        {
            throw new IllegalArgumentException("totalProducedKwh cannot be negative");
        }

        this.totalProducedKwh = totalProducedKwh;
    }

    public double generateEnergy(double steam)
    {
        if (steam < 0.0)
        {
            throw new IllegalArgumentException("steam cannot be negative");
        }

        double result = steam * ENERGY_GENERATION_VALUE;

        this.totalProducedKwh += result;

        return result;
    }

    @Override
    public Status getStatus()
    {
        if (this.totalProducedKwh > MAX_ENERGY_PRODUCTION_THRESHOLD)
        {
            return Status.UNSTABLE;
        }

        return Status.STABLE;
    }
}
