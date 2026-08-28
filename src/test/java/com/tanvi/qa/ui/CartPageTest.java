package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.CartPage;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void shouldDisplayAddedProductInCart() {

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

        CartPage cartPage =
                productsPage.clickShoppingCart();

        Assert.assertTrue(
                cartPage.isDisplayed(),
                "Cart page should be displayed"
        );

        Assert.assertEquals(
                cartPage.getTitle(),
                "Your Cart",
                "Cart page title should be correct"
        );

        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack",
                "Expected product should be present in cart"
        );

        Assert.assertEquals(
                cartPage.getProductQuantity(),
                "1",
                "Product quantity should be one"
        );

        Assert.assertEquals(
                cartPage.getProductPrice(),
                "$29.99",
                "Product price should be correct"
        );
    }
}