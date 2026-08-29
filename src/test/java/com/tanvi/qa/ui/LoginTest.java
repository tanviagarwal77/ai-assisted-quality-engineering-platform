package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.pages.ProductsPage;
import com.tanvi.qa.utilities.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String LOGIN_DATA =
            "testdata/login-data.properties";

    @Test
    public void shouldLoginSuccessfully() {

        LoginPage loginPage =
                new LoginPage(
                        getDriver(),
                        getWaitManager()
                );

        loginPage.open();

        ProductsPage productsPage =
                loginPage
                        .enterUsername(
                                TestDataReader.get(
                                        LOGIN_DATA,
                                        "username"
                                )
                        )
                        .enterPassword(
                                TestDataReader.get(
                                        LOGIN_DATA,
                                        "password"
                                )
                        )
                        .clickLogin();

        Assert.assertTrue(
                productsPage.isDisplayed(),
                "Products page should be displayed after successful login"
        );
    }
}