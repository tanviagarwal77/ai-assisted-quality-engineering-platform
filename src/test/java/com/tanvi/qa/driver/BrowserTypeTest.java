package com.tanvi.qa.driver;

import com.tanvi.qa.enums.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTypeTest {

    @Test
    public void shouldConvertChromeToBrowserType() {

        Assert.assertEquals(
                BrowserType.fromString("chrome"),
                BrowserType.CHROME
        );
    }

    @Test
    public void shouldConvertFirefoxToBrowserType() {

        Assert.assertEquals(
                BrowserType.fromString("firefox"),
                BrowserType.FIREFOX
        );
    }

    @Test
    public void shouldConvertEdgeToBrowserType() {

        Assert.assertEquals(
                BrowserType.fromString("edge"),
                BrowserType.EDGE
        );
    }

    @Test
    public void shouldHandleBrowserNameCaseInsensitively() {

        Assert.assertEquals(
                BrowserType.fromString("CHROME"),
                BrowserType.CHROME
        );

        Assert.assertEquals(
                BrowserType.fromString("FiReFoX"),
                BrowserType.FIREFOX
        );
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class
    )
    public void shouldRejectUnsupportedBrowser() {

        BrowserType.fromString("safari");
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class
    )
    public void shouldRejectNullBrowser() {

        BrowserType.fromString(null);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class
    )
    public void shouldRejectBlankBrowser() {

        BrowserType.fromString(" ");
    }
}