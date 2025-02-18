package lesson_13;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MTSOnlinePaymentTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        handleCookiesPopup();
    }

    private void handleCookiesPopup() {
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Принять')]"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
                System.out.println("Cookies popup закрыт.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookies popup не найден, продолжаем тест.");
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']"));
        Assert.assertTrue(blockTitle.isDisplayed(), "Название блока не найдено!");
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));
        Assert.assertFalse(logos.isEmpty(), "Логотипы платежных систем не найдены!");
        for (WebElement logo : logos) {
            Assert.assertTrue(logo.isDisplayed(), "Логотип не виден");
        }
    }

    @Test
    public void testServiceDetailsLink() {
        WebElement detailsLink = driver.findElement(By.xpath("//a[contains(text(),'Подробнее о сервисе')]"));
        Assert.assertTrue(detailsLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' отсутствует!");
        Assert.assertEquals(detailsLink.getTagName(), "a", "Элемент не является ссылкой <a>!");

        String actualHref = detailsLink.getAttribute("href");
        String expectedHrefContains = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey";
        Assert.assertTrue(actualHref.contains(expectedHrefContains), "Ссылка имеет некорректный href: " + actualHref);

        detailsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"), "Ссылка ведет на некорректную страницу!");
        driver.navigate().back();
    }

    @Test
    public void testFormSubmission() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.id("connection-sum"));
        amountInput.clear();
        amountInput.sendKeys("10");

        WebElement submitButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
        WebElement paymentIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app-wrapper']")));
        Assert.assertTrue(paymentIframe.isDisplayed(), "Окно оплаты не появилось!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

