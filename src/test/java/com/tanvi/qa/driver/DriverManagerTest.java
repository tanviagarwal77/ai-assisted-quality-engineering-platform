package com.tanvi.qa.driver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class DriverManagerTest {

    @AfterMethod
    public void cleanup() {
        DriverManager.quitDriver();
    }

    @Test
    public void shouldStoreAndRetrieveDriver() {

        WebDriver mockDriver = mock(WebDriver.class);

        DriverManager.setDriver(mockDriver);

        WebDriver actualDriver = DriverManager.getDriver();

        Assert.assertSame(
                actualDriver,
                mockDriver,
                "DriverManager should return the same WebDriver instance that was stored"
        );
    }

    @Test(
            expectedExceptions = IllegalStateException.class,
            expectedExceptionsMessageRegExp =
                    "WebDriver has not been initialized"
    )
    public void shouldThrowExceptionWhenDriverIsNotInitialized() {

        DriverManager.getDriver();
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp =
                    "WebDriver cannot be null"
    )
    public void shouldRejectNullDriver() {

        DriverManager.setDriver(null);
    }
}