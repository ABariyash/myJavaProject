package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.WebDriverSingleton;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverSingleton.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected List<WebElement> waitVisibilityOfAllElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void open(String url) {
        driver.get(url);
    }
}