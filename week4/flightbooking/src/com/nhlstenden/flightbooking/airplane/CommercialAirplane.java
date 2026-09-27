package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.seat.Seat;
import com.nhlstenden.flightbooking.seat.SeatType;

public class CommercialAirplane extends Airplane
{
    private static final double ECONOMY_SEAT_NUMBER_MULT = 1.75;
    private static final double ECONOMY_SEATS_TAKEN_MULT = 2.02;
    private static final double BUSINESS_SEAT_NUMBER_MULT = 1.98;
    private static final double BUSINESS_SEATS_TAKEN_MULT = 2.87;
    private static final double LUGGAGE_MULT = 0.3;

    public CommercialAirplane(String code, double currentFuelLevel, int economySeats, int businessSeats)
    {
        super(code, currentFuelLevel);

        if (economySeats < 0 || businessSeats < 0 || economySeats + businessSeats <= 0)
        {
            throw new IllegalArgumentException("number of seats cannot be total of zero or negative");
        }

        for (int i = 0; i < economySeats; i++)
        {
            Seat seat = new Seat(SeatType.ECONOMY);
            this.addSeat(seat);
        }

        for (int i = 0; i < businessSeats; i++)
        {
            Seat seat = new Seat(SeatType.BUSINESS);
            this.addSeat(seat);
        }
    }

    public int getSeatCount(SeatType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        int total = 0;

        for (Seat seat : this.getSeats())
        {
            if (seat.getType() == type)
            {
                total += 1;
            }
        }

        return total;
    }

    public int getEmptySeatCount(SeatType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        int total = 0;

        for (Seat seat : this.getSeats())
        {
            if (seat.getType() == type && !seat.isOccupied())
            {
                total += 1;
            }
        }

        return total;
    }

    public int getTakenSeatCount(SeatType type)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("type cannot be null");
        }

        int total = 0;

        for (Seat seat : this.getSeats())
        {
            if (seat.getType() == type && seat.isOccupied())
            {
                total += 1;
            }
        }

        return total;
    }

    @Override
    public boolean canCarryHoldLuggage()
    {
        return true;
    }

    @Override
    public double getFuelConsumption(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        double seatUsage = (this.getSeatCount(SeatType.ECONOMY) * ECONOMY_SEAT_NUMBER_MULT) +
                (this.getSeatCount(SeatType.BUSINESS) * BUSINESS_SEAT_NUMBER_MULT);

        return seatUsage * flight.getFlightDistance() +
                (this.getTakenSeatCount(SeatType.ECONOMY) * ECONOMY_SEATS_TAKEN_MULT) +
                (this.getTakenSeatCount(SeatType.BUSINESS) * BUSINESS_SEATS_TAKEN_MULT) +
                (flight.getTotalLuggageWeight() * LUGGAGE_MULT);
    }
}
