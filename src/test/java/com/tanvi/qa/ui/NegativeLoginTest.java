package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.utilities.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NegativeLoginTest extends BaseTest {

    private static final String LOGIN_DATA =
            "testdata/login-data.properties";

    private static final String NEGATIVE_DATA =
            "testdata/negative-login-data.properties";

    @Test
    public void shouldRejectInvalidUsername() {

        LoginPage loginPage =
                new LoginPage(
                        getDriver(),
                        getWaitManager()
                );

        loginPage.open();

        loginPage
                .enterUsername(
                        TestDataReader.get(
                                NEGATIVE_DATA,
                                "invalidUsername"
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
                loginPage.isErrorDisplayed(),
                "Error message should be displayed for invalid username"
        );
    }

    @Test
    public void shouldRejectInvalidPassword() {

        LoginPage loginPage =
                new LoginPage(
                        getDriver(),
                        getWaitManager()
                );

        loginPage.open();

        loginPage
                .enterUsername(
                        TestDataReader.get(
                                LOGIN_DATA,
                                "username"
                        )
                )
                .enterPassword(
                        TestDataReader.get(
                                NEGATIVE_DATA,
                                "invalidPassword"
                        )
                )
                .clickLogin();

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message should be displayed for invalid password"
        );
    }
    @DataProvider(name = "emptyLoginData")
public Object[][] emptyLoginData() {

    return new Object[][] {
            {
                    "",
                    TestDataReader.get(
                            LOGIN_DATA,
                            "password"
                    )
            },
            {
                    TestDataReader.get(
                            LOGIN_DATA,
                            "username"
                    ),
                    ""
            },
            {
                    "",
                    ""
            }
    };
}@Test(dataProvider = "emptyLoginData")
public void shouldRejectEmptyCredentials(
        String username,
        String password) {

    LoginPage loginPage =
            new LoginPage(
                    getDriver(),
                    getWaitManager()
            );

    loginPage.open();

    loginPage
            .enterUsername(username)
            .enterPassword(password)
            .clickLogin();

    Assert.assertTrue(
            loginPage.isErrorDisplayed(),
            "Error message should be displayed for empty credentials"
    );
}
}