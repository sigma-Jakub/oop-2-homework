package com.nhlstenden.hospital.department;

import com.nhlstenden.hospital.equipment.Bed;

import java.util.ArrayList;
import java.util.List;

public class Department
{
    private String location;
    private List<Bed> beds;
    private double fteValue;

    public Department(String location)
    {
        this.location = location;
        this.beds = new ArrayList<>();
        this.fteValue = 0.0;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        if (location == null || location.isBlank())
        {
            throw new IllegalArgumentException("location cannot be null or blank");
        }

        this.location = location;
    }

    public List<Bed> getBeds()
    {
        return this.beds;
    }

    public void setBeds(List<Bed> beds)
    {
        if (beds == null)
        {
            throw new IllegalArgumentException("beds cannot be null");
        }

        for (Bed bedsItem : beds)
        {
            if (bedsItem == null)
            {
                throw new IllegalArgumentException("beds cannot be null");
            }
        }

        this.beds = new ArrayList<>(beds);
    }

    public double getFteValue()
    {
        return this.fteValue;
    }

    public void setFteValue(double fteValue)
    {
        if (fteValue < 0.0)
        {
            throw new IllegalArgumentException("fteValue cannot be negative");
        }

        this.fteValue = fteValue;
    }
}
