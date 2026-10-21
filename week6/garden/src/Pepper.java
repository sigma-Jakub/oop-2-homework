public class Pepper extends Vegetable implements Marketable
{
    private static final double CM_PER_LUX = 0.000044;
    private static final double CM_PER_MM = 0.0013;
    private static final Color COLOR = Color.PINK;
    private static final int RIPE_LENGTH = 7;
    private static final int LIMIT_MM_DAYS = 4;
    private static final int LIMIT_MM = 31;
    private static final int MIN_MM = 25;
    private static final int MAX_NO_MM_DAYS = 10;
    private static final int MIN_SIZE = 15;
    private static final int MAX_SIZE = 21;
    private static final double PRICE_PER_CM = 0.15;

    public Pepper()
    {
        super(CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        this.validateWeather(lux, mm, amountOfDays);

        if (!(amountOfDays > LIMIT_MM_DAYS && mm > LIMIT_MM))
        {
            if (!(mm < MIN_MM && amountOfDays >= MAX_NO_MM_DAYS))
            {
                if (!this.getStatus().equals(Status.DESTROYED))
                {
                    this.setSizeInCm(this.getTotalSize(lux, mm, amountOfDays));
                    this.validateRipeness();
                }
            }
        }
        else
        {
            this.setStatus(Status.DESTROYED);
        }
    }

    @Override
    public boolean isMarketable()
    {
        return (this.getStatus().equals(Status.READY_TO_HARVEST) && this.getSizeInCm() >= MIN_SIZE && this.getSizeInCm() <= MAX_SIZE);
    }

    @Override
    public double getPrice()
    {
        return PRICE_PER_CM * this.getSizeInCm();
    }
}
