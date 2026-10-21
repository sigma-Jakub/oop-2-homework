public class Asparagus extends Vegetable implements Marketable
{
    private static final double CM_PER_LUX = 0.000027;
    private static final double CM_PER_MM = 0.0049;
    private static final Color COLOR = Color.BLUE;
    private static final int RIPE_LENGTH = 20;
    private static final int MM_MIN_NEED = 14;
    private static final int DAYS_WITHOUT_MM = 10;
    private static final int MAX_SIZE = 29;
    private static final double PRICE_PER_CM = 0.12;

    public Asparagus()
    {
        super(CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        this.validateWeather(lux, mm, amountOfDays);

        if (!(mm < MM_MIN_NEED && amountOfDays >= DAYS_WITHOUT_MM))
        {
            if (!this.getStatus().equals(Status.DESTROYED))
            {
                this.setSizeInCm(this.getTotalSize(lux, mm, amountOfDays));
                this.validateRipeness();
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
        return (this.getStatus().equals(Status.READY_TO_HARVEST) && this.getSizeInCm() <= MAX_SIZE);
    }

    @Override
    public double getPrice()
    {
        return PRICE_PER_CM * this.getSizeInCm();
    }
}
