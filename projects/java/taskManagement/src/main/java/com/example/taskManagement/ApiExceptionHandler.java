package com.example.taskManagement;

import com.example.taskManagement.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ErrorResponse> InvalidUserException(InvalidUserException ex){
         ErrorResponse error = new ErrorResponse(
                400,
                "Bad Request",
                ex.getMessage()
        );

        return ResponseEntity
                .badRequest()
                .body(error);
    }
}
