package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class Storage
{
    private List<User> validatedUsers;
    private List<User> invalidatedUsers;

    public Storage()
    {
        this.setValidatedUsers(new ArrayList<>());
        this.setInvalidatedUsers(new ArrayList<>());
    }

    public List<User> getValidatedUsers()
    {
        return this.validatedUsers;
    }

    public void setValidatedUsers(List<User> validatedUsers)
    {
        if (validatedUsers == null)
        {
            throw new IllegalArgumentException("validatedUsers cannot be null or empty");
        }

        for (User validatedUsersItem : validatedUsers)
        {
            if (validatedUsersItem == null)
            {
                throw new IllegalArgumentException("validatedUsers cannot be null");
            }
        }

        this.validatedUsers = new ArrayList<>(validatedUsers);
    }

    public List<User> getInvalidatedUsers()
    {
        return this.invalidatedUsers;
    }

    public void setInvalidatedUsers(List<User> invalidatedUsers)
    {
        if (invalidatedUsers == null)
        {
            throw new IllegalArgumentException("invalidatedUsers cannot be null or empty");
        }

        for (User invalidatedUsersItem : invalidatedUsers)
        {
            if (invalidatedUsersItem == null)
            {
                throw new IllegalArgumentException("invalidatedUsers cannot be null");
            }
        }

        this.invalidatedUsers = new ArrayList<>(invalidatedUsers);
    }

    public void addValidUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        this.validatedUsers.add(user);
    }

    public void removeValidUser(User user)
    {
        this.validatedUsers.remove(user);
    }

    public void addInvalidUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        this.invalidatedUsers.add(user);
    }

    public void removeInvalidUser(User user)
    {
        this.invalidatedUsers.remove(user);
    }
}
