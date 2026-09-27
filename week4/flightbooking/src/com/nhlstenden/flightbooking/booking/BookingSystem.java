package com.nhlstenden.flightbooking.booking;

import com.nhlstenden.flightbooking.airplane.Airplane;
import com.nhlstenden.flightbooking.airport.Airport;
import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.flight.FlightStatus;
import com.nhlstenden.flightbooking.luggage.Luggage;
import com.nhlstenden.flightbooking.luggage.LuggageType;
import com.nhlstenden.flightbooking.person.Person;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem
{
    private List<Airport> airports;
    private List<Person> persons;
    private List<Flight> flights;

    public BookingSystem()
    {
        this.setAirports(new ArrayList<>());
        this.setPersons(new ArrayList<>());
        this.setFlights(new ArrayList<>());
    }

    public List<Airport> getAirports()
    {
        return this.airports;
    }

    public void setAirports(List<Airport> airports)
    {
        if (airports == null)
        {
            throw new IllegalArgumentException("airports cannot be null");
        }

        for (Airport airportsItem : airports)
        {
            if (airportsItem == null)
            {
                throw new IllegalArgumentException("airports cannot be null");
            }
        }

        this.airports = new ArrayList<>(airports);
    }

    public List<Person> getPersons()
    {
        return this.persons;
    }

    public void setPersons(List<Person> persons)
    {
        if (persons == null)
        {
            throw new IllegalArgumentException("persons cannot be null");
        }

        for (Person personsItem : persons)
        {
            if (personsItem == null)
            {
                throw new IllegalArgumentException("persons cannot be null");
            }
        }

        this.persons = new ArrayList<>(persons);
    }

    public List<Flight> getFlights()
    {
        return this.flights;
    }

    public void setFlights(List<Flight> flights)
    {
        if (flights == null)
        {
            throw new IllegalArgumentException("flights cannot be null");
        }

        for (Flight flightsItem : flights)
        {
            if (flightsItem == null)
            {
                throw new IllegalArgumentException("flights cannot be null");
            }
        }

        this.flights = new ArrayList<>(flights);
    }

    public void addAirport(Airport airport)
    {
        if (airport == null)
        {
            throw new IllegalArgumentException("airport cannot be null");
        }

        this.airports.add(airport);
    }

    public void addPerson(Person person)
    {
        if (person == null)
        {
            throw new IllegalArgumentException("person cannot be null");
        }

        this.persons.add(person);
    }

    public void addFlight(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("flight cannot be null");
        }

        this.flights.add(flight);
    }

    public void validateLuggage(List<Luggage> luggage, Airplane airplane)
    {
        if (luggage == null)
        {
            throw new IllegalArgumentException("luggage cannot be null");
        }

        for (Luggage luggageItem : luggage)
        {
            if (luggageItem == null)
            {
                throw new IllegalArgumentException("luggages cannot be null");
            }
        }

        if (airplane == null)
        {
            throw new IllegalArgumentException("airplane cannot be null");
        }

        int carryOnLuggageCount = 0;

        for (Luggage luggageItem : luggage)
        {
            if (luggageItem.getType() == LuggageType.CARRYON)
            {
                carryOnLuggageCount += 1;
            }
            else if (!airplane.canCarryHoldLuggage() && luggageItem.getType() == LuggageType.HOLD)
            {
                throw new IllegalArgumentException("hold luggage is not allowed on this airplane");
            }

            if (carryOnLuggageCount > 1)
            {
                throw new IllegalArgumentException("one carry-on luggage can be taken at most");
            }
        }
    }

    public Flight findAvailableFlight(Airport departure, Airport arrival)
    {
        if (departure == null)
        {
            throw new IllegalArgumentException("departure cannot be null");
        }

        if (arrival == null)
        {
            throw new IllegalArgumentException("arrival cannot be null");
        }

        for (Flight flight : this.flights)
        {
            boolean isMatchingRoute = flight.getDepartureAirport().equals(departure) &&
                    flight.getArrivalAirport().equals(arrival);
            boolean hasNotDeparted = flight.getStatus() != FlightStatus.DEPARTED &&
                    flight.getStatus() != FlightStatus.LANDED;
            boolean hasEmptySeat = flight.getAirplane().getEmptySeatCount() > 0;

            if (isMatchingRoute && hasNotDeparted && hasEmptySeat)
            {
                return flight;
            }
        }

        throw new IllegalStateException("no available flight found for this route");
    }

    public Booking bookTicket(Person person, Airport departure, Airport arrival, List<Luggage> luggage)
    {
        if (person == null)
        {
            throw new IllegalArgumentException("person cannot be null");
        }

        if (departure == null)
        {
            throw new IllegalArgumentException("departure cannot be null");
        }

        if (arrival == null)
        {
            throw new IllegalArgumentException("arrival cannot be null");
        }

        Flight availableFlight = this.findAvailableFlight(departure, arrival);

        this.validateLuggage(luggage, availableFlight.getAirplane());

        Booking booking = new Booking(person, availableFlight, availableFlight.getAirplane().reserveSeat(), luggage);

        availableFlight.addBooking(booking);

        if (!this.persons.contains(person))
        {
            this.persons.add(person);
        }

        return booking;
    }
}
