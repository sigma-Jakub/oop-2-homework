package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest
{
    private LocalDate validDateOfBirth;

    @BeforeEach
    void setUp()
    {
        this.validDateOfBirth = LocalDate.now().minusYears(25);
    }

    @Test
    void constructorSetsAllFieldsCorrectly()
    {
        User user = new User("john", "password123", "john@example.com", this.validDateOfBirth);

        assertEquals("john", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("john@example.com", user.getEmail());
        assertEquals(this.validDateOfBirth, user.getDateOfBirth());
    }

    @Test
    void constructorThrowsWhenUsernameIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new User(null, "password123", "john@example.com", this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenUsernameIsBlank()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("   ", "password123", "john@example.com", this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenPasswordIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", null, "john@example.com", this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenPasswordIsBlank()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "   ", "john@example.com", this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenEmailIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "password123", null, this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenEmailIsBlank()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "password123", "   ", this.validDateOfBirth));
    }

    @Test
    void constructorThrowsWhenDateOfBirthIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "password123", "john@example.com", null));
    }

    @Test
    void constructorThrowsWhenDateOfBirthIsToday()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "password123", "john@example.com", LocalDate.now()));
    }

    @Test
    void constructorThrowsWhenDateOfBirthIsInTheFuture()
    {
        assertThrows(IllegalArgumentException.class, () -> new User("john", "password123", "john@example.com", LocalDate.now().plusDays(1)));
    }

    @Test
    void getAgeReturnsCorrectAge()
    {
        User user = new User("john", "password123", "john@example.com", LocalDate.now().minusYears(20));

        assertEquals(20, user.getAge());
    }
}
