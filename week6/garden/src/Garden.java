import java.util.HashSet;

public class Garden
{
    private static final int VEGETABLES_LIMIT = 27;
    private HashSet<Vegetable> vegetables;

    public Garden()
    {
        this.vegetables = new HashSet<>();
    }

    public void addVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("vegetable cannot be null");
        }

        if (this.vegetables.size() >= VEGETABLES_LIMIT)
        {
            throw new TooManyVegetablesException("garden ran out of space");
        }

        this.vegetables.add(vegetable);
    }

    public void simulateWeather(int lux, int mm, int amountOfDays)
    {
        for (Vegetable vegetable : this.vegetables)
        {
            vegetable.grow(lux, mm, amountOfDays);
        }
    }

    public HashSet<Vegetable> getReadyForHarvest()
    {
        HashSet<Vegetable> readyToHarvestSet = new HashSet<>();

        for (Vegetable vegetable : this.vegetables)
        {
            if (vegetable.getStatus().equals(Status.READY_TO_HARVEST))
            {
                readyToHarvestSet.add(vegetable);
            }
        }

        return readyToHarvestSet;
    }
}
