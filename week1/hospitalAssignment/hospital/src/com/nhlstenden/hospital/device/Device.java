package com.nhlstenden.hospital.device;

import com.nhlstenden.hospital.users.Patient;

public abstract class Device
{
    public static final String NORMAL_STATUS_VALUE = "normal";
    public static final String WARNING_STATUS_VALUE = "warning";
    public static final String CRITICAL_STATUS_VALUE = "critical";
    public static final String ERROR_MESSAGE_VALUE = "ERROR";
    private String serialNumber;
    private double energyConsumptionInkWh;

    public Device()
    {
    }

    public String getSerialNumber()
    {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        if (serialNumber == null || serialNumber.isBlank())
        {
            throw new IllegalArgumentException("serialNumber cannot be null or blank");
        }

        this.serialNumber = serialNumber;
    }

    public double getEnergyConsumptionInkWh()
    {
        return this.energyConsumptionInkWh;
    }

    public void setEnergyConsumptionInkWh(double energyConsumptionInkWh)
    {
        if (energyConsumptionInkWh < 0)
        {
            throw new IllegalArgumentException("energyConsumptionInkWh cannot be negative");
        }

        this.energyConsumptionInkWh = energyConsumptionInkWh;
    }

    public abstract String checkStatus(Patient patient);
}
