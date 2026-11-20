package com.example.notes_api.Exception;

public class  UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
