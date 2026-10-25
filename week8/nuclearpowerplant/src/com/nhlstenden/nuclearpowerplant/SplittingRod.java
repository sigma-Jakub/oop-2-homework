package com.nhlstenden.nuclearpowerplant;

public abstract class SplittingRod
{
    private static final double DEFAULT_RESIDUAL_PERCENTAGE = 100.0;
    private double percentageLeft;

    public SplittingRod()
    {
        this.percentageLeft = DEFAULT_RESIDUAL_PERCENTAGE;
    }

    public double getPercentageLeft()
    {
        return this.percentageLeft;
    }

    public void setPercentageLeft(double percentageLeft)
    {
        if (percentageLeft < 0.0)
        {
            throw new IllegalArgumentException("percentageLeft cannot be negative");
        }

        this.percentageLeft = percentageLeft;
    }

    protected void decreaseResidualPercentage(double decrease, int time)
    {
        this.percentageLeft -= (decrease * time);
    }

    public abstract SplitResult split(int time, int temperature);
}
