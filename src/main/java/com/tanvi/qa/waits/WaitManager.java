package com.tanvi.qa.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tanvi.qa.config.ConfigManager;

public class WaitManager {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitManager(WebDriver driver)
    {
        if(driver==null)
        {
            throw new IllegalArgumentException("Webdriver cannot be null");
        }
    
    this.driver=driver;
    this.wait=new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getExplicitWait()));


    
}
public WebElement waitForVisible(By locator)
{
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

 public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }
      public WebElement waitForPresent(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }
    public boolean waitForInvisible(By locator) {

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
    public boolean waitForTitle(String title) {

        return wait.until(
                ExpectedConditions.titleIs(title)
        );
    }

}