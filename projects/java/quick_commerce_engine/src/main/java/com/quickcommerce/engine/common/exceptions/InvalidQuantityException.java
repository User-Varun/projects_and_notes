package com.quickcommerce.engine.common.exceptions;

public class InvalidQuantityException extends RuntimeException{
    public InvalidQuantityException(String message){
        super(message);
    }
}
