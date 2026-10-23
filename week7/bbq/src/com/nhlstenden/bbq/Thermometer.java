package com.nhlstenden.bbq;

public class Thermometer
{
    private static final int COLD_FACTOR = 10;
    private static final int MEDIUM_FACTOR = 70;

    public static String readThermometer(HasTemperature temperature)
    {
        double readTemperature = temperature.readTemperature();

        TemperatureType type = TemperatureType.COLD;

        if (readTemperature >= COLD_FACTOR && readTemperature <= MEDIUM_FACTOR)
        {
            type = TemperatureType.MEDIUM;
        }

        if (readTemperature > MEDIUM_FACTOR)
        {
            type = TemperatureType.HOT;
        }

        return ("I measured a temperature of " + readTemperature + " degrees Celsius " + type);
    }
}
