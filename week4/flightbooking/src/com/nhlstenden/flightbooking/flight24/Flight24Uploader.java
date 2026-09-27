package com.nhlstenden.flightbooking.flight24;

import com.nhlstenden.flightbooking.booking.BookingSystem;
import com.nhlstenden.flightbooking.flight.Flight;

import java.io.FileWriter;
import java.io.IOException;

public class Flight24Uploader
{
    private BookingSystem bookingSystem;

    public Flight24Uploader(BookingSystem system)
    {
        this.setBookingSystem(system);
    }

    public BookingSystem getBookingSystem()
    {
        return this.bookingSystem;
    }

    public void setBookingSystem(BookingSystem bookingSystem)
    {
        if (bookingSystem == null)
        {
            throw new IllegalArgumentException("bookingSystem cannot be null");
        }

        this.bookingSystem = bookingSystem;
    }

    public void uploadFile(String filePath)
    {
        if (filePath == null || filePath.isBlank())
        {
            throw new IllegalArgumentException("File path cannot be empty.");
        }

        Flight24 flight24 = new Flight24();

        try (FileWriter writer = new FileWriter(filePath))
        {
            for (Flight flight : this.getBookingSystem().getFlights())
            {
                writer.write(flight24.getFlightInfo(flight) + System.lineSeparator());
                writer.write(flight24.getAirplaneInfo(flight.getAirplane()) + System.lineSeparator());
            }
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Could not write to file: " + filePath, e);
        }
    }
}
