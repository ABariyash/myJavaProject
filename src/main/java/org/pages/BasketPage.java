package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {

    public BasketPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'list-item__wrap')]//span[contains(@class, 'good-info__good-name')]")
    private List<WebElement> productNames;

    @FindBy(xpath = "//input[@type='number']")
    private List<WebElement> productQuantities;

    @FindBy(xpath = "//div[contains(@class, 'list-item__price')]//div[contains(@class, 'list-item__price-wallet red-price')]")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[contains(@class, 'list-item__price')]//div[contains(@class, 'list-item__price-new wallet')]")
    private List<WebElement> productPricesNoDiscount;

    @FindBy(xpath = "//p[@class='b-top__total line']//span[@data-link]")
    private WebElement totalPrice;


    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement product : productNames) {
            names.add(product.getText());
        }
        return names;
    }

    public List<Integer> getProductQuantities() {
        List<Integer> quantities = new ArrayList<>();
        for (WebElement quantity : productQuantities) {
            quantities.add(Integer.parseInt(quantity.getDomProperty("value")));
        }
        return quantities;
    }

    public List<Integer> getProductPrices() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement price : productPrices) {
            prices.add(Integer.parseInt(price.getText().replaceAll("[^0-9]", "")));
        }
        return prices;
    }

    public List<Integer> getProductPricesNoDiscount() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement price : productPricesNoDiscount) {
            prices.add(Integer.parseInt(price.getText().replaceAll("[^0-9]", "")));
        }
        return prices;
    }

    public Integer getTotalPrice() {
        return Integer.parseInt(totalPrice.getText().replaceAll("[^0-9]", ""));
    }
}
