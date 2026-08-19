package com.tanvi.qa.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private DriverManager() {
        // Prevent instantiation.
    }

    public static void setDriver(WebDriver driver) {

        if (driver == null) {
            throw new IllegalArgumentException(
                    "WebDriver cannot be null"
            );
        }

        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {

        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been initialized"
            );
        }

        return driver;
    }

    public static void quitDriver() {

        WebDriver driver = DRIVER.get();

        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}