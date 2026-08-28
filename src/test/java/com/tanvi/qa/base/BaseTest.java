package com.tanvi.qa.base;

import com.tanvi.qa.config.ConfigManager;
import com.tanvi.qa.driver.DriverFactory;
import com.tanvi.qa.driver.DriverManager;
import com.tanvi.qa.enums.BrowserType;
import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WaitManager waitManager;

    @BeforeMethod
    public void setUp() {

        String browserName = ConfigManager.getBrowser();

        BrowserType browserType =
                BrowserType.fromString(browserName);

        WebDriver driver =
                DriverFactory.createDriver(browserType);

        DriverManager.setDriver(driver);

        configureTimeouts(driver);

        waitManager = new WaitManager(driver);
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected WaitManager getWaitManager() {
        return waitManager;
    }

    private void configureTimeouts(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        ConfigManager.getImplicitWait()
                )
        );

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(
                        ConfigManager.getPageLoadTimeout()
                )
        );

        driver.manage().timeouts().scriptTimeout(
                Duration.ofSeconds(
                        ConfigManager.getScriptTimeout()
                )
        );
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}