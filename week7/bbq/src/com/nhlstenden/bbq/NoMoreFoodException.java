package com.nhlstenden.bbq;

public class NoMoreFoodException extends RuntimeException
{
    public NoMoreFoodException(String message)
    {
        super(message);
    }
}
