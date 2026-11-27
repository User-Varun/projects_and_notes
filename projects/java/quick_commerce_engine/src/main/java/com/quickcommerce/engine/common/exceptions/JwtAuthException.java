package com.quickcommerce.engine.common.exceptions;

public class JwtAuthException extends RuntimeException{
    public JwtAuthException(String message){
        super(message);
    }
}
