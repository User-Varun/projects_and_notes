package com.example.notes_api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.notes_api.exceptions.InvalidNoteException;
import com.example.notes_api.exceptions.NoteNotFoundException;

@RestControllerAdvice
public class ApiExceptionHanlder {
    
    @ExceptionHandler(InvalidNoteException.class)
    public ResponseEntity<Map<String , String>> handleInvalidNote(InvalidNoteException ex){
            return ResponseEntity.badRequest().body(Map.of("Error" , ex.getMessage()));
    }

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<Map<String , String>> handleNoteNotFound(NoteNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error" , e.getMessage()));
    }
    
}


