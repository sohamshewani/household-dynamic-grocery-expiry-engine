package com.example.householdgrocery.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteHelper {
    private static final String DB_PATH = Constants.DB_PATH;

    public void initializeDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH)) {
            String sql = "CREATE TABLE IF NOT EXISTS receipts (id INTEGER PRIMARY KEY, content TEXT, timestamp TEXT)";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
            }
        }
    }

    public void updateExpiry(String barcode, String expiryDate) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH)) {
            String sql = "UPDATE expiries SET expiry_date = ? WHERE barcode = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, expiryDate);
                pstmt.setString(2, barcode);
                pstmt.executeUpdate();
            }
        }
    }

    public String getExpiryDate(String barcode) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH)) {
            String sql = "SELECT expiry_date FROM expiries WHERE barcode = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, barcode);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("expiry_date");
                    }
                }
            }
        }
        return null;
    }
}