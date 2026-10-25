package com.nhlstenden.nuclearpowerplant;

public class SplitResult
{
    private double residualHeat;
    private double amountOfSteam;

    public SplitResult(double amountOfSteam, double residualHeat)
    {
        this.amountOfSteam = amountOfSteam;
        this.residualHeat = residualHeat;
    }

    public double getAmountOfSteam()
    {
        return this.amountOfSteam;
    }

    public void setAmountOfSteam(double amountOfSteam)
    {
        if (amountOfSteam < 0.0)
        {
            throw new IllegalArgumentException("amountOfSteam cannot be negative");
        }

        this.amountOfSteam = amountOfSteam;
    }

    public double getResidualHeat()
    {
        return this.residualHeat;
    }

    public void setResidualHeat(double residualHeat)
    {
        if (residualHeat < 0.0)
        {
            throw new IllegalArgumentException("residualHeat cannot be negative");
        }

        this.residualHeat = residualHeat;
    }
}
