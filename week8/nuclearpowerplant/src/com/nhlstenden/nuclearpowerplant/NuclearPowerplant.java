package com.nhlstenden.nuclearpowerplant;

public class NuclearPowerplant
{
    private Reactor reactor;
    private Generator generator;
    private CoolingSystem coolingSystem;
    private ControlRoom controlRoom;

    public NuclearPowerplant()
    {
        this.reactor = new Reactor();
        this.generator = new Generator();
        this.coolingSystem = new CoolingSystem();
        this.controlRoom = new ControlRoom();
    }

    public CoolingSystem getCoolingSystem()
    {
        return this.coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem)
    {
        if (coolingSystem == null)
        {
            throw new IllegalArgumentException("coolingSystem cannot be null");
        }

        this.coolingSystem = coolingSystem;
    }

    public Generator getGenerator()
    {
        return this.generator;
    }

    public void setGenerator(Generator generator)
    {
        if (generator == null)
        {
            throw new IllegalArgumentException("generator cannot be null");
        }

        this.generator = generator;
    }

    public Reactor getReactor()
    {
        return this.reactor;
    }

    public void setReactor(Reactor reactor)
    {
        if (reactor == null)
        {
            throw new IllegalArgumentException("reactor cannot be null");
        }

        this.reactor = reactor;
    }

    public ControlRoom getControlRoom()
    {
        return this.controlRoom;
    }

    public void setControlRoom(ControlRoom controlRoom)
    {
        if (controlRoom == null)
        {
            throw new IllegalArgumentException("controlRoom cannot be null");
        }

        this.controlRoom = controlRoom;
    }

    public double run(int time, int temperature)
    {
        if (time < 0 || temperature < 0)
        {
            throw new IllegalArgumentException("values cannot be negative");
        }

        SplitResult splitResult = this.reactor.run(time, temperature);

        this.coolingSystem.abductResidualHeat(splitResult.getResidualHeat());

        return this.generator.generateEnergy(splitResult.getAmountOfSteam());
    }
}
