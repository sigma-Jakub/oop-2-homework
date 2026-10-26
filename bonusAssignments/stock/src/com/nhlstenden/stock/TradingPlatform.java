package com.nhlstenden.stock;

import java.util.HashMap;

public class TradingPlatform
{
    private HashMap<String, Double> tradeableEntities;

    public TradingPlatform()
    {
        this.tradeableEntities = new HashMap<>();
    }

    public HashMap<String, Double> getTradeableEntities()
    {
        return this.tradeableEntities;
    }

    public void setTradeableEntities(HashMap<String, Double> tradeableEntities)
    {
        if (tradeableEntities == null)
        {
            throw new IllegalArgumentException("tradeableEntities cannot be null");
        }

        this.tradeableEntities = tradeableEntities;
    }

    public void addTradeableEntity(TradeableInterface tradeable)
    {
        if (tradeable == null)
        {
            throw new IllegalArgumentException("tradeable cannot be null");
        }

        this.tradeableEntities.put(tradeable.getAbbreviation(), tradeable.getValue());
    }
}

