package com.example.householdgrocery.barcode;

import com.example.householdgrocery.exceptions.InvalidBarcodeException;

public class BarcodeHasher {
    public String hashBarcode(String barcode) {
        // Implement barcode hashing logic
        return barcode + "_hashed";
    }

    public boolean isValidBarcode(String barcode) {
        // Implement barcode validation logic
        return barcode != null && !barcode.isEmpty();
    }
}