package com.example.notes_api.Exception;

// author : varun pawar


public class InvalidNoteException extends RuntimeException {
    
    public InvalidNoteException(String message){
        super(message);
    }
}
