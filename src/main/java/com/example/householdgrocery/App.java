package com.example.householdgrocery;

import com.example.householdgrocery.barcode.BarcodeHasher;
import com.example.householdgrocery.expiry.ExpiryManager;
import com.example.householdgrocery.forecasting.ForecastingEngine;
import com.example.householdgrocery.receipt.Receipt;
import com.example.householdgrocery.receipt.OCRIngestion;
import com.example.householdgrocery.db.SQLiteHelper;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BarcodeHasher barcodeHasher = new BarcodeHasher();
        ExpiryManager expiryManager = new ExpiryManager(); // Initialize ExpiryManager
        ForecastingEngine forecastingEngine = new ForecastingEngine(); // Initialize ForecastingEngine
        SQLiteHelper dbHelper = new SQLiteHelper(); // Initialize SQLiteHelper
        OCRIngestion ocrIngestion = new OCRIngestion(); // Initialize OCRIngestion

        List<Receipt> receipts = ocrIngestion.parseReceipts(); // Parse receipts
        System.out.println("Parsed receipts: " + receipts.size());
        for (Receipt receipt : receipts) {
            String barcode = receipt.getBarcode();
            String hash = barcodeHasher.hash(barcode);
            System.out.println("Hashed barcode: " + hash);
            expiryManager.checkExpiry(hash);
            forecastingEngine.forecastItems(receipt.getItems());
        }
        dbHelper.saveReceipts(receipts); // Save parsed receipts to database
    }
}