package com.nhlstenden.stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigTechCompanyShareTest
{
    private static final double DELTA = 0.0001;

    @Test
    void getValueInEuros_setOngoingLawsuitsToExactly67_returnValueWithoutMultiplier()
    {
        BigTechCompanyShare share = new BigTechCompanyShare("company", 10.0, RiskCategory.LOW, 1, 67);

        assertEquals(32.11, share.getValueInEuros(), DELTA);
    }

    @Test
    void getValueInEuros_setOngoingLawsuitsToExactly68_returnValueWithMultiplier()
    {
        BigTechCompanyShare share = new BigTechCompanyShare("company", 10.0, RiskCategory.LOW, 1, 68);

        assertEquals(26.9485, share.getValueInEuros(), DELTA);
    }

    @Test
    void getValueInEuros_setOngoingLawsuitsAndNumberOfDataCentresToExactly0_returnBaseValue()
    {
        BigTechCompanyShare share = new BigTechCompanyShare("company", 1.0, RiskCategory.LOW, 0, 0);

        assertEquals(1.0, share.getValueInEuros(), DELTA);
    }

    @Test
}