package com.nhlstenden.bbq;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FridgeTest
{
    @Test
    void getNextMeat_noItemsInFridge_throwsFridgeIsEmptyException()
    {
        Fridge fridge = Fridge.getInstance();

        assertThrows(FridgeIsEmptyException.class, () -> fridge.getNextMeat());
        fridge.setFoodInFridge(new HashSet<>());
    }

    @Test
    void getNextMeat_onlyVegetablesInFridge_throwsNoMoreFoodException()
    {
        Fridge fridge = Fridge.getInstance();
        fridge.addFood(new Corn());

        assertThrows(NoMoreFoodException.class, () -> fridge.getNextMeat());
        fridge.setFoodInFridge(new HashSet<>());
    }

    @Test
    void getNextMeat_takesMeatFromTheFridge_returnMeat()
    {
        Fridge fridge = Fridge.getInstance();
        Meat hamburger = new Hamburger();
        fridge.addFood(hamburger);

        assertEquals(hamburger, fridge.getNextMeat());
        fridge.setFoodInFridge(new HashSet<>());
    }

    @Test
    void getNextMeat_meatRemovedFromTheFridge_throwsFridgeIsEmptyException()
    {
        Fridge fridge = Fridge.getInstance();
        Meat hamburger = new Hamburger();
        fridge.addFood(hamburger);

        fridge.getNextMeat();

        assertThrows(FridgeIsEmptyException.class, () -> fridge.getNextMeat());
        fridge.setFoodInFridge(new HashSet<>());
    }
}