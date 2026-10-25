package com.nhlstenden.nuclearpowerplant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StendaaniumTest
{

    @Test
    void split_invalidParameters_throwsIllegalArgumentException()
    {
        Stendaanium stendaanium = new Stendaanium();

        assertThrows(IllegalArgumentException.class, () -> stendaanium.split(0, 0));
    }

    @Test
    void split_temperatureExactly151_throwsMeltdownException()
    {
        Stendaanium stendaanium = new Stendaanium();

        assertThrows(MeltdownException.class, () -> stendaanium.split(10, 151));
    }

    @Test
    void split_temperatureEquals50AndTimeEquals10_decreaseRodPercentage()
    {
        Stendaanium stendaanium = new Stendaanium();
        stendaanium.split(10, 50);

        assertEquals(99.9646, stendaanium.getPercentageLeft(), 0.0001);
    }

    @Test
    void split_temperatureEquals49_rodPercentageRemainsTheSame()
    {
        Stendaanium stendaanium = new Stendaanium();
        stendaanium.split(10, 49);

        assertEquals(100.0, stendaanium.getPercentageLeft());
    }

    @Test
    void split_temperatureEquals10AndTimeEquals10_amountOfSteamEquals500()
    {
        SplitResult result = new SplitResult(500.0, 400.0);

        Stendaanium stendaanium = new Stendaanium();
        SplitResult expected = stendaanium.split(10, 10);
        double expectedSteam = expected.getAmountOfSteam();

        assertEquals(expectedSteam, result.getAmountOfSteam(), 0.0001);
    }

    @Test
    void split_temperatureEquals10AndTimeEquals10_amountOfResidualHeatEquals400()
    {
        SplitResult result = new SplitResult(500.0, 400.0);

        Stendaanium stendaanium = new Stendaanium();
        SplitResult expected = stendaanium.split(10, 10);
        double expectedResidualHeat = expected.getResidualHeat();

        assertEquals(expectedResidualHeat, result.getResidualHeat(), 0.0001);
    }
}
