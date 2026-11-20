package com.example.notes_api.Exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHanlder {
    
    @ExceptionHandler(InvalidNoteException.class)
    public ResponseEntity<Map<String , String>> handleInvalidNote(InvalidNoteException ex){
            return ResponseEntity.badRequest().body(Map.of("Error" , ex.getMessage()));
    }


    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Map<String , String>> handleInvalidPassword(InvalidPasswordException ex){
        return ResponseEntity.badRequest().body(Map.of("Error" , ex.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Username or password is not valid"));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String , String>> handleUserNotFound(UserNotFoundException ex){
        return ResponseEntity.badRequest().body(Map.of("Error" , ex.getMessage()));
    }


    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<Map<String , String>> handleNoteNotFound(NoteNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error" , e.getMessage()));
    }

    @ExceptionHandler(InvalidRegisterRequestException.class)
    public ResponseEntity<Map<String , String>> handleInvalidUserRequest(InvalidRegisterRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error" , ex.getMessage()));
    }
    
}

