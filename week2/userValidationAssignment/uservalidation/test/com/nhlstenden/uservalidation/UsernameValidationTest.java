package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsernameValidationTest
{
    private Storage storage;
    private UsernameValidation usernameValidation;

    @BeforeEach
    void setUp()
    {
        this.storage = new Storage();
        this.usernameValidation = new UsernameValidation(this.storage);
    }

    @Test
    void constructorThrowsWhenStorageIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new UsernameValidation(null));
    }

    @Test
    void isValidatedReturnsTrueWhenUsernameIsNotYetStored()
    {
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));

        assertTrue(this.usernameValidation.isValidated(user));
    }

    @Test
    void isValidatedReturnsFalseWhenUsernameAlreadyExistsInValidatedUsers()
    {
        User existingUser = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));
        this.storage.addValidUser(existingUser);
        User newUser = new User("john", "differentPassword1", "different@example.com", LocalDate.now().minusYears(30));

        assertFalse(this.usernameValidation.isValidated(newUser));
    }

    @Test
    void isValidatedReturnsTrueWhenUsernameDiffersFromStoredUsers()
    {
        User existingUser = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));
        this.storage.addValidUser(existingUser);
        User newUser = new User("jane", "differentPassword1", "jane@example.com", LocalDate.now().minusYears(30));

        assertTrue(this.usernameValidation.isValidated(newUser));
    }
}
