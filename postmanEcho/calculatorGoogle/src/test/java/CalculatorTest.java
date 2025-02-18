import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("automationName", "UiAutomator2");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/"), caps);
    }

    @Test
    public void testAddition() {
        clickById("digit_5");
        clickById("op_add");
        clickById("digit_3");
        clickById("eq");

        String result = getResult();
        Assert.assertEquals(result, "8", "Ошибка в сложении!");
    }

    @Test
    public void testSubtraction() {
        clickById("digit_9");
        clickById("op_sub");
        clickById("digit_4");
        clickById("eq");

        String result = getResult();
        Assert.assertEquals(result, "5", "Ошибка в вычитании!");
    }

    @Test
    public void testMultiplication() {
        clickById("digit_6");
        clickById("op_mul");
        clickById("digit_7");
        clickById("eq");

        String result = getResult();
        Assert.assertEquals(result, "42", "Ошибка в умножении!");
    }

    @Test
    public void testDivision() {
        clickById("digit_8");
        clickById("op_div");
        clickById("digit_2");
        clickById("eq");

        String result = getResult();
        Assert.assertEquals(result, "4", "Ошибка в делении!");
    }

    private void clickById(String id) {
        driver.findElement(By.id("com.google.android.calculator:id/" + id)).click();
    }

    private String getResult() {
        return driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
