import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsparagusTest
{

    @Test
    void grow_invalidParameters_throwsIllegalArgumentException()
    {
        Asparagus asparagus = new Asparagus();

        assertThrows(IllegalArgumentException.class, () -> asparagus.grow(-10, 0, 10));
    }

    @Test
    void grow_badWeatherConditions_vegetableStatusDestroyed()
    {
        Asparagus asparagus = new Asparagus();

        asparagus.grow(10, 1, 10);

        assertEquals(Status.DESTROYED, asparagus.getStatus());
    }

    @Test
    void grow_goodWeatherConditions_vegetableStatusReadyToHarvest()
    {
        Asparagus asparagus = new Asparagus();

        asparagus.grow(100000, 100000, 100000);

        assertEquals(Status.READY_TO_HARVEST, asparagus.getStatus());
    }
}