package com.nhlstenden.uservalidation;

public class EmailValidation implements Validation
{
    public EmailValidation()
    {
    }

    @Override
    public boolean isValidated(User user)
    {
        String email = user.getEmail();

        return (email.contains("@") && email.contains("."));
    }
}
