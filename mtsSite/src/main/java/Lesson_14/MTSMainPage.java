package Lesson_14;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MTSMainPage {
    public WebDriver driver;

    public MTSMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div.cookie.show button.cookie__cancel")
    private WebElement cookieCancelBtn;

    @FindBy(css = "section.pay input#connection-phone")
    private WebElement connectionPhone;

    @FindBy(css = "section.pay input#connection-sum")
    private WebElement connectionSum;

    @FindBy(css = "section.pay input#connection-email")
    private WebElement connectionEmail;

    @FindBy(css = "section.pay input#internet-phone")
    private WebElement internetPhone;

    @FindBy(css = "section.pay input#internet-sum")
    private WebElement internetSum;

    @FindBy(css = "section.pay input#internet-email")
    private WebElement internetEmail;

    @FindBy(css = "section.pay input#score-instalment")
    private WebElement instalmentScore;

    @FindBy(css = "section.pay input#instalment-sum")
    private WebElement instalmentSum;

    @FindBy(css = "section.pay input#instalment-email")
    private WebElement instalmentEmail;

    @FindBy(css = "section.pay input#score-arrears")
    private WebElement arrearsScore;

    @FindBy(css = "section.pay input#arrears-sum")
    private WebElement arrearsSum;

    @FindBy(css = "section.pay input#arrears-email")
    private WebElement arrearsEmail;

    @FindBy(css = "section.pay button[type='submit']")
    private WebElement payBtn;

    @FindBy(css = "iframe.bepaid-iframe")
    public WebElement payFrame;

    public void clickCookieCancelBtn() {
        cookieCancelBtn.click();
    }

    public String getConnectionPhonePlaceholder() throws NoSuchElementException {
        return connectionPhone.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() throws NoSuchElementException {
        return connectionSum.getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholder() throws NoSuchElementException {
        return connectionEmail.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() throws NoSuchElementException {
        return internetPhone.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() throws NoSuchElementException {
        return internetSum.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() throws NoSuchElementException {
        return internetEmail.getAttribute("placeholder");
    }

    public String getInstalmentScorePlaceholder() throws NoSuchElementException {
        return instalmentScore.getAttribute("placeholder");
    }

    public String getInstalmentSumPlaceholder() throws NoSuchElementException {
        return instalmentSum.getAttribute("placeholder");
    }

    public String getInstalmentEmailPlaceholder() throws NoSuchElementException {
        return instalmentEmail.getAttribute("placeholder");
    }

    public String getArrearsScorePlaceholder() throws NoSuchElementException {
        return arrearsScore.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholder() throws NoSuchElementException {
        return arrearsSum.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholder() throws NoSuchElementException {
        return arrearsEmail.getAttribute("placeholder");
    }

    public void setConnectionPhone(String phoneNumber) throws NoSuchElementException {
        connectionPhone.sendKeys(phoneNumber);
    }

    public void setСonnectionSum(String sum) throws NoSuchElementException {
        connectionSum.sendKeys(sum);
    }

    public void clickPayBtn() throws NoSuchElementException {
        payBtn.click();
    }
}
