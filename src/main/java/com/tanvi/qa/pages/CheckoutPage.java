package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By checkoutTitle =
            By.cssSelector("[data-test='title']");

    private final By firstNameInput =
            By.cssSelector("[data-test='firstName']");

    private final By lastNameInput =
            By.cssSelector("[data-test='lastName']");

    private final By postalCodeInput =
            By.cssSelector("[data-test='postalCode']");

    private final By continueButton =
            By.cssSelector("[data-test='continue']");

    public CheckoutPage(
            WebDriver driver,
            WaitManager waitManager) {

        super(driver, waitManager);
    }

    public boolean isDisplayed() {

        return waitManager
                .waitForVisible(checkoutTitle)
                .isDisplayed();
    }

    public String getTitle() {

        return waitManager
                .waitForVisible(checkoutTitle)
                .getText();
    }

    public CheckoutPage enterFirstName(String firstName) {

        waitManager
                .waitForVisible(firstNameInput)
                .clear();

        driver.findElement(firstNameInput)
                .sendKeys(firstName);

        return this;
    }

    public CheckoutPage enterLastName(String lastName) {

        waitManager
                .waitForVisible(lastNameInput)
                .clear();

        driver.findElement(lastNameInput)
                .sendKeys(lastName);

        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {

        waitManager
                .waitForVisible(postalCodeInput)
                .clear();

        driver.findElement(postalCodeInput)
                .sendKeys(postalCode);

        return this;
    }

   public CheckoutOverviewPage continueCheckout() {

    waitManager
            .waitForClickable(continueButton)
            .click();

    return new CheckoutOverviewPage(
            driver,
            waitManager
    );
}
}