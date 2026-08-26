package com.example.taskManagement;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message){

    super(message);
    }
}
