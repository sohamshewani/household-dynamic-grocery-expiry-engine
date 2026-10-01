package com.example.householdgrocery.barcode;

import com.example.householdgrocery.exceptions.InvalidBarcodeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarcodeHasherTest {
    @Test
    public void testValidBarcodeHashing() {
        BarcodeHasher hasher = new BarcodeHasher();
        String hashedBarcode = hasher.hashBarcode("123456789012");
        assertEquals("123456789012_hashed", hashedBarcode);
    }

    @Test
    public void testInvalidBarcode() {
        BarcodeHasher hasher = new BarcodeHasher();
        assertThrows(InvalidBarcodeException.class, () -> hasher.hashBarcode(""));
    }
}