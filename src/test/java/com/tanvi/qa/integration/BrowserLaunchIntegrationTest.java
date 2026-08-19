package com.tanvi.qa.integration;

import com.tanvi.qa.config.ConfigManager;
import com.tanvi.qa.driver.DriverFactory;
import com.tanvi.qa.driver.DriverManager;
import com.tanvi.qa.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BrowserLaunchIntegrationTest {

    @Test
    public void shouldLaunchConfiguredBrowser() {

        String browserName = ConfigManager.getBrowser();

        BrowserType browserType =
                BrowserType.fromString(browserName);

        WebDriver driver =
                DriverFactory.createDriver(browserType);

        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(
        ConfigManager.get("integration.test.url")
);

        Assert.assertNotNull(
                DriverManager.getDriver().getTitle(),
                "Page title should not be null"
        );
    }

    @AfterMethod
    public void cleanup() {

        DriverManager.quitDriver();
    }
}