package com.nhlstenden.flightbooking.airport;

public class Airport
{
    private static final int DISTANCE_JFK_AMS = 5848;
    private static final int DISTANCE_JFK_MEX = 3366;
    private static final int DISTANCE_JFK_LAX = 3975;
    private static final int DISTANCE_AMS_MEX = 9206;
    private static final int DISTANCE_AMS_LAX = 8956;
    private static final int DISTANCE_MEX_LAX = 2500;
    private String name;

    public Airport(String name)
    {
        this.setName(name);
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

    public int getDistance(Airport airport)
    {
        if (airport == null)
        {
            throw new IllegalArgumentException("Airport cannot be null.");
        }

        if (this.isRoute(airport, "JFK", "AMS"))
        {
            return DISTANCE_JFK_AMS;
        }
        if (this.isRoute(airport, "JFK", "MEX"))
        {
            return DISTANCE_JFK_MEX;
        }
        if (this.isRoute(airport, "JFK", "LAX"))
        {
            return DISTANCE_JFK_LAX;
        }
        if (this.isRoute(airport, "AMS", "MEX"))
        {
            return DISTANCE_AMS_MEX;
        }
        if (this.isRoute(airport, "AMS", "LAX"))
        {
            return DISTANCE_AMS_LAX;
        }
        if (this.isRoute(airport, "MEX", "LAX"))
        {
            return DISTANCE_MEX_LAX;
        }

        throw new IllegalArgumentException("Route does not exist");
    }

    public boolean isRoute(Airport airport, String nameOne, String nameTwo)
    {
        boolean forward = this.name.equals(nameOne) && airport.getName().equals(nameTwo);
        boolean backward = this.name.equals(nameTwo) && airport.getName().equals(nameOne);

        return forward || backward;
    }
}
