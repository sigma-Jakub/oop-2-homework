package com.nhlstenden.stock;

import java.util.ArrayList;
import java.util.List;

public class StockExchange
{
    private List<Share> availableShares;
    private List<Shareholder> shareholders;

    public StockExchange()
    {
        this.setAvailableShares(new ArrayList<>());
        this.setShareholders(new ArrayList<>());
    }

    public List<Share> getAvailableShares()
    {
        return this.availableShares;
    }

    public void setAvailableShares(List<Share> availableShares)
    {
        if (availableShares == null)
        {
            throw new IllegalArgumentException("availableShares cannot be null");
        }

        for (Share availableSharesItem : availableShares)
        {
            if (availableSharesItem == null)
            {
                throw new IllegalArgumentException("availableShares cannot be null");
            }
        }

        this.availableShares = new ArrayList<>(availableShares);
    }

    public List<Shareholder> getShareholders()
    {
        return this.shareholders;
    }

    public void setShareholders(List<Shareholder> shareholders)
    {
        if (shareholders == null)
        {
            throw new IllegalArgumentException("shareholders cannot be null");
        }

        for (Shareholder shareholdersItem : shareholders)
        {
            if (shareholdersItem == null)
            {
                throw new IllegalArgumentException("shareholders cannot be null");
            }
        }

        this.shareholders = new ArrayList<>(shareholders);
    }

    public void addAvailableShare(Share share)
    {
        if (share == null)
        {
            throw new IllegalArgumentException("share cannot be null");
        }

        this.availableShares.add(share);
    }

    public void removeAvailableShare(Share share)
    {
        this.availableShares.remove(share);
    }

    public void addShareholder(Shareholder shareholder)
    {
        if (shareholder == null)
        {
            throw new IllegalArgumentException("Shareholder cannot be null");
        }

        this.shareholders.add(shareholder);
    }

    public void removeShareholder(Shareholder shareholder)
    {
        this.shareholders.remove(shareholder);
    }

    private Shareholder getShareholderByName(String name)
    {
        for (Shareholder shareholder : this.shareholders)
        {
            if (shareholder.getName().equals(name))
            {
                return shareholder;
            }
        }

        throw new IllegalArgumentException("shareholder does not exist");
    }

    private Share getShareByCompanyName(String name)
    {
        for (Share share : this.availableShares)
        {
            if (share.getCompanyName().equals(name))
            {
                return share;
            }
        }

        throw new IllegalArgumentException("share does not exist");
    }

    public void buyShare(String shareholderName, String shareOfCompany)
    {
        Shareholder shareholder = this.getShareholderByName(shareholderName);
        Share share = this.getShareByCompanyName(shareOfCompany);

        if (share.getValueInEuros() > shareholder.getCashInEuros())
        {
            throw new NotEnoughMoneyException("insufficient funds");
        }

        this.availableShares.remove(share);
        shareholder.deductMoney(share.getValueInEuros());
        shareholder.addOwnedShare(share);
    }
}
