package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.CartPage;
import com.tanvi.qa.pages.CheckoutOverviewPage;
import com.tanvi.qa.pages.CheckoutPage;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.pages.OrderConfirmationPage;
import com.tanvi.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tanvi.qa.utilities.TestDataReader;


public class CheckoutTest extends BaseTest {
    private static final String LOGIN_DATA =
        "testdata/login-data.properties";

    @Test
    public void shouldCompleteCheckoutSuccessfully() {

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

        productsPage.addProductToCart(
                "Sauce Labs Backpack"
        );

        CartPage cartPage =
                productsPage.clickShoppingCart();

        CheckoutPage checkoutPage =
                cartPage.clickCheckout();

        Assert.assertTrue(
                checkoutPage.isDisplayed(),
                "Checkout page should be displayed"
        );

        Assert.assertEquals(
                checkoutPage.getTitle(),
                "Checkout: Your Information",
                "Checkout title should be correct"
        );

      CheckoutOverviewPage overviewPage =
        checkoutPage
                .enterFirstName(
                        TestDataReader.get(
                                LOGIN_DATA,
                                "firstName"
                        )
                )
                .enterLastName(
                        TestDataReader.get(
                                LOGIN_DATA,
                                "lastName"
                        )
                )
                .enterPostalCode(
                        TestDataReader.get(
                                LOGIN_DATA,
                                "postalCode"
                        )
                )
                .continueCheckout();

Assert.assertTrue(
        overviewPage.isDisplayed(),
        "Checkout overview page should be displayed"
);

Assert.assertEquals(
        overviewPage.getTitle(),
        "Checkout: Overview",
        "Checkout overview title should be correct"
);

OrderConfirmationPage confirmationPage =
        overviewPage.finishOrder();

        Assert.assertEquals(
                confirmationPage.getConfirmationMessage(),
                "Thank you for your order!",

                "Order confirmation message should be correct"
        );
    }
}