package com.example.householdgrocery.exceptions;

public class InvalidBarcodeException extends RuntimeException {
    public InvalidBarcodeException(String message) {
        super(message);
    }
}