package com.brocamp.AcousticAlchemy.exception;

public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException(String message){
        super(message);
    }
}
