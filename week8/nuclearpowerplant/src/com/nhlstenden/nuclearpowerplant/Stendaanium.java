package com.nhlstenden.nuclearpowerplant;

public class Stendaanium extends SplittingRod
{
    private static final double PERCENTAGE_DECREASE_MULTIPLIER = 0.00007;
    private static final double PERCENTAGE_DECREASE_VALUE = 0.0004;
    private static final double TEMPERATURE_THRESHOLD = 50.0;
    private static final double STEAM_COUNTING_VALUE = 50.0;
    private static final double RESIDUAL_HEAT_DIVIDER = 0.5;
    private static final double RESIDUAL_HEAT_VALUE = 20.0;
    private static final int TEMPERATURE_EXCEPTION_THRESHOLD = 150;

    public Stendaanium()
    {
    }

    @Override
    public SplitResult split(int time, int temperature)
    {
        if (time <= 0 || temperature < 0)
        {
            throw new IllegalArgumentException("values cannot be negative");
        }

        if (temperature > TEMPERATURE_EXCEPTION_THRESHOLD)
        {
            throw new MeltdownException("temperature is too high");
        }

        double amountOfSteam = STEAM_COUNTING_VALUE * temperature;
        double residualHeat = (time / RESIDUAL_HEAT_DIVIDER) * RESIDUAL_HEAT_VALUE;

        if (temperature >= TEMPERATURE_THRESHOLD)
        {
            double decrease = PERCENTAGE_DECREASE_MULTIPLIER * temperature * time + PERCENTAGE_DECREASE_VALUE;
            this.decreaseResidualPercentage(decrease, 1);
        }

        return new SplitResult(amountOfSteam, residualHeat);
    }
}
