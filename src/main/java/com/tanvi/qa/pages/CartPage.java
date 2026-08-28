package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartTitle =
            By.cssSelector("[data-test='title']");

    private final By cartItem =
            By.cssSelector("[data-test='inventory-item']");

    private final By itemName =
            By.cssSelector("[data-test='inventory-item-name']");

    private final By itemPrice =
            By.cssSelector("[data-test='inventory-item-price']");

    private final By itemQuantity =
            By.cssSelector("[data-test='item-quantity']");

    private final By checkoutButton =
            By.cssSelector("[data-test='checkout']");

    public CartPage(
            WebDriver driver,
            WaitManager waitManager) {

        super(driver, waitManager);
    }

    public boolean isDisplayed() {

        return waitManager
                .waitForVisible(cartTitle)
                .isDisplayed();
    }

    public String getTitle() {

        return waitManager
                .waitForVisible(cartTitle)
                .getText();
    }

    public String getProductName() {

        return waitManager
                .waitForVisible(itemName)
                .getText();
    }

    public String getProductPrice() {

        return waitManager
                .waitForVisible(itemPrice)
                .getText();
    }

    public String getProductQuantity() {

        return waitManager
                .waitForVisible(itemQuantity)
                .getText();
    }

    public CheckoutPage clickCheckout() {

        waitManager
                .waitForClickable(checkoutButton)
                .click();

        return new CheckoutPage(driver, waitManager);
    }
}