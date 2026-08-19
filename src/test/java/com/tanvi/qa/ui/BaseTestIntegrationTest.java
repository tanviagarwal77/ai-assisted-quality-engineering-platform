package com.tanvi.qa.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tanvi.qa.base.BaseTest;


public class BaseTestIntegrationTest extends BaseTest{

    @Test
    public void shouldInitializeDriverThroughBaseTest() {

        Assert.assertNotNull(
                getDriver(),
                "Driver should be initialized by BaseTest"
        );
    }

    @Test
public void shouldNavigateToTestPage() {

    getDriver().get("https://example.com");

    Assert.assertEquals(
            getDriver().getTitle(),
            "Example Domain",
            "Page title should match expected title"
    );
}
    
}
