import java.util.HashSet;

public class Market
{
    private HashSet<Marketable> marketableVegetables;

    public Market()
    {
        this.marketableVegetables = new HashSet<>();
    }

    public void addMarketableVegetable(Marketable vegetable)
    {
        if (vegetable.isMarketable())
        {
            this.marketableVegetables.add(vegetable);
        }
    }

    public double getProfits()
    {
        double totalProfit = 0.0;

        for (Marketable vegetable : this.marketableVegetables)
        {
            totalProfit += vegetable.getPrice();
        }

        return totalProfit;
    }
}
