package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class ValidationModule
{
    private Storage storage;
    private List<User> users;
    private List<Validation> validations;

    public ValidationModule(Storage storage)
    {
        this.setStorage(storage);
        this.setUsers(new ArrayList<>());
        this.setValidations(new ArrayList<>());
    }

    public Storage getStorage()
    {
        return this.storage;
    }

    public void setStorage(Storage storage)
    {
        if (storage == null)
        {
            throw new IllegalArgumentException("storage cannot be null");
        }

        this.storage = storage;
    }

    public List<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(List<User> users)
    {
        if (users == null)
        {
            throw new IllegalArgumentException("users cannot be null");
        }

        for (User usersItem : users)
        {
            if (usersItem == null)
            {
                throw new IllegalArgumentException("users cannot be null");
            }
        }

        this.users = new ArrayList<>(users);
    }

    public List<Validation> getValidations()
    {
        return this.validations;
    }

    public void setValidations(List<Validation> validations)
    {
        if (validations == null)
        {
            throw new IllegalArgumentException("validations cannot be null");
        }

        for (Validation validationsItem : validations)
        {
            if (validationsItem == null)
            {
                throw new IllegalArgumentException("validations cannot be null");
            }
        }

        this.validations = new ArrayList<>(validations);
    }

    public void addUser(User user)
    {
        if (user == null)
        {
            throw new IllegalArgumentException("user cannot be null");
        }

        this.users.add(user);
    }

    public void removeUser(User user)
    {
        this.users.remove(user);
    }

    public void addValidation(Validation validation)
    {
        if (validation == null)
        {
            throw new IllegalArgumentException("validation cannot be null");
        }

        this.validations.add(validation);
    }

    public void removeValidation(Validation validation)
    {
        this.validations.remove(validation);
    }

    public void validateUsers()
    {
        List<User> userList = new ArrayList<>(this.users);
        boolean checkedFlag = false;

        for (User user : userList)
        {
            for (Validation validation : this.validations)
            {
                if (!validation.isValidated(user))
                {
                    this.storage.addInvalidUser(user);
                    this.users.remove(user);
                    checkedFlag = true;
                    break;
                }
            }

            if (!checkedFlag)
            {
                this.storage.addValidUser(user);
                this.users.remove(user);
            }

            checkedFlag = false;
        }
    }
}
