package Lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PayFrame {

    public WebDriver driver;

    public PayFrame(WebDriver driver, WebElement frameLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname=creditCard] + label")));
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div.pay-description__cost span:nth-child(1)")
    private WebElement payFrameDescriptionCost;

    @FindBy(css = "div.card-page__card button")
    private WebElement payFrameBtn;

    @FindBy(css = "div.pay-description__text span:nth-child(1)")
    private WebElement payFrameDescriptionPhone;

    @FindBy(css = "div.cards-brands img")
    private List<WebElement> payImgages;

    @FindBy(css = "input[formcontrolname=creditCard] + label")
    private WebElement creditCardPlaceholder;

    @FindBy(css = "input[formcontrolname=expirationDate] + label")
    private WebElement expirationDatePlaceholder;

    @FindBy(css = "input[formcontrolname=cvc] + label")
    private WebElement cvcPlaceholder;

    @FindBy(css = "input[formcontrolname=holder] + label")
    private WebElement cardHolderPlaceholder;

    public String getPayFrameDescriptionCost() throws NoSuchElementException {
        return payFrameDescriptionCost.getText();
    }

    public String getPayFrameBtnText() throws NoSuchElementException {
        return payFrameBtn.getText();
    }

    public String getPayFrameDescriptionPhone() throws NoSuchElementException {
        return payFrameDescriptionPhone.getText();
    }

    public boolean isDisplayedImg(String scr) throws NoSuchElementException {
        for (WebElement payImage : payImgages) {
            if (payImage.getAttribute("src").contains(scr)) {
                return payImage.isDisplayed() || payImage.getAttribute("style").contains("opacity: 0") ;
            }
        }
        return false;
    }

    public String getCreditCardPlaceholder() throws NoSuchElementException {
        return creditCardPlaceholder.getText();
    }

    public String getExpirationDatePlaceholder() throws NoSuchElementException {
        return expirationDatePlaceholder.getText();
    }

    public String getCvcPlaceholder() throws NoSuchElementException {
        return cvcPlaceholder.getText();
    }

    public String getCardHolderPlaceholder() throws NoSuchElementException {
        return cardHolderPlaceholder.getText();
    }
}