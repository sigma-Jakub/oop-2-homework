package com.nhlstenden.flightbooking.seat;

public class Seat
{
    private boolean occupied;
    private SeatType type;

    public Seat(SeatType type)
    {
        this.setOccupied(false);
        this.setType(type);
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }

    public void setOccupied(boolean occupied)
    {
        this.occupied = occupied;
    }

    public SeatType getType()
    {
        return this.type;
    }

    public void setType(SeatType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        this.type = type;
    }

    public void occupy()
    {
        this.occupied = true;
    }
}
