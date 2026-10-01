package com.example.householdgrocery.receipt;

public class Receipt {
    private String content;
    private Date timestamp;

    public Receipt(String content, Date timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}