package com.example.householdgrocery.expiry;

import com.example.householdgrocery.barcode.BarcodeHasher;
import com.example.householdgrocery.db.SQLiteHelper;
import com.example.householdgrocery.exceptions.ExpiryException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryManagerTest {
    @Test
    public void testUpdateExpiry() throws SQLException, ExpiryException {
        SQLiteHelper dbHelper = new SQLiteHelper();
        dbHelper.initializeDatabase();
        BarcodeHasher barcodeHasher = new BarcodeHasher();
        ExpiryManager manager = new ExpiryManager(dbHelper, barcodeHasher);
        manager.updateExpiry("123456789012", LocalDate.of(2023, 10, 15));
        LocalDate expiryDate = manager.getExpiryDate("123456789012");
        assertEquals(LocalDate.of(2023, 10, 15), expiryDate);
    }
}