package com.nhlstenden.bbq;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest
{

    @Test
    void decreaseMoistPercentage_decreaseFromDefaultBy20_return80()
    {
        Corn corn = new Corn();
        corn.decreaseMoistPercentage(20.0);

        assertEquals(80.0, corn.getMoistPercentage());
    }

    @Test
    void decreaseMoistPercentage_decreaseToNegativeValue_return0()
    {
        Corn corn = new Corn();
        corn.decreaseMoistPercentage(100.1);

        assertEquals(0.0, corn.getMoistPercentage());
    }

    @Test
    void decreaseMoistPercentage_decreaseBy0_returnDefaultValue()
    {
        Corn corn = new Corn();
        corn.decreaseMoistPercentage(0.0);

        assertEquals(100.0, corn.getMoistPercentage());
    }

    @Test
    void decreaseMoistPercentage_decreaseByNegative_throwsIllegalArgumentException()
    {
        Corn corn = new Corn();

        assertThrows(IllegalArgumentException.class, () -> corn.decreaseMoistPercentage(-0.1));
    }
}