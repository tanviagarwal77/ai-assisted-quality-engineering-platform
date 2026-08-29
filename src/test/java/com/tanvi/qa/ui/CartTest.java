package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void shouldAddProductToCart() {

        LoginPage loginPage =
                new LoginPage(
                        getDriver(),
                        getWaitManager()
                );

        loginPage.open();

        ProductsPage productsPage =
                loginPage
                        .enterUsername("standard_user")
                        .enterPassword("secret_sauce")
                        .clickLogin();

        productsPage.addProductToCart(
                "Sauce Labs Backpack"
        );

        Assert.assertEquals(
                productsPage.getCartItemCount(),
                "1",
                "Cart should contain one product"
        );
    }
}