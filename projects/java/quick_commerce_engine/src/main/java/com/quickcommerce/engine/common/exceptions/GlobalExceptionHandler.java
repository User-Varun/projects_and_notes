package com.quickcommerce.engine.common.exceptions;


import com.quickcommerce.engine.common.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice(basePackages = "com.quickcommerce.engine.controllers")
public class GlobalExceptionHandler {

    private ResponseEntity<ApiErrorResponse> error(HttpStatus status, String code, String message) {
        return ResponseEntity.status(status).body(new ApiErrorResponse(code, message, Instant.now()));
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateEmail(DuplicateEmailException ex){
        return error(HttpStatus.CONFLICT , "Email Already exists" , "Registration failed");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(UserNotFoundException ex){
        return error(HttpStatus.NOT_FOUND , "RESOURCE_NOT_FOUND" , "user not found with id " + ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotFound(ProductNotFoundException ex){
        return error(HttpStatus.NOT_FOUND , "RESOURCE_NOT_FOUND" , "product not found with id " +ex.getMessage());
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidQuantity(InvalidQuantityException ex){
        return error(HttpStatus.BAD_REQUEST , "INVALID_PARAMETER" , "invalid quantity "+ex.getMessage());
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCartNotFound(CartNotFoundException ex){
        return error(HttpStatus.NOT_FOUND , "NOT_FOUND" , "cart not found for the customer "+ex.getMessage());
    }

    @ExceptionHandler(DarkstoreNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleDarkstoreNotFound(DarkstoreNotFoundException ex){
        return error(HttpStatus.NOT_FOUND , "NOT_FOUND" , "Darkstore not found  "+ex.getMessage());
    }


    @ExceptionHandler(InventoryItemNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleInventoryItemNotFound(InventoryItemNotFoundException ex){
        return error(HttpStatus.NOT_FOUND , "NOT_FOUND" , "No items found in the darkstore "+ex.getMessage());
    }


    @ExceptionHandler(JwtAuthException.class)
    public ResponseEntity<ApiErrorResponse> handleJwtAuthException(JwtAuthException ex){
        return error(HttpStatus.NOT_FOUND , "NOT_FOUND" , ex.getMessage());
    }


}
