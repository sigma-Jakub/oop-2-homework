package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidationTest
{
    private final EmailValidation emailValidation = new EmailValidation();

    @Test
    void isValidatedReturnsTrueWhenEmailContainsAtSignAndDot()
    {
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));

        assertTrue(this.emailValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsFalseWhenEmailIsMissingAtSign()
    {
        User user = new User("john", "password123", "johnexample.com", LocalDate.now().minusYears(25));

        assertFalse(this.emailValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsFalseWhenEmailIsMissingDot()
    {
        User user = new User("john", "password123", "john@examplecom", LocalDate.now().minusYears(25));

        assertFalse(this.emailValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsFalseWhenEmailIsMissingAtSignAndDot()
    {
        User user = new User("john", "password123", "johnexamplecom", LocalDate.now().minusYears(25));

        assertFalse(this.emailValidation.isValidated(user));
    }
}
