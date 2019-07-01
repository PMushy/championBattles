package com.java.exceptions;

public class InvalidChampionDataException extends RuntimeException {
    public InvalidChampionDataException(String message) {
        super(message);
    }

    public InvalidChampionDataException(
            String message, Throwable cause) {
        super(message, cause);
    }
}
