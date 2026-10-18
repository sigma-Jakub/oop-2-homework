public class Asparagus extends Vegetable
{
    private static final double CM_PER_LUX = 0.000027;
    private static final double CM_PER_MM = 0.0049;
    private static final int RIPE_LENGTH = 20;
    private static final Color COLOR = Color.BLUE;
    private static final int MIN_MM = 14;
    private static final int MIN_DAYS = 10;

    public Asparagus(double cmPerLux, double cmPerMilimeter, int ripeLength, Color color)
    {
        super(CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (lux < 0 || mm < 0 || amountOfDays < 0)
        {
            throw new IllegalArgumentException("values cannot be negative");
        }

        if ((mm > 0 && mm < MIN_MM) && (amountOfDays >= MIN_DAYS))
        {
            this.setStatus(Status.DESTROYED);
        }
        else
        {
            double totalGrowth = 0.0;
            for (int i = 0; i < amountOfDays; i++)
            {
                totalGrowth += (CM_PER_LUX * lux) + (CM_PER_MM * mm);
            }

            this.setSizeInCm(this.getSizeInCm() + totalGrowth);

            if (isRipe(this.getRipeLength()))
            {
                this.setStatus(Status.READY_TO_HARVEST);
            }
        }
    }
}
