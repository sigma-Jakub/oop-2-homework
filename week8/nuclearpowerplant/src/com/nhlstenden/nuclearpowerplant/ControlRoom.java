package com.nhlstenden.nuclearpowerplant;

import java.util.ArrayList;
import java.util.List;

public class ControlRoom
{
    private List<Building> buildings;

    public ControlRoom()
    {
        this.buildings = new ArrayList<>();
    }

    public List<Building> getBuildings()
    {
        return this.buildings;
    }

    public void setBuildings(List<Building> buildings)
    {
        if (buildings == null)
        {
            throw new IllegalArgumentException("buildings cannot be null");
        }

        for (Building buildingsItem : buildings)
        {
            if (buildingsItem == null)
            {
                throw new IllegalArgumentException("buildings cannot be null");
            }
        }

        this.buildings = new ArrayList<>(buildings);
    }

    public Status getBuildingStatus(Building building)
    {
        return building.getStatus();
    }

    public boolean isNuclearReactorStable()
    {
        boolean result = true;

        for (Building building : this.buildings)
        {
            if (!building.getStatus().equals(Status.STABLE))
            {
                result = false;
            }
        }

        return result;
    }
}
