package com.example.taskManagement.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
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
