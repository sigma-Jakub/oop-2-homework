package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest
{
    private Storage storage;
    private User user;

    @BeforeEach
    void setUp()
    {
        this.storage = new Storage();
        this.user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(25));
    }

    @Test
    void constructorInitializesEmptyLists()
    {
        assertTrue(this.storage.getValidatedUsers().isEmpty());
        assertTrue(this.storage.getInvalidatedUsers().isEmpty());
    }

    @Test
    void addValidUserAddsUserToValidatedUsers()
    {
        this.storage.addValidUser(this.user);

        assertTrue(this.storage.getValidatedUsers().contains(this.user));
    }

    @Test
    void addValidUserThrowsWhenUserIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.storage.addValidUser(null));
    }

    @Test
    void removeValidUserRemovesUserFromValidatedUsers()
    {
        this.storage.addValidUser(this.user);

        this.storage.removeValidUser(this.user);

        assertFalse(this.storage.getValidatedUsers().contains(this.user));
    }

    @Test
    void addInvalidUserAddsUserToInvalidatedUsers()
    {
        this.storage.addInvalidUser(this.user);

        assertTrue(this.storage.getInvalidatedUsers().contains(this.user));
    }

    @Test
    void addInvalidUserThrowsWhenUserIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.storage.addInvalidUser(null));
    }

    @Test
    void removeInvalidUserRemovesUserFromInvalidatedUsers()
    {
        this.storage.addInvalidUser(this.user);

        this.storage.removeInvalidUser(this.user);

        assertFalse(this.storage.getInvalidatedUsers().contains(this.user));
    }

    @Test
    void setValidatedUsersThrowsWhenListIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.storage.setValidatedUsers(null));
    }

    @Test
    void setValidatedUsersThrowsWhenListContainsNull()
    {
        List<User> users = new ArrayList<>();
        users.add(null);

        assertThrows(IllegalArgumentException.class, () -> this.storage.setValidatedUsers(users));
    }

    @Test
    void setValidatedUsersCopiesInputListDefensively()
    {
        List<User> users = new ArrayList<>();
        users.add(this.user);

        this.storage.setValidatedUsers(users);
        users.clear();

        assertEquals(1, this.storage.getValidatedUsers().size());
    }

    @Test
    void setInvalidatedUsersThrowsWhenListIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> this.storage.setInvalidatedUsers(null));
    }

    @Test
    void setInvalidatedUsersThrowsWhenListContainsNull()
    {
        List<User> users = new ArrayList<>();
        users.add(null);

        assertThrows(IllegalArgumentException.class, () -> this.storage.setInvalidatedUsers(users));
    }
}
