package com.nhlstenden.nuclearpowerplant;

public class Nhlium extends SplittingRod
{
    private static final double STEAM_COUNTING_VALUE = 0.9;
    private static final double GENERAL_COUNTING_VALUE = 3.0;
    private static final double LOW_TEMPERATURE_VALUE = 70.0;
    private static final double HIGH_TEMPERATURE_VALUE = 10.0;
    private static final double PERCENTAGE_DECREASE_PER_SECOND = 0.06;
    private static final double TEMPERATURE_THRESHOLD = 90.0;
    private static final int TIME_EXCEPTION_THRESHOLD = 60;
    private static final int TEMPERATURE_EXCEPTION_THRESHOLD = 100;
    private static final double PERCENTAGE_EXCEPTION_THRESHOLD = 0.1;

    public Nhlium()
    {
    }

    @Override
    public SplitResult split(int time, int temperature)
    {
        if (time <= 0 || temperature < 0)
        {
            throw new IllegalArgumentException("values cannot be negative");
        }

        if (time > TIME_EXCEPTION_THRESHOLD && temperature > TEMPERATURE_EXCEPTION_THRESHOLD)
        {
            throw new MeltdownException("values bigger than expected");
        }

        if (this.getPercentageLeft() < PERCENTAGE_EXCEPTION_THRESHOLD)
        {
            throw new MeltdownException("insufficient percentage level left");
        }

        this.decreaseResidualPercentage(PERCENTAGE_DECREASE_PER_SECOND, time);

        double amountOfSteam;
        double residualHeat;

        if (temperature < TEMPERATURE_THRESHOLD)
        {
            amountOfSteam = (temperature / LOW_TEMPERATURE_VALUE) * time * STEAM_COUNTING_VALUE;
            residualHeat = time * GENERAL_COUNTING_VALUE;

        }
        else
        {
            amountOfSteam = STEAM_COUNTING_VALUE * ((temperature * STEAM_COUNTING_VALUE) / time) * Math.sqrt(GENERAL_COUNTING_VALUE) * time;
            residualHeat = temperature / HIGH_TEMPERATURE_VALUE;

        }

        return new SplitResult(amountOfSteam, residualHeat);
    }
}
