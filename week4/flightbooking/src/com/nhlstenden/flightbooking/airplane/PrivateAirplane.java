package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.seat.Seat;
import com.nhlstenden.flightbooking.seat.SeatType;

public class PrivateAirplane extends Airplane
{
    private static final double SEAT_NUMBER_MULT = 1.31;
    private static final double SEATS_TAKEN_MULT = 1.87;
    private static final double LUGGAGE_MULT = 0.4;

    public PrivateAirplane(String code, double currentFuelLevel, int numberOfSeats)
    {
        super(code, currentFuelLevel);

        if (numberOfSeats < 1)
        {
            throw new IllegalArgumentException("numberOfSeats cannot be lower than 1");
        }

        for (int i = 0; i < numberOfSeats; i++)
        {
            Seat seat = new Seat(SeatType.ECONOMY);
            this.addSeat(seat);
        }
    }

    @Override
    public boolean canCarryHoldLuggage()
    {
        return false;
    }

    @Override
    public double getFuelConsumption(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        return this.getSeats().size() * SEAT_NUMBER_MULT * flight.getFlightDistance() +
                (this.getTakenSeatCount() * SEATS_TAKEN_MULT) +
                (flight.getTotalLuggageWeight() * LUGGAGE_MULT);
    }
}
