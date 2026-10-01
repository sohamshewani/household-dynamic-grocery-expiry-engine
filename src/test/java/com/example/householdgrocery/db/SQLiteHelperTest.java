package com.example.householdgrocery.db;

import com.example.householdgrocery.util.TesseractIntegration;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SQLiteHelperTest {
    @Test
    public void testInitializeDatabase() throws SQLException {
        SQLiteHelper dbHelper = new SQLiteHelper();
        dbHelper.initializeDatabase();
        assertDoesNotThrow(() -> {
            // Ensure no exceptions are thrown
        });
    }
}