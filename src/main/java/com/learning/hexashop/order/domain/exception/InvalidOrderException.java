package com.learning.hexashop.order.domain.exception;

public class InvalidOrderException extends RuntimeException {

    private final String message;

    public InvalidOrderException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
