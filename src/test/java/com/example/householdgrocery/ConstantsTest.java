package com.example.householdgrocery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTest {
    @Test
    public void testConstants() {
        assertEquals("path/to/tesseract/executable", Constants.TESSERACT_PATH);
        assertEquals("db/path/to/database.db", Constants.DB_PATH);
    }
}