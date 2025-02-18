package lesson_14;

import Lesson_14.MTSMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MTSPaySectionTest {

    public static WebDriver driver;
    public static MTSMainPage mtsMainPage;
    public static String PAGE_URL = "https://mts.by";

    @BeforeAll
    static void before() {
        driver = new ChromeDriver();
        mtsMainPage = new MTSMainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        handleCookiesPopup();
    }

    private static void handleCookiesPopup() {
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

    @ParameterizedTest
    @DisplayName("Тест 1: Проверка плейсхолдеров формы оплаты на главной странице")
    @CsvSource({
            "connection-phone, Номер телефона",
            "connection-sum, Сумма",
            "connection-email, E-mail для отправки чека",
            "internet-phone, Номер абонента",
            "internet-sum, Сумма",
            "internet-email, E-mail для отправки чека",
            "score-instalment, Номер счета на 44",
            "instalment-sum, Сумма",
            "instalment-email, E-mail для отправки чека",
            "score-arrears, Номер счета на 2073",
            "arrears-sum, Сумма",
            "arrears-email, E-mail для отправки чека"
    })
    public void checkPlaceholders(String id, String expectedPlaceholder) {
        try {
            String actualPlaceholder = "";
            switch (id) {
                case ("connection-phone"):
                    actualPlaceholder = mtsMainPage.getConnectionPhonePlaceholder();
                    break;
                case ("connection-sum"):
                    actualPlaceholder = mtsMainPage.getConnectionSumPlaceholder();
                    break;
                case ("connection-email"):
                    actualPlaceholder = mtsMainPage.getConnectionEmailPlaceholder();
                    break;
                case ("internet-phone"):
                    actualPlaceholder = mtsMainPage.getInternetPhonePlaceholder();
                    break;
                case ("internet-sum"):
                    actualPlaceholder = mtsMainPage.getInternetSumPlaceholder();
                    break;
                case ("internet-email"):
                    actualPlaceholder = mtsMainPage.getInternetEmailPlaceholder();
                    break;
                case ("score-instalment"):
                    actualPlaceholder = mtsMainPage.getInstalmentScorePlaceholder();
                    break;
                case ("instalment-sum"):
                    actualPlaceholder = mtsMainPage.getInstalmentSumPlaceholder();
                    break;
                case ("instalment-email"):
                    actualPlaceholder = mtsMainPage.getInstalmentEmailPlaceholder();
                    break;
                case ("score-arrears"):
                    actualPlaceholder = mtsMainPage.getArrearsScorePlaceholder();
                    break;
                case ("arrears-sum"):
                    actualPlaceholder = mtsMainPage.getArrearsSumPlaceholder();
                    break;
                case ("arrears-email"):
                    actualPlaceholder = mtsMainPage.getArrearsEmailPlaceholder();
                    break;
            }
            assertEquals(actualPlaceholder, expectedPlaceholder, id + " плейсхолдер не соответствует");
            System.out.println(id + " плейсхолдер соответствует");
        } catch (NoSuchElementException e) {
            assertTrue(false, id + " плейсхолдер не найден");
        }
    }

    @AfterAll
    static void after() {
        driver.quit();
    }
}
