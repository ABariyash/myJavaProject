package org.pages;

import org.objects.ProductCard;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//p[@class = 'product-card__order-wrap']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//ul[contains(@class, 'sizes-list')]//li[contains(@class, 'sizes-list__item')]")
    private List<WebElement> sizeOptions;

    @FindBy(xpath = "//div[contains(@class, 'j-item-basket')]//a")
    private WebElement basketButton;

    public MainPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public List<ProductCard> addFirstProductsToCart(int count) {
        List<ProductCard> productCards = new ArrayList<>();

        waitVisibilityOfAllElements(By.xpath("//p[@class = 'product-card__order-wrap']"));
        for (int i = 0; i < count && i < addToCartButtons.size(); i++) {
            ProductCard productCard = new ProductCard();
            WebElement cartButton = addToCartButtons.get(i);
            cartButton.click();
            try {
                waitVisibilityOfAllElements(By.xpath("//ul[contains(@class, 'sizes-list')]"));
                if (!sizeOptions.isEmpty()) {
                    sizeOptions.get(0).click();
                }
            } catch (TimeoutException e) {
            }
            productCard.setName(cartButton
                    .findElement(By.xpath("./ancestor::div[contains(@class, 'product-card__wrapper')]"))
                    .findElement(By.className("product-card__name"))
                    .getText().substring(2));

            productCard.setPrice(Integer.parseInt(cartButton
                    .findElement(By.xpath("./ancestor::div[contains(@class, 'product-card__wrapper')]"))
                    .findElement(By.xpath(".//ins[contains(@class, 'price__lower-price')]"))
                    .getText().replaceAll("[^0-9]", "")));
            productCards.add(productCard);
        }
        return productCards;
    }

    public void clickBasket() {
        basketButton.click();
    }
}