package com.example.householdgrocery.util;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.Map;

public class TesseractIntegration {
    private final String tesseractPath;

    public TesseractIntegration(String tesseractPath) {
        this.tesseractPath = tesseractPath;
    }

    public static String extractText(Tesseract tesseract, File file, String language) throws TesseractException, IOException {
        return tesseract.doOCR(file, language);
    }
}