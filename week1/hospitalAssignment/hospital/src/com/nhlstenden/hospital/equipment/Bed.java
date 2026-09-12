package com.nhlstenden.hospital.equipment;

import com.nhlstenden.hospital.device.Device;
import com.nhlstenden.hospital.users.Patient;

import java.util.ArrayList;
import java.util.List;

public class Bed
{
    private Patient patient;
    private List<Device> devices;

    public Bed()
    {
        this.devices = new ArrayList<>();
    }

    public Patient getPatient()
    {
        return this.patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    public List<Device> getDevices()
    {
        return this.devices;
    }

    public void setDevices(List<Device> devices)
    {
        if (devices == null || this.isAvailable())
        {
            throw new IllegalArgumentException("devices cannot be null or bed is free");
        }

        for (Device devicesItem : devices)
        {
            if (devicesItem == null)
            {
                throw new IllegalArgumentException("devices cannot be null");
            }
        }

        this.devices = new ArrayList<>(devices);
    }

    public boolean isAvailable()
    {
        return (this.patient == null);
    }

    public void addDevice(Device device)
    {
        if (device == null)
        {
            throw new IllegalArgumentException("device cannot be null");
        }

        this.devices.add(device);
    }

    public void removeDevice(Device device)
    {
        this.devices.remove(device);
    }

    public void removeAllDevices()
    {
        this.devices = new ArrayList<>();
    }
}
