package com.tanvi.qa.pages;

import com.tanvi.qa.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  extends BasePage{


    private final By usernameInput =
            By.id("user-name");

    private final By passwordInput =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    private final By errorMessage =
            By.cssSelector("[data-test='error']");

  public LoginPage(
        WebDriver driver,
        WaitManager waitManager) {

    super(driver, waitManager);
}


    public LoginPage enterUsername(String username) {

        waitManager
                .waitForVisible(usernameInput)
                .clear();

        driver.findElement(usernameInput)
                .sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {

        waitManager
                .waitForVisible(passwordInput)
                .clear();

        driver.findElement(passwordInput)
                .sendKeys(password);

        return this;
    }

    public ProductsPage clickLogin() {

        waitManager
                .waitForClickable(loginButton)
                .click();

        return new ProductsPage(driver, waitManager);
    }

    public String getErrorMessage() {

        return waitManager
                .waitForVisible(errorMessage)
                .getText();
    }
    public boolean isErrorDisplayed() {

    return waitManager
            .waitForVisible(errorMessage)
            .isDisplayed();
}
}