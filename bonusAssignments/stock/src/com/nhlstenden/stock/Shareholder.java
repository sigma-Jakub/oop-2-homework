package com.nhlstenden.stock;

import java.util.ArrayList;
import java.util.List;

public class Shareholder
{
    private List<Share> ownedShares;
    private String name;
    private double cashInEuros;

    public Shareholder(String name, double cashInEuros)
    {
        this.setOwnedShares(new ArrayList<>());
        this.setName(name);
        this.setCashInEuros(cashInEuros);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public List<Share> getOwnedShares()
    {
        return this.ownedShares;
    }

    public void setOwnedShares(List<Share> ownedShares)
    {
        if (ownedShares == null)
        {
            throw new IllegalArgumentException("ownedShares cannot be null");
        }

        for (Share ownedSharesItem : ownedShares)
        {
            if (ownedSharesItem == null)
            {
                throw new IllegalArgumentException("ownedShares cannot be null");
            }
        }

        this.ownedShares = new ArrayList<>(ownedShares);
    }

    public double getCashInEuros()
    {
        return this.cashInEuros;
    }

    public void setCashInEuros(double cashInEuros)
    {
        if (cashInEuros < 0.0)
        {
            throw new IllegalArgumentException("cashInEuros cannot be negative");
        }

        this.cashInEuros = cashInEuros;
    }

    public void deductMoney(double cashInEuros)
    {
        if (cashInEuros < 0.0)
        {
            throw new IllegalArgumentException("cashInEuros cannot be negative");
        }

        this.cashInEuros -= cashInEuros;
    }

    public void addOwnedShare(Share share)
    {
        if (share == null)
        {
            throw new IllegalArgumentException("share cannot be null");
        }

        this.getOwnedShares().add(share);
    }

    public void removeOwnedShare(Share share)
    {
        this.getOwnedShares().remove(share);
    }

    public double getTotalValueInEuros()
    {
        double totalValueInEuros = 0.0;

        for (Share share : this.getOwnedShares())
        {
            totalValueInEuros += share.getValueInEuros();
        }

        return totalValueInEuros;
    }
}
