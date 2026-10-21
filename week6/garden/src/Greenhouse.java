import java.util.Random;

public class Greenhouse extends Garden
{
    private static final int LUX_MIN = 1000;
    private static final int LUX_MAX = 101592;
    private static final int MM_MIN = 0;
    private static final int MM_MAX = 48;
    private static final int RUN_WEATHER_DAYS = 1;

    public Greenhouse()
    {

    }

    private static int generateRandomLux()
    {
        Random random = new Random();

        return random.nextInt(LUX_MIN, LUX_MAX + 1);
    }

    private static int generateRandomMm()
    {
        Random random = new Random();

        return random.nextInt(MM_MIN, MM_MAX + 1);
    }

    public void runWeather()
    {
        int lux = generateRandomLux();
        int mm = generateRandomMm();

        simulateWeather(lux, mm, RUN_WEATHER_DAYS);
    }
}
