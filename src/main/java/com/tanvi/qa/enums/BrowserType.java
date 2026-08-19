package com.tanvi.qa.enums;

public enum BrowserType {

    CHROME,
    FIREFOX,
    EDGE;

    public static BrowserType fromString(String browser) {

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException(
                    "Browser cannot be null or empty"
            );
        }

        try {
            return BrowserType.valueOf(
                    browser.trim().toUpperCase()
            );
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                            + ". Supported browsers: CHROME, FIREFOX, EDGE",
                    exception
            );
        }
    }
}