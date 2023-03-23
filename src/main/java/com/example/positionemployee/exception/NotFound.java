package com.example.positionemployee.exception;

public class NotFound extends RuntimeException {
    private String code;

    public NotFound(String message, String code) {
        super(message);
        this.code = code;
    }
}
