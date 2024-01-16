package com.ecommerce.api.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message){
        super(message);
    }
}
