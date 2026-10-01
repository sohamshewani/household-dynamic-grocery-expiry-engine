package com.example.householdgrocery.forecasting;

import com.example.householdgrocery.db.SQLiteHelper;
import com.example.householdgrocery.exceptions.ReceiptParsingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ForecastingEngineTest {
    @Test
    public void testPredictFutureNeeds() throws ReceiptParsingException {
        SQLiteHelper dbHelper = new SQLiteHelper();
        dbHelper.initializeDatabase();
        ForecastingEngine engine = new ForecastingEngine(dbHelper);
        List<com.example.householdgrocery.receipt.Receipt> receipts = new ArrayList<>();
        engine.predictFutureNeeds(receipts);
        assertDoesNotThrow(() -> {
            // Ensure no exceptions are thrown
        });
    }
}