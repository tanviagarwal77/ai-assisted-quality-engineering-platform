package com.tanvi.qa.driver;

import com.tanvi.qa.config.ConfigManager;
import com.tanvi.qa.enums.BrowserType;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;

public final class BrowserOptionsFactory {

    private BrowserOptionsFactory() {
        // Prevent instantiation.
    }

    public static Object createOptions(BrowserType browserType) {

        if (browserType == null) {
            throw new IllegalArgumentException(
                    "Browser type cannot be null"
            );
        }

        return switch (browserType) {

            case CHROME -> createChromeOptions();

            case FIREFOX -> createFirefoxOptions();

            case EDGE -> createEdgeOptions();
        };
    }

    private static ChromeOptions createChromeOptions() {

        ChromeOptions options = new ChromeOptions();

        if (ConfigManager.isHeadless()) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1920,1080");

        return options;
    }

    private static FirefoxOptions createFirefoxOptions() {

        FirefoxOptions options = new FirefoxOptions();

        if (ConfigManager.isHeadless()) {
            options.addArguments("-headless");
        }

        return options;
    }

    private static EdgeOptions createEdgeOptions() {

        EdgeOptions options = new EdgeOptions();

        if (ConfigManager.isHeadless()) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1920,1080");

        return options;
    }
}