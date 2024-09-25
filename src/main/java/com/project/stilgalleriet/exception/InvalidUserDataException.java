package com.project.stilgalleriet.exception;

public class InvalidUserDataException extends RuntimeException {
    public InvalidUserDataException (String message) {
        super(message);
    }
}
