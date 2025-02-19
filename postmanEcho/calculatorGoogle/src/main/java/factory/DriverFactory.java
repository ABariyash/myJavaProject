package factory;

import listeners.WebDriverLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability("deviceName", "Android Emulator");
            caps.setCapability("appPackage", "com.google.android.calculator");
            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
            caps.setCapability("automationName", "UiAutomator2");

            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/"), caps);

            WebDriverListener listener = new WebDriverLogger();
            driver = new EventFiringDecorator<>(listener).decorate(driver);

            System.out.println("DRIVER is CREATED and initialized!");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
