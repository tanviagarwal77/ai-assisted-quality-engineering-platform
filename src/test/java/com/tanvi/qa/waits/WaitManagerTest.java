package com.tanvi.qa.waits;

import com.tanvi.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitManagerTest extends BaseTest {

    @Test
    public void shouldWaitForVisibleElement() {

        getDriver().get("https://example.com");

        WaitManager waitManager =
                new WaitManager(getDriver());

        Assert.assertNotNull(
                waitManager.waitForVisible(
                        By.tagName("h1")
                ),
                "Heading should become visible"
        );
    }

    @Test
    public void shouldWaitForPageTitle() {

        getDriver().get("https://example.com");

        WaitManager waitManager =
                new WaitManager(getDriver());

        Assert.assertTrue(
                waitManager.waitForTitle("Example Domain"),
                "Expected page title should be present"
        );
    }
}