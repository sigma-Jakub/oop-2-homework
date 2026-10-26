package com.nhlstenden.stock;

public class BigTechCompanyShare extends Share
{
    private static final double DATA_CENTRES_MULTIPLIER = 67.0;
    private static final double ONGOING_LAWSUITS_MULTIPLIER = 0.67;
    private static final int ONGOING_LAWSUITS_LIMIT = 67;
    private static final double ONGOING_LAWSUIT_OVER_LIMIT_MULTIPLIER = (6.0 / 7.0);
    private int numberOfDataCentres;
    private int numberOfLawsuits;

    public BigTechCompanyShare(String companyName, double baseValueInEuros, RiskCategory riskCategory, int numberOfDataCentres, int numberOfLawsuits)
    {
        super(companyName, baseValueInEuros, riskCategory);
        this.setNumberOfDataCentres(numberOfDataCentres);
        this.setNumberOfLawsuits(numberOfLawsuits);
    }

    public int getNumberOfDataCentres()
    {
        return this.numberOfDataCentres;
    }

    public void setNumberOfDataCentres(int numberOfDataCentres)
    {
        if (numberOfDataCentres < 0)
        {
            throw new IllegalArgumentException("numberOfDataCentres cannot be negative");
        }

        this.numberOfDataCentres = numberOfDataCentres;
    }

    public int getNumberOfLawsuits()
    {
        return this.numberOfLawsuits;
    }

    public void setNumberOfLawsuits(int numberOfLawsuits)
    {
        if (numberOfLawsuits < 0)
        {
            throw new IllegalArgumentException("numberOfLawsuits cannot be negative");
        }

        this.numberOfLawsuits = numberOfLawsuits;
    }

    @Override
    public double getValueInEuros()
    {
        double valueInEuros = this.getBaseValueInEuros() + (this.numberOfDataCentres * DATA_CENTRES_MULTIPLIER) - (this.numberOfLawsuits * ONGOING_LAWSUITS_MULTIPLIER);

        if (this.numberOfLawsuits > ONGOING_LAWSUITS_LIMIT)
        {
            return valueInEuros * ONGOING_LAWSUIT_OVER_LIMIT_MULTIPLIER;
        }

        return valueInEuros;
    }
}
