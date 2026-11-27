package com.quickcommerce.engine.common.exceptions;

public class InventoryItemNotFoundException extends RuntimeException{
    public InventoryItemNotFoundException(String message){
        super(message);
    }
}
