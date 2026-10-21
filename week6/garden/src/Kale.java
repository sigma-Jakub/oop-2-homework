public class Kale extends Vegetable
{
    private static final double CM_PER_LUX = 0.0057;
    private static final double CM_PER_MM = 0.032;
    private static final Color COLOR = Color.YELLOW;
    private static final int RIPE_LENGTH = 16;
    private static final int LIMIT_MM = 40;
    private static final int LIMIT_DAYS = 6;

    public Kale()
    {
        super(CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, COLOR);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        this.validateWeather(lux, mm, amountOfDays);

        if (!(mm > LIMIT_MM && amountOfDays >= LIMIT_DAYS))
        {
            this.setSizeInCm(this.getTotalSize(lux, mm, amountOfDays));
            this.validateRipeness();
        }
    }
}
