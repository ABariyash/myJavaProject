package tests;

import factory.DriverFactory;
import io.qameta.allure.*;
import listeners.AllureListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Listeners(AllureListener.class)
@Epic("Калькулятор")
@Feature("Арифметические операции")
public class CalculatorTest {
    private WebDriver driver;

    @BeforeClass
    @Step("Настройка драйвера")
    public void setup() throws MalformedURLException {
        driver = DriverFactory.initDriver();
    }

    @Test
    @Story("Сложение")
    @Description("Проверка операции сложения 5 + 3")
    public void testAddition() {
        clickById("digit_5");
        clickById("op_add");
        clickById("digit_3");
        clickById("eq");

        String result = getResult();
        Assert.assertEquals(result, "8", "Ошибка в сложении!");
    }

    @Step("Нажатие на кнопку {id}")
    private void clickById(String id) {
        driver.findElement(By.id("com.google.android.calculator:id/" + id)).click();
    }

    @Step("Получение результата")
    private String getResult() {
        return driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
