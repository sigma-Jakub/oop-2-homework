package com.nhlstenden.stock;

public class ConsumerProductCompanyShare extends Share
{
    private static final double CONSUMER_HYPE_INDEX_MULTIPLIER = 0.0067;
    private double consumerHypeIndex;

    public ConsumerProductCompanyShare(String companyName, double baseValueInEuros, RiskCategory riskCategory, double consumerHypeIndex)
    {
        super(companyName, baseValueInEuros, riskCategory);
        this.setConsumerHypeIndex(consumerHypeIndex);
    }

    public double getConsumerHypeIndex()
    {
        return this.consumerHypeIndex;
    }

    public void setConsumerHypeIndex(double consumerHypeIndex)
    {
        if (consumerHypeIndex < 0.0)
        {
            throw new IllegalArgumentException("consumerHypeIndex cannot be negative");
        }

        this.consumerHypeIndex = consumerHypeIndex;
    }

    @Override
    public double getValueInEuros()
    {
        return this.getBaseValueInEuros() * (CONSUMER_HYPE_INDEX_MULTIPLIER * this.consumerHypeIndex);
    }
}
