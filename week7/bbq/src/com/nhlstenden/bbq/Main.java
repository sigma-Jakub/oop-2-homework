package com.nhlstenden.bbq;

public class Main
{
    static void main(String[] args)
    {
        SmartBBQ bbq = new SmartBBQ();
        Meat measuredMeat = new Hamburger();

        Fridge fridge = Fridge.getInstance();
        fridge.addFood(new Corn());
        fridge.addFood(new Corn());
        fridge.addFood(new Corn());
        fridge.addFood(new BellPepper());
        fridge.addFood(new BellPepper());
        fridge.addFood(measuredMeat);
        fridge.addFood(new Hamburger());
        fridge.addFood(new Sausage());
        fridge.addFood(new Sausage());
        fridge.addFood(new Sausage());

        bbq.addFood(fridge.getNextMeat());
        bbq.addFood(fridge.getNextMeat());
        bbq.addFood(fridge.getNextMeat());

        bbq.turnOn(180);
        System.out.print(Thermometer.readThermometer(measuredMeat));

        bbq.setTemperature(200);
        System.out.print(Thermometer.readThermometer(measuredMeat));
    }
}