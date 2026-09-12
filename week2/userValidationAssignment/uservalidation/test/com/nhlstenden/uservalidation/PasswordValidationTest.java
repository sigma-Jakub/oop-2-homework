package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest
{
    @Test
    void isValidatedReturnsFalseWhenSpacesAreNotAllowedAndPasswordContainsSpace()
    {
        PasswordValidation passwordValidation = new PasswordValidation(false, false, false, false, false);

        assertFalse(passwordValidation.isValidated(userWithPassword("pass word")));
    }

    @Test
    void isValidatedReturnsTrueWhenSpacesAreNotAllowedAndPasswordHasNoSpace()
    {
        PasswordValidation passwordValidation = new PasswordValidation(false, false, false, false, false);

        assertTrue(passwordValidation.isValidated(userWithPassword("password")));
    }

    @Test
    void isValidatedReturnsTrueWhenSpacesAreAllowedAndPasswordContainsSpace()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, false, false, false);

        assertTrue(passwordValidation.isValidated(userWithPassword("pass word")));
    }

    @Test
    void isValidatedReturnsFalseWhenSpecialCharacterIsMandatoryAndMissing()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, true, false, false, false);

        assertFalse(passwordValidation.isValidated(userWithPassword("password1")));
    }

    @Test
    void isValidatedReturnsTrueWhenSpecialCharacterIsMandatoryAndPresent()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, true, false, false, false);

        assertTrue(passwordValidation.isValidated(userWithPassword("password!")));
    }

    @Test
    void isValidatedReturnsFalseWhenNumberIsMandatoryAndMissing()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, true, false, false);

        assertFalse(passwordValidation.isValidated(userWithPassword("password!")));
    }

    @Test
    void isValidatedReturnsTrueWhenNumberIsMandatoryAndPresent()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, true, false, false);

        assertTrue(passwordValidation.isValidated(userWithPassword("password1")));
    }

    @Test
    void isValidatedReturnsFalseWhenLowercaseSymbolIsMandatoryAndMissing()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, false, true, false);

        assertFalse(passwordValidation.isValidated(userWithPassword("PASSWORD")));
    }

    @Test
    void isValidatedReturnsTrueWhenLowercaseSymbolIsMandatoryAndPresent()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, false, true, false);

        assertTrue(passwordValidation.isValidated(userWithPassword("Password")));
    }

    @Test
    void isValidatedReturnsFalseWhenUppercaseSymbolIsMandatoryAndMissing()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, false, false, true);

        assertFalse(passwordValidation.isValidated(userWithPassword("password")));
    }

    @Test
    void isValidatedReturnsTrueWhenUppercaseSymbolIsMandatoryAndPresent()
    {
        PasswordValidation passwordValidation = new PasswordValidation(true, false, false, false, true);

        assertTrue(passwordValidation.isValidated(userWithPassword("Password")));
    }

    @Test
    void isValidatedReturnsTrueWhenPasswordSatisfiesAllMandatoryRules()
    {
        PasswordValidation passwordValidation = new PasswordValidation(false, true, true, true, true);

        assertTrue(passwordValidation.isValidated(userWithPassword("Password1!")));
    }

    @Test
    void isValidatedReturnsFalseWhenPasswordFailsOneOfSeveralMandatoryRules()
    {
        PasswordValidation passwordValidation = new PasswordValidation(false, true, true, true, true);

        assertFalse(passwordValidation.isValidated(userWithPassword("password1!")));
    }

    private static User userWithPassword(String password)
    {
        return new User("john", password, "john@example.com", LocalDate.now().minusYears(25));
    }
}
