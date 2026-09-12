package com.nhlstenden.hospital.equipment;

import com.nhlstenden.hospital.users.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BedTest
{
    @Test
    void isAvailable_noPatient_returnsTrue()
    {
        Bed bed = new Bed();

        assertTrue(bed.isAvailable());
    }

    @Test
    void isAvailable_hasPatient_returnsFalse()
    {
        Patient patient = new Patient("Jakub", LocalDate.now().minusYears(20), "M", 111, 111, 111, true);
        Bed bed = new Bed();
        bed.setPatient(patient);

        assertFalse(bed.isAvailable());
    }
}