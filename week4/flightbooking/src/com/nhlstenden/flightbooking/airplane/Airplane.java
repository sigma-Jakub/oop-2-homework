package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public abstract class Airplane
{
    private String code;
    private double currentFuelLevel;
    private List<Seat> seats;

    public Airplane(String code, double currentFuelLevel)
    {
        this.setCode(code);
        this.setCurrentFuelLevel(currentFuelLevel);
        this.setSeats(new ArrayList<>());
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        if (code == null || code.isBlank())
        {
            throw new IllegalArgumentException("code cannot be null or blank");
        }

        this.code = code;
    }

    public double getCurrentFuelLevel()
    {
        return this.currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel)
    {
        if (currentFuelLevel < 0.0)
        {
            throw new IllegalArgumentException("currentFuelLevel cannot be negative");
        }

        this.currentFuelLevel = currentFuelLevel;
    }

    public List<Seat> getSeats()
    {
        return this.seats;
    }

    public void setSeats(List<Seat> seats)
    {
        if (seats == null)
        {
            throw new IllegalArgumentException("seats cannot be null");
        }

        for (Seat seatsItem : seats)
        {
            if (seatsItem == null)
            {
                throw new IllegalArgumentException("seats cannot be null");
            }
        }

        this.seats = new ArrayList<>(seats);
    }

    public int getEmptySeatCount()
    {
        List<Seat> emptySeats = new ArrayList<>();

        for (Seat seat : this.seats)
        {
            if (!seat.isOccupied())
            {
                emptySeats.add(seat);
            }
        }

        return emptySeats.size();
    }

    public int getTakenSeatCount()
    {
        int total = 0;

        for (Seat seat : this.seats)
        {
            if (seat.isOccupied())
            {
                total += 1;
            }
        }

        return total;
    }

    public void addSeat(Seat seat)
    {
        if (seat == null)
        {
            throw new IllegalArgumentException("seat cannot be null");
        }

        this.seats.add(seat);
    }

    public void removeSeat(Seat seat)
    {
        if (seat == null)
        {
            throw new IllegalArgumentException("seat cannot be null");
        }

        this.seats.remove(seat);
    }

    public Seat reserveSeat()
    {
        for (Seat seat : this.seats)
        {
            if (!seat.isOccupied())
            {
                seat.occupy();
                return seat;
            }
        }

        throw new IllegalStateException("no seats available");
    }

    public boolean hasSufficientFuel(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        return this.getCurrentFuelLevel() >= this.getFuelConsumption(flight);
    }

    public abstract boolean canCarryHoldLuggage();

    public abstract double getFuelConsumption(Flight flight);
}
