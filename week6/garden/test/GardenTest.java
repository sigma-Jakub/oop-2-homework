import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest
{

    @Test
    void addVegetable_addingNull_throwsIllegalArgumentException()
    {
        Garden garden = new Garden();

        assertThrows(IllegalArgumentException.class, () -> garden.addVegetable(null));
    }

    @Test
    void addVegetable_adding28thVegetable_throwsTooManyVegetablesException()
    {
        Garden garden = new Garden();

        for (int i = 0; i < 27; i++)
        {
            garden.addVegetable(new Asparagus());
        }

        assertThrows(TooManyVegetablesException.class, () -> garden.addVegetable(new Asparagus()));
    }
}