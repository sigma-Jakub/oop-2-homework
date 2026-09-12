package com.nhlstenden.hospital.users;

import java.time.LocalDate;

public class Patient
{
    private String name;
    private LocalDate dateOfBirth;
    private String sex;
    private int heartRate;
    private int systolicPressure;
    private int diastolicPressure;
    private boolean isAbleToWalk;

    public Patient(String name, LocalDate dateOfBirth, String sex, int heartRate, int systolicPressure, int diastolicPressure, boolean isAbleToWalk)
    {
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setSex(sex);
        this.setHeartRate(heartRate);
        this.setSystolicPressure(systolicPressure);
        this.setDiastolicPressure(diastolicPressure);
        this.setAbleToWalk(isAbleToWalk);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null || dateOfBirth.isEqual(LocalDate.now()) || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null set to today's date or be in the future");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {

        if (sex == null || sex.isBlank() || (!sex.equals("F") && !sex.equals("M")))
        {
            throw new IllegalArgumentException("sex cannot be null, blank or be different than male or female");
        }

        this.sex = sex.toUpperCase();
    }

    public int getHeartRate()
    {
        return this.heartRate;
    }

    public void setHeartRate(int heartRate)
    {
        if (heartRate <= 0)
        {
            throw new IllegalArgumentException("heartRate cannot be zero or negative");
        }

        this.heartRate = heartRate;
    }

    public int getSystolicPressure()
    {
        return this.systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure)
    {
        if (systolicPressure <= 0)
        {
            throw new IllegalArgumentException("systolicPressure cannot be zero or negative");
        }

        this.systolicPressure = systolicPressure;
    }

    public int getDiastolicPressure()
    {
        return this.diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure)
    {
        if (diastolicPressure <= 0)
        {
            throw new IllegalArgumentException("diastolicPressure cannot be zero or negative");
        }

        this.diastolicPressure = diastolicPressure;
    }

    public boolean isAbleToWalk()
    {
        return this.isAbleToWalk;
    }

    public void setAbleToWalk(boolean ableToWalk)
    {
        isAbleToWalk = ableToWalk;
    }
}
