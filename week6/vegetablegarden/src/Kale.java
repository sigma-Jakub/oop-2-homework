public class Kale extends Vegetable
{
    private static final double CM_PER_LUX = 0.0057;
    private static final double CM_PER_MM = 0.032;
    private static final int RIPE_LENGTH = 16;
    private static final Color COLOR = Color.YELLOW;

    public Kale(double cmPerLux, double cmPerMilimeter, int ripeLength, Color color)
    {
        super(CM_PER_LUX, CM_PER_MM, RIPE_LENGTH, COLOR);
    }

    public void grow(int lux, int mm, int amountOfDays)
    {

    }
}
