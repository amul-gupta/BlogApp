package com.mycode.BlogApp.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
