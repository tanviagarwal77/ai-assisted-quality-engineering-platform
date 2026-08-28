package com.tanvi.qa.driver;

import com.tanvi.qa.enums.BrowserType;
import org.testng.annotations.Test;

public class DriverFactoryTest {

    @Test
    public void shouldAcceptChromeBrowserType() {

        DriverFactory.validateBrowserType(
                BrowserType.CHROME
        );
    }

    @Test
    public void shouldAcceptFirefoxBrowserType() {

        DriverFactory.validateBrowserType(
                BrowserType.FIREFOX
        );
    }

    @Test
    public void shouldAcceptEdgeBrowserType() {

        DriverFactory.validateBrowserType(
                BrowserType.EDGE
        );
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp =
                    "Browser type cannot be null"
    )
    public void shouldRejectNullBrowserType() {

        DriverFactory.validateBrowserType(null);
    }
}