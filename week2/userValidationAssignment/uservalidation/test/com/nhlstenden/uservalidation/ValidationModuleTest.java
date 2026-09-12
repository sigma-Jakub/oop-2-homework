package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationModuleTest
{
    private Storage storage;
    private ValidationModule validationModule;
    private User user;

    @BeforeEach
    void setUp()
    {
        this.storage = new Storage();
        this.validationModule = new ValidationModule(this.storage);
        this.user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));
    }

    @Test
    void constructorThrowsWhenStorageIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new ValidationModule(null));
    }

    @Test
    void constructorInitializesEmptyUsersAndValidations()
    {
        assertTrue(this.validationModule.getUsers().isEmpty());
        assertTrue(this.validationModule.getValidations().isEmpty());
    }

    @Test
    void addUserAddsUserToUsersList()
    {
        this.validationModule.addUser(this.user);

        assertTrue(this.validationModule.getUsers().contains(this.user));
    }

    @Test
    void addUserThrowsWhenUserIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.validationModule.addUser(null));
    }

    @Test
    void removeUserRemovesUserFromUsersList()
    {
        this.validationModule.addUser(this.user);

        this.validationModule.removeUser(this.user);

        assertFalse(this.validationModule.getUsers().contains(this.user));
    }

    @Test
    void addValidationAddsValidationToValidationsList()
    {
        Validation validation = user -> true;

        this.validationModule.addValidation(validation);

        assertTrue(this.validationModule.getValidations().contains(validation));
    }

    @Test
    void addValidationThrowsWhenValidationIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.validationModule.addValidation(null));
    }

    @Test
    void removeValidationRemovesValidationFromValidationsList()
    {
        Validation validation = user -> true;
        this.validationModule.addValidation(validation);

        this.validationModule.removeValidation(validation);

        assertFalse(this.validationModule.getValidations().contains(validation));
    }

    @Test
    void validateUsersMovesPassingUserToValidatedUsers()
    {
        this.validationModule.addUser(this.user);
        this.validationModule.addValidation(user -> true);

        this.validationModule.validateUsers();

        assertTrue(this.storage.getValidatedUsers().contains(this.user));
        assertFalse(this.storage.getInvalidatedUsers().contains(this.user));
        assertFalse(this.validationModule.getUsers().contains(this.user));
    }

    @Test
    void validateUsersMovesFailingUserToInvalidatedUsers()
    {
        this.validationModule.addUser(this.user);
        this.validationModule.addValidation(user -> false);

        this.validationModule.validateUsers();

        assertTrue(this.storage.getInvalidatedUsers().contains(this.user));
        assertFalse(this.storage.getValidatedUsers().contains(this.user));
        assertFalse(this.validationModule.getUsers().contains(this.user));
    }

    @Test
    void validateUsersStopsCheckingFurtherValidationsAfterFirstFailure()
    {
        List<Boolean> secondValidationWasCalled = new ArrayList<>();
        this.validationModule.addUser(this.user);
        this.validationModule.addValidation(user -> false);
        this.validationModule.addValidation(user ->
        {
            secondValidationWasCalled.add(true);
            return true;
        });

        this.validationModule.validateUsers();

        assertTrue(secondValidationWasCalled.isEmpty());
    }

    @Test
    void validateUsersDoesNotAffectUsersThatPassAllValidations()
    {
        this.validationModule.addUser(this.user);
        this.validationModule.addValidation(user -> true);
        this.validationModule.addValidation(user -> true);

        this.validationModule.validateUsers();

        assertTrue(this.storage.getValidatedUsers().contains(this.user));
    }
}
