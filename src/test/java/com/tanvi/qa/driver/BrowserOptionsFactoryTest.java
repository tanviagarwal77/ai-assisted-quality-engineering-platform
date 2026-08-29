package com.tanvi.qa.driver;

import com.tanvi.qa.enums.BrowserType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserOptionsFactoryTest {

    @Test
    public void shouldCreateChromeOptions() {

        Object options =
                BrowserOptionsFactory.createOptions(
                        BrowserType.CHROME
                );

        Assert.assertTrue(
                options instanceof ChromeOptions,
                "Chrome browser should use ChromeOptions"
        );
    }

    @Test
    public void shouldCreateFirefoxOptions() {

        Object options =
                BrowserOptionsFactory.createOptions(
                        BrowserType.FIREFOX
                );

        Assert.assertTrue(
                options instanceof FirefoxOptions,
                "Firefox browser should use FirefoxOptions"
        );
    }

    @Test
    public void shouldCreateEdgeOptions() {

        Object options =
                BrowserOptionsFactory.createOptions(
                        BrowserType.EDGE
                );

        Assert.assertTrue(
                options instanceof EdgeOptions,
                "Edge browser should use EdgeOptions"
        );
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp =
                    "Browser type cannot be null"
    )
    public void shouldRejectNullBrowserType() {

        BrowserOptionsFactory.createOptions(null);
    }
    @Test
public void shouldConfigureChromeForHeadlessExecution() {

    ChromeOptions options =
            (ChromeOptions) BrowserOptionsFactory.createOptions(
                    BrowserType.CHROME
            );

    Assert.assertTrue(
            options.asMap().toString().contains("--headless=new"),
            "ChromeOptions should contain the headless argument"
    );
}
}