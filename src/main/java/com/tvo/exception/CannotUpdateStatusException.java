package com.tvo.exception;

public class CannotUpdateStatusException extends RuntimeException{
    public CannotUpdateStatusException(String message){
        super(message);
    }
}
