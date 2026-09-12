package com.nhlstenden.uservalidation;

public class AgeValidation implements Validation
{
    private int minimumAge;

    public AgeValidation(int minimumAge)
    {
        this.setMinimumAge(minimumAge);
    }

    public int getMinimumAge()
    {
        return this.minimumAge;
    }

    public void setMinimumAge(int minimumAge)
    {
        if (minimumAge <= 0)
        {
            throw new IllegalArgumentException("minimumAge cannot be zero or negative");
        }

        this.minimumAge = minimumAge;
    }

    @Override
    public boolean isValidated(User user)
    {
        return (user.getAge() >= this.minimumAge);
    }
}
