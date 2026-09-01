package com.tanvi.qa.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JsonFileReader {

    private JsonFileReader() {
        // Utility class
    }

    public static String read(String filePath) {

        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException(
                    "JSON file path cannot be null or empty"
            );
        }

        try {
            return Files.readString(
                    Path.of(filePath)
            );
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read JSON file: " + filePath,
                    e
            );
        }
    }
}