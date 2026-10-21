public abstract class Vegetable
{
    private double sizeInCm;
    private double cmPerLux;
    private double cmPerMilimeter;
    private int ripeLength;
    private Color color;
    private Status status;

    public Vegetable(double cmPerLux, double cmPerMilimeter, int ripeLength, Color color)
    {
        this.setCmPerLux(cmPerLux);
        this.setCmPerMilimeter(cmPerMilimeter);
        this.setRipeLength(ripeLength);
        this.setColor(color);
        this.setSizeInCm(0.0);
        this.setStatus(Status.GROWING);
    }

    public double getSizeInCm()
    {
        return this.sizeInCm;
    }

    public void setSizeInCm(double sizeInCm)
    {
        if (sizeInCm < 0.0)
        {
            throw new IllegalArgumentException("sizeInCm cannot be negative");
        }

        this.sizeInCm = sizeInCm;
    }

    public double getCmPerLux()
    {
        return this.cmPerLux;
    }

    public void setCmPerLux(double cmPerLux)
    {
        if (cmPerLux <= 0.0)
        {
            throw new IllegalArgumentException("cmPerLux cannot be zero or negative");
        }

        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMilimeter()
    {
        return this.cmPerMilimeter;
    }

    public void setCmPerMilimeter(double cmPerMilimeter)
    {
        if (cmPerMilimeter <= 0.0)
        {
            throw new IllegalArgumentException("cmPerMilimeter cannot be zero or negative");
        }

        this.cmPerMilimeter = cmPerMilimeter;
    }

    public int getRipeLength()
    {
        return this.ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        if (ripeLength <= 0)
        {
            throw new IllegalArgumentException("ripeLength cannot be zero or negative");
        }

        this.ripeLength = ripeLength;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        if (color == null)
        {
            throw new IllegalArgumentException("color cannot be null");
        }

        this.color = color;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("status cannot be null");
        }

        this.status = status;
    }

    protected double getTotalSize(int lux, int mm, int amountOfDays)
    {
        double totalGrowth = 0.0;

        for (int i = 0; i < amountOfDays; i++)
        {
            totalGrowth += (lux * this.cmPerLux) + (mm * this.cmPerMilimeter);
        }

        return totalGrowth + this.sizeInCm;
    }

    protected void validateWeather(int lux, int mm, int amountOfDays)
    {
        if (lux < 0 || mm < 0 || amountOfDays < 0)
        {

            throw new IllegalArgumentException("values cannot be negative");
        }
    }

    public void validateRipeness()
    {
        if (this.ripeLength <= this.sizeInCm)
        {
            this.setStatus(Status.READY_TO_HARVEST);
        }
    }

    public abstract void grow(int lux, int mm, int amountOfDays);
}
