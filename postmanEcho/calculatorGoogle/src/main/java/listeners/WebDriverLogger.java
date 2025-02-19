package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverLogger implements WebDriverListener {

    @Attachment(value = "Лог действия", type = "text/plain")
    private static String logAction(String message) {
        return message;
    }

    public void beforeClick(WebElement element) {
        logAction("Клик по элементу: " + element.toString());
    }

    public void onError(Object target, Throwable throwable) {
        logAction("Ошибка: " + throwable.getMessage());
    }
}
