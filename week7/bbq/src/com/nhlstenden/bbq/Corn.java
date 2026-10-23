package com.nhlstenden.bbq;

public class Corn extends Vegetable
{
    private static final double BROWNING_FACTOR = 0.08;
    private static final double MOIST_FACTOR = 0.05;

    public Corn()
    {
        super(BROWNING_FACTOR, MOIST_FACTOR);
    }
}
