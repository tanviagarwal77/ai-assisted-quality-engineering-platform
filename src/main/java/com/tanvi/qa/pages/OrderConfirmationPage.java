package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    private final By confirmationMessage =
            By.cssSelector("[data-test='complete-header']");

  // private final By confirmationContainer =
    //    By.cssSelector(".checkout_complete_container");

    public OrderConfirmationPage(
            WebDriver driver,
            WaitManager waitManager) {

        super(driver, waitManager);
    }

    public boolean isDisplayed() {

    System.out.println("CURRENT URL: " + driver.getCurrentUrl());
    System.out.println("PAGE TITLE: " + driver.getTitle());
    System.out.println("PAGE SOURCE:");
    System.out.println(driver.getPageSource());

    return waitManager
            .waitForVisible(confirmationMessage)
            .isDisplayed();
}

    public String getConfirmationMessage() {

        return waitManager
                .waitForVisible(confirmationMessage)
                .getText();
    }
}