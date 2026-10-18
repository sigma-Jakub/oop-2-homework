import java.util.HashSet;

public class Garden
{
    private HashSet<Vegetable> vegetables;

    public Garden()
    {

    }

    public HashSet<Vegetable> getReadyForHarvest()
    {
        return null;
    }

    public void setupWeather(int lux, int mm, int amountOfDays)
    {
        for (Vegetable vegetable : this.vegetables)
        {
            vegetable.grow(lux, mm, amountOfDays);
        }
    }
}
