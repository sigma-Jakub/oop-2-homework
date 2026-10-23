package com.nhlstenden.bbq;

public class Hamburger extends Meat
{
    private static final double COOKING_FACTOR = 100.0;
    private static final double BROWNING_FACTOR = 0.06;

    public Hamburger()
    {
        super(MeatType.COW, COOKING_FACTOR, BROWNING_FACTOR);
    }
}
