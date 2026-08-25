package com.example.notes_api.exceptions;

public class NoteNotFoundException extends RuntimeException{
    
    public NoteNotFoundException(String message){
       super(message);
    } 
}
