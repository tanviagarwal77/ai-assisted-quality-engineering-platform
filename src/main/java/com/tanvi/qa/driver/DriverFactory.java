package com.tanvi.qa.driver;

import com.tanvi.qa.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {

    private DriverFactory() {
        // Prevent instantiation.
    }

    public static WebDriver createDriver(BrowserType browserType) {

    validateBrowserType(browserType);

    return switch (browserType) {

        case CHROME -> new ChromeDriver(
                (ChromeOptions) BrowserOptionsFactory.createOptions(browserType)
        );

        case FIREFOX -> new FirefoxDriver(
                (FirefoxOptions) BrowserOptionsFactory.createOptions(browserType)
        );

        case EDGE -> new EdgeDriver(
                (EdgeOptions) BrowserOptionsFactory.createOptions(browserType)
        );
    };
}
    static void validateBrowserType(BrowserType browserType) {

        if (browserType == null) {
            throw new IllegalArgumentException(
                    "Browser type cannot be null"
            );
        }
    }
}