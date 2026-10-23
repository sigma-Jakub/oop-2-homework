package com.nhlstenden.bbq;

public class BellPepper extends Vegetable
{
    private static final double BROWNING_FACTOR = 0.03;
    private static final double MOIST_FACTOR = 0.1;

    public BellPepper()
    {
        super(BROWNING_FACTOR, MOIST_FACTOR);
    }
}
