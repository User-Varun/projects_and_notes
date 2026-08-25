package com.example.notes_api.exceptions;

public class InvalidNoteException extends RuntimeException {
    
    public InvalidNoteException(String message){
        super(message);
    }
}
