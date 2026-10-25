package com.nhlstenden.nuclearpowerplant;

import java.util.HashSet;

public class Reactor implements Building
{
    private HashSet<SplittingRod> rods;
    private static final double MIN_ROD_PERCENTAGE_THRESHOLD = 0.2;

    public Reactor()
    {
        this.rods = new HashSet<>();
    }

    public HashSet<SplittingRod> getRods()
    {
        return this.rods;
    }

    public void setRods(HashSet<SplittingRod> rods)
    {
        if (rods == null)
        {
            throw new IllegalArgumentException("rods cannot be null");
        }

        for (SplittingRod rodItem : rods)
        {
            if (rodItem == null)
            {
                throw new IllegalArgumentException("rodItem cannot be null");
            }
        }

        this.rods = rods;
    }

    public void addCore(SplittingRod splittingRod)
    {
        if (splittingRod == null)
        {
            throw new IllegalArgumentException("splittingRod cannot be null");
        }

        this.rods.add(splittingRod);
    }

    public SplitResult run(int time, int temperature)
    {
        double amountOfSteam = 0.0;
        double residualHeat = 0.0;

        if (time < 0 || temperature < 0)
        {
            throw new IllegalArgumentException("values cannot be negative");
        }

        for (SplittingRod rod : this.rods)
        {
            SplitResult result = rod.split(time, temperature);
            amountOfSteam += result.getAmountOfSteam();
            residualHeat += result.getResidualHeat();
        }

        return new SplitResult(amountOfSteam, residualHeat);
    }

    @Override
    public Status getStatus()
    {
        for (SplittingRod rod : this.rods)
        {
            if (rod.getPercentageLeft() <= MIN_ROD_PERCENTAGE_THRESHOLD)
            {
                return Status.NEEDS_ATTENTION;
            }
        }

        return Status.STABLE;
    }
}
