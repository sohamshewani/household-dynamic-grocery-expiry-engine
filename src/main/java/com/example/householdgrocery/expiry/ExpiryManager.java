package com.example.householdgrocery.expiry;

import com.example.householdgrocery.barcode.BarcodeHasher;
import com.example.householdgrocery.db.SQLiteHelper;
import com.example.householdgrocery.exceptions.ExpiryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ExpiryManager {
    private final SQLiteHelper dbHelper;
    private final BarcodeHasher barcodeHasher;

    public ExpiryManager(SQLiteHelper dbHelper, BarcodeHasher barcodeHasher) {
        this.dbHelper = dbHelper;
        this.barcodeHasher = barcodeHasher;
    }

    public void updateExpiry(String barcode, LocalDate expiryDate) throws ExpiryException {
        String hashedBarcode = barcodeHasher.hashBarcode(barcode);
        dbHelper.updateExpiry(hashedBarcode, expiryDate.toString());
    }

    public LocalDate getExpiryDate(String barcode) throws ExpiryException {
        String hashedBarcode = barcodeHasher.hashBarcode(barcode);
        String expiryDateString = dbHelper.getExpiryDate(hashedBarcode);
        return expiryDateString == null ? null : LocalDate.parse(expiryDateString);
    }
}