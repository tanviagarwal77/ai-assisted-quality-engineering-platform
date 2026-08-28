package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By productsTitle =
            By.cssSelector("[data-test='title']");

    private final By inventoryContainer =
            By.id("inventory_container");

    private final By shoppingCartLink =
            By.cssSelector("[data-test='shopping-cart-link']");

    private final By cartBadge =
        By.cssSelector("[data-test='shopping-cart-badge']");        

    public ProductsPage(
            WebDriver driver,
            WaitManager waitManager) {

        super(driver, waitManager);
    }

    public boolean isDisplayed() {

        return waitManager
                .waitForVisible(productsTitle)
                .isDisplayed();
    }

    public String getTitle() {

        return waitManager
                .waitForVisible(productsTitle)
                .getText();
    }

    public boolean isProductCatalogDisplayed() {

        return waitManager
                .waitForVisible(inventoryContainer)
                .isDisplayed();
    }

    public CartPage clickShoppingCart() {

        waitManager
                .waitForClickable(shoppingCartLink)
                .click();

        return new CartPage(driver, waitManager);
    }
    public ProductsPage addProductToCart(String productName) {

    By addToCartButton = By.xpath(
            "//div[@data-test='inventory-item']" +
            "[.//div[@data-test='inventory-item-name'" +
            " and normalize-space()=\"" + productName + "\"]]" +
            "//button[contains(@data-test,'add-to-cart')]"
    );

    waitManager
            .waitForClickable(addToCartButton)
            .click();

    return this;
}
public String getCartItemCount() {

    return waitManager
            .waitForVisible(cartBadge)
            .getText();
}
}