package com.nhlstenden.stock;

public class NotEnoughMoneyException extends RuntimeException
{
    public NotEnoughMoneyException(String message)
    {
        super(message);
    }
}
