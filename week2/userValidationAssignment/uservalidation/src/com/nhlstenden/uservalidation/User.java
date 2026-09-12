package com.nhlstenden.uservalidation;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String username;
    private String password;
    private String email;
    private LocalDate dateOfBirth;

    public User(String username, String password, String email, LocalDate dateOfBirth)
    {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        if (username == null || username.isBlank())
        {
            throw new IllegalArgumentException("username cannot be null or blank");
        }

        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        if (password == null || password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be null or blank");
        }

        this.password = password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        if (email == null || email.isBlank())
        {
            throw new IllegalArgumentException("email cannot be null or blank");
        }

        this.email = email;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now()) || dateOfBirth.isEqual(LocalDate.now()))
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null set now or in the future");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public int getAge()
    {
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
