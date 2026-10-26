package com.nhlstenden.stock;

public abstract class Share implements TradeableInterface
{
    private String companyName;
    private double baseValueInEuros;
    private RiskCategory riskCategory;

    public Share(String companyName, double baseValueInEuros, RiskCategory riskCategory)
    {
        this.setCompanyName(companyName);
        this.setBaseValueInEuros(baseValueInEuros);
        this.setRiskCategory(riskCategory);
    }

    public double getBaseValueInEuros()
    {
        return this.baseValueInEuros;
    }

    public void setBaseValueInEuros(double baseValueInEuros)
    {
        if (baseValueInEuros <= 0)
        {
            throw new IllegalArgumentException("baseValueInEuros cannot be zero or negative");
        }

        this.baseValueInEuros = baseValueInEuros;
    }

    public String getCompanyName()
    {
        return this.companyName;
    }

    public void setCompanyName(String companyName)
    {
        if (companyName == null || companyName.isBlank())
        {
            throw new IllegalArgumentException("companyName cannot be null or blank");
        }

        this.companyName = companyName;
    }

    public RiskCategory getRiskCategory()
    {
        return this.riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory)
    {
        if (riskCategory == null)
        {
            throw new IllegalArgumentException("riskCategory cannot be null");
        }

        this.riskCategory = riskCategory;
    }

    public abstract double getValueInEuros();

    @Override
    public double getValue()
    {
        return this.getValueInEuros();
    }

    @Override
    public String getAbbreviation()
    {
        return this.getCompanyName().substring(0, 3).toUpperCase();
    }
}
