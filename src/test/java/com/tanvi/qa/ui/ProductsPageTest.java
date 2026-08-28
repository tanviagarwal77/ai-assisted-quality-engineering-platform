package com.tanvi.qa.ui;

import com.tanvi.qa.base.BaseTest;
import com.tanvi.qa.pages.LoginPage;
import com.tanvi.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    @Test
    public void shouldDisplayProductCatalogAfterLogin() {

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

        Assert.assertTrue(
                productsPage.isDisplayed(),
                "Products page should be displayed"
        );

        Assert.assertTrue(
                productsPage.isProductCatalogDisplayed(),
                "Product catalog should be displayed"
        );

        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "Products page title should be correct"
        );
    }
}