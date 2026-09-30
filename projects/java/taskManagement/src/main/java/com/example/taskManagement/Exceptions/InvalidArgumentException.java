package com.example.taskManagement.Exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String message){
        super(message);
    }
}
