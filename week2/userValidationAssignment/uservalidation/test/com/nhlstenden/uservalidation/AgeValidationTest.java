package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidationTest
{
    @Test
    void constructorThrowsWhenMinimumAgeIsZero()
    {
        assertThrows(IllegalArgumentException.class, () -> new AgeValidation(0));
    }

    @Test
    void constructorThrowsWhenMinimumAgeIsNegative()
    {
        assertThrows(IllegalArgumentException.class, () -> new AgeValidation(-1));
    }

    @Test
    void isValidatedReturnsTrueWhenUserIsOlderThanMinimumAge()
    {
        AgeValidation ageValidation = new AgeValidation(18);
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));

        assertTrue(ageValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsTrueWhenUserIsExactlyMinimumAge()
    {
        AgeValidation ageValidation = new AgeValidation(18);
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(18));

        assertTrue(ageValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsFalseWhenUserIsYoungerThanMinimumAge()
    {
        AgeValidation ageValidation = new AgeValidation(18);
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(16));

        assertFalse(ageValidation.isValidated(user));
    }
}
