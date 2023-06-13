package com.example.Library.config;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}