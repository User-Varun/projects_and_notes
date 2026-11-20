package com.example.notes_api.Exception;

public class InvalidRegisterRequestException extends RuntimeException{
    public InvalidRegisterRequestException (String message){
        super(message);
    }
}
