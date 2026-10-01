package com.example.householdgrocery.receipt;

import com.example.householdgrocery.exceptions.ReceiptParsingException;
import com.example.householdgrocery.util.TesseractIntegration;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OCRIngestionTest {
    @Test
    public void testParseReceiptSuccess() throws ReceiptParsingException {
        TesseractIntegration mockTesseractIntegration = Mockito.mock(TesseractIntegration.class);
        Mockito.when(mockTesseractIntegration.extractText(Mockito.any(Tesseract.class), Mockito.any(File.class), Mockito.anyString())).thenReturn("Sample receipt content");
        OCRIngestion ingestion = new OCRIngestion(mockTesseractIntegration);
        Receipt receipt = ingestion.parseReceipt(new File("path/to/receipt.png"));
        assertEquals("Sample receipt content", receipt.getContent());
    }

    @Test
    public void testParseReceiptFailure() {
        TesseractIntegration mockTesseractIntegration = Mockito.mock(TesseractIntegration.class);
        Mockito.when(mockTesseractIntegration.extractText(Mockito.any(Tesseract.class), Mockito.any(File.class), Mockito.anyString())).thenThrow(new TesseractException("Mock Tesseract Exception"));
        OCRIngestion ingestion = new OCRIngestion(mockTesseractIntegration);
        assertThrows(ReceiptParsingException.class, () -> ingestion.parseReceipt(new File("path/to/receipt.png")));
    }
}