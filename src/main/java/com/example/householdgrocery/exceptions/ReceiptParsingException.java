package com.example.householdgrocery.exceptions;

public class ReceiptParsingException extends RuntimeException {
    public ReceiptParsingException(String message) {
        super(message);
    }
}