package com.nhlstenden.flightbooking.flight24;

import com.nhlstenden.flightbooking.airplane.Airplane;
import com.nhlstenden.flightbooking.flight.Flight;

import java.time.format.DateTimeFormatter;

public class Flight24
{
    private static final DateTimeFormatter DEPARTURE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public String getFlightInfo(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        String departure = flight.getDepartureAirport().getName();
        String arrival = flight.getArrivalAirport().getName();
        String departureDate = flight.getDepartureDate().format(DEPARTURE_FORMAT);

        return "F: " + departure + " -> " + arrival + ". Departure " + departureDate + ".";
    }

    public String getAirplaneInfo(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("airplane cannot be null");
        }

        String code = airplane.getCode();
        long fuel = Math.round(airplane.getCurrentFuelLevel());
        int emptySeats = airplane.getEmptySeatCount();

        return "P: " + code + ". " + fuel + " liter fuel. " + emptySeats + " empty seats.";
    }
}
