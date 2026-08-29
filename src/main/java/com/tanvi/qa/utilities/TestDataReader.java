package com.tanvi.qa.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestDataReader {

    private TestDataReader() {
        // Utility class
    }

    public static String get(
            String resourcePath,
            String key) {

        if (resourcePath == null || resourcePath.isBlank()) {
            throw new IllegalArgumentException(
                    "Resource path cannot be null or empty"
            );
        }

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException(
                    "Property key cannot be null or empty"
            );
        }

        Properties properties = new Properties();

        try (InputStream inputStream =
                     TestDataReader.class
                             .getClassLoader()
                             .getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalArgumentException(
                        "Test data resource not found: "
                                + resourcePath
                );
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to load test data: "
                            + resourcePath,
                    e
            );
        }

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Test data key not found or empty: "
                            + key
            );
        }

        return value.trim();
    }
}