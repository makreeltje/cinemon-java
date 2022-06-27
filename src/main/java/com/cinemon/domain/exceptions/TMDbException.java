package com.cinemon.domain.exceptions;

public class TMDbException extends RuntimeException {
    public TMDbException(String message) {
        super(message);
    }
}
