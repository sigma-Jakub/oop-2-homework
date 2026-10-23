package com.nhlstenden.bbq;

public class Sausage extends Meat
{
    private static final double COOKING_FACTOR = 80.0;
    private static final double BROWNING_FACTOR = 0.05;

    public Sausage()
    {
        super(MeatType.PIG, COOKING_FACTOR, BROWNING_FACTOR);
    }
}
