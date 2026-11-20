package com.example.notes_api.Exception;

public class NoteNotFoundException extends RuntimeException{
    
    public NoteNotFoundException(String message){
       super(message);
    } 
}
