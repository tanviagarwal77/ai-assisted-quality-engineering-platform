package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By checkoutTitle =
            By.cssSelector("[data-test='title']");

    private final By finishButton =
            By.cssSelector("[data-test='finish']");

    public CheckoutOverviewPage(
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

    public OrderConfirmationPage finishOrder() {

        waitManager
                .waitForClickable(finishButton)
                .click();

        return new OrderConfirmationPage(
                driver,
                waitManager
        );
    }
}