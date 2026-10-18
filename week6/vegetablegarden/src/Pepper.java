public class Pepper extends Vegetable
{
    private static final double CM_PER_LUX = 0.000044;
    private static final double CM_PER_MM = 0.0013;
    private static final int RIPE_LENGTH = 7;
    private static final Color COLOR = Color.PINK;
    private static final int MAX_MM = 31;
    private static final int MIN_MM = 25;
    private static final int MIN_DAYS = 10;
    private static final int MAX_DAYS = 4;

    public Pepper(double cmPerLux, double cmPerMilimeter, int ripeLength, Color color)
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

        if (amountOfDays > MAX_DAYS && mm > MAX_MM)
        {
            this.setStatus(Status.DESTROYED);
        }

        if (mm > MIN_MM && amountOfDays <= MIN_DAYS)
        {
            return;
        }
        else
        {
//            create class growingCalculator
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
