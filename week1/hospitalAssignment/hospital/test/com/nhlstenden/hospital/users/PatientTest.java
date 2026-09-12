package com.nhlstenden.hospital.users;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest
{
    @Test
    void setDateOfBirth_todayDate_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Patient("Jakub", LocalDate.now(), "M", 75, 100, 70, true));
    }

    @Test
    void setName_blankName_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Patient("  ", LocalDate.now(), "M", 75, 100, 70, true));
    }

    @Test
    void setSex_invalidString_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Patient("Jakub", LocalDate.now(), "Male", 75, 100, 70, true));
    }

    @Test
    void setSystolicPressure_negativeNumber_throwsIllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class, () -> new Patient("Jakub", LocalDate.now(), "M", 75, -100, 70, true));
    }
}