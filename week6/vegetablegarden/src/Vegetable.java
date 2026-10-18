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
        this.setSizeInCm(0.0);
        this.setCmPerLux(cmPerLux);
        this.setCmPerMilimeter(cmPerMilimeter);
        this.setRipeLength(ripeLength);
        this.setColor(color);
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
        if (cmPerLux < 0.0)
        {
            throw new IllegalArgumentException("cmPerLux cannot be negative");
        }

        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMilimeter()
    {
        return this.cmPerMilimeter;
    }

    public void setCmPerMilimeter(double cmPerMilimeter)
    {
        if (cmPerMilimeter < 0.0)
        {
            throw new IllegalArgumentException("cmPerMilimeter cannot be negative");
        }

        this.cmPerMilimeter = cmPerMilimeter;
    }

    public int getRipeLength()
    {
        return this.ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        if (ripeLength < 0.0)
        {
            throw new IllegalArgumentException("ripeLength cannot be negative");
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
            throw new IllegalArgumentException("unknown color");
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
            throw new IllegalArgumentException("unknown status");
        }

        this.status = status;
    }

    public boolean isRipe(int ripeLength) {
        return ripeLength <= this.ripeLength;
    }

    public abstract void grow(int lux, int mm, int amountOfDays);
}
