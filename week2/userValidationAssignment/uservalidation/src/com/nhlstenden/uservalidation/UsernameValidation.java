package com.nhlstenden.uservalidation;

public class UsernameValidation implements Validation
{
    private Storage storage;

    public UsernameValidation(Storage storage)
    {
        this.setStorage(storage);
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

    @Override
    public boolean isValidated(User user)
    {
        for (User validatedUser : getStorage().getValidatedUsers())
        {
            if (user.getUsername().equals(validatedUser.getUsername()))
            {
                return false;
            }
        }

        return true;
    }
}
