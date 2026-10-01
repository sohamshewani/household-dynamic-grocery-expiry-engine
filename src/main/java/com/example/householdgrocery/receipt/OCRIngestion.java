package com.example.householdgrocery.receipt;

import com.example.householdgrocery.util.TesseractIntegration;
import com.example.householdgrocery.exceptions.ReceiptParsingException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.tesseract.Tesseract;
import org.tesseract.TesseractException;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OCRIngestion {
    private final Tesseract tesseract = new Tesseract(TESSERACT_PATH);
    private static final String DEFAULT_LANGUAGE = "eng";

    public Receipt parseReceipt(File receiptFile) throws ReceiptParsingException {
        try {
            String text = TesseractIntegration.extractText(tesseract, receiptFile, DEFAULT_LANGUAGE);
            return new Receipt(text, new Date());
        } catch (TesseractException | IOException e) {
            throw new ReceiptParsingException("Failed to parse receipt", e);
        }
    }
}