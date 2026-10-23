package com.nhlstenden.bbq;

public class FridgeIsEmptyException extends RuntimeException
{
    public FridgeIsEmptyException(String message)
    {
        super(message);
    }
}
