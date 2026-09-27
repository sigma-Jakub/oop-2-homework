package com.nhlstenden.flightbooking.flight;

import com.nhlstenden.flightbooking.airplane.Airplane;
import com.nhlstenden.flightbooking.airport.Airport;
import com.nhlstenden.flightbooking.booking.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDate;
    private FlightStatus status;
    private List<Booking> bookings;

    public Flight(Airplane airplane, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate)
    {
        this.setAirplane(airplane);
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
        this.setDepartureDate(departureDate);
        this.setStatus(FlightStatus.AWAITING_DEPARTURE);
        this.setBookings(new ArrayList<>());
    }

    public Airplane getAirplane()
    {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("airplane cannot be null");
        }

        this.airplane = airplane;
    }

    public Airport getDepartureAirport()
    {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport)
    {
        if (departureAirport == null) //is contained in BookingSystem?
        {
            throw new IllegalArgumentException("departureAirport cannot be null");
        }

        if (this.arrivalAirport != null && departureAirport.getName().equals(this.arrivalAirport.getName()))
        {
            throw new IllegalArgumentException("departureAirport cannot be the same as arrivalAirport");
        }

        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport()
    {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport)
    {
        if (arrivalAirport == null) //is contained in BookingSystem?
        {
            throw new IllegalArgumentException("arrivalAirport cannot be null");
        }

        if (this.departureAirport != null && arrivalAirport.getName().equals(this.departureAirport.getName()))
        {
            throw new IllegalArgumentException("arrivalAirport cannot be the same as departureAirport");
        }

        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDate()
    {
        return this.departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate)
    {
        if (departureDate == null)
        {
            throw new IllegalArgumentException("departure date cannot be null");
        }

        if (departureDate.isBefore(LocalDateTime.now()))
        {
            throw new IllegalArgumentException("departure date cannot be in the past");
        }

        this.departureDate = departureDate;
    }

    public FlightStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(FlightStatus status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("status cannot be null");
        }

        this.status = status;
    }

    public List<Booking> getBookings()
    {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings)
    {
        if (bookings == null)
        {
            throw new IllegalArgumentException("bookings cannot be null");
        }

        for (Booking bookingsItem : bookings)
        {
            if (bookingsItem == null)
            {
                throw new IllegalArgumentException("bookings cannot be null");
            }
        }

        this.bookings = new ArrayList<>(bookings);
    }

    public int getFlightDistance()
    {
        return this.departureAirport.getDistance(this.arrivalAirport);
    }

    public void depart()
    {
        if (this.status == FlightStatus.DEPARTED || this.status == FlightStatus.LANDED)
        {
            throw new IllegalStateException("flight has already departed");
        }

        if (!this.airplane.hasSufficientFuel(this))
        {
            throw new IllegalStateException("airplane does not have sufficient fuel to depart");
        }

        this.setStatus(FlightStatus.DEPARTED);
    }

    public void addBooking(Booking booking)
    {
        if (booking == null)
        {
            throw new IllegalArgumentException("booking cannot be null");
        }

        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking)
    {
        if (booking == null)
        {
            throw new IllegalArgumentException("booking cannot be null");
        }

        this.bookings.remove(booking);
    }

    public double getTotalLuggageWeight()
    {
        double total = 0.0;

        for (Booking booking : this.bookings)
        {
            total += booking.getLuggageWeight();
        }

        return total;
    }
}
