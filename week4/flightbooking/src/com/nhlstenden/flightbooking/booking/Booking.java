package com.nhlstenden.flightbooking.booking;

import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.luggage.Luggage;
import com.nhlstenden.flightbooking.person.Person;
import com.nhlstenden.flightbooking.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class Booking
{
    private Person person;
    private Flight flight;
    private Seat seat;
    private List<Luggage> luggage;

    public Booking(Person person, Flight flight, Seat seat, List<Luggage> luggage)
    {
        this.setPerson(person);
        this.setFlight(flight);
        this.setSeat(seat);
        this.setLuggage(luggage);
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        if (person == null)
        {
            throw new IllegalArgumentException("person cannot be null");
        }

        this.person = person;
    }

    public Flight getFlight()
    {
        return this.flight;
    }

    public void setFlight(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        this.flight = flight;
    }

    public Seat getSeat()
    {
        return this.seat;
    }

    public void setSeat(Seat seat)
    {
        if (seat == null)
        {
            throw new IllegalArgumentException("seat cannot be null");
        }

        this.seat = seat;
    }

    public List<Luggage> getLuggage()
    {
        return this.luggage;
    }

    public void setLuggage(List<Luggage> luggage)
    {
        if (luggage == null)
        {
            throw new IllegalArgumentException("luggage cannot be null");
        }

        for (Luggage luggageItem : luggage)
        {
            if (luggageItem == null)
            {
                throw new IllegalArgumentException("luggage cannot be null");
            }
        }

        this.luggage = new ArrayList<>(luggage);
    }

    public double getLuggageWeight()
    {
        double total = 0.0;

        for (Luggage luggageItem : this.luggage)
        {
            total += luggageItem.getWeight();
        }

        return total;
    }
}
