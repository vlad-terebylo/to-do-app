package com.tvo.exception;

public class TaskStatusIsNotSupportedException extends RuntimeException {
    public TaskStatusIsNotSupportedException(String message) {
        super(message);
    }
}
