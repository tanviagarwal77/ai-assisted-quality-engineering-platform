package com.tanvi.qa.pages;

import com.tanvi.qa.config.ConfigManager;
import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WaitManager waitManager;

    protected BasePage(
            WebDriver driver,
            WaitManager waitManager) {

        if (driver == null) {
            throw new IllegalArgumentException(
                    "WebDriver cannot be null"
            );
        }

        if (waitManager == null) {
            throw new IllegalArgumentException(
                    "WaitManager cannot be null"
            );
        }

        this.driver = driver;
        this.waitManager = waitManager;
    }

    public void open() {
        driver.get(ConfigManager.getAutBaseUrl());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}