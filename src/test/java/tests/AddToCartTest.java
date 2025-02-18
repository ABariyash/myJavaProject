package tests;

import org.objects.ProductCard;
import org.pages.BasketPage;
import org.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utils.WebDriverSingleton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AddToCartTest {
    private MainPage mainPage;
    private BasketPage basketPage;

    @BeforeClass
    public void setUp() {
        mainPage = new MainPage();
        basketPage = new BasketPage();
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        mainPage.open("https://www.wildberries.ru/");
        int countProducts = 3;

        List<ProductCard> productCards = mainPage.addFirstProductsToCart(countProducts);

        mainPage.clickBasket();
        Thread.sleep(3000);

        List<String> titlesAddedProducts = new ArrayList<>();
        for (ProductCard card : productCards) {
            titlesAddedProducts.add(card.getName());
        }

        List<Integer> pricesAddedProducts = new ArrayList<>();
        for (ProductCard card : productCards) {
            pricesAddedProducts.add(card.getPrice());
        }

        List<String> titlesProductsInBasket = basketPage.getProductNames();
        List<Integer> pricesProductsInBasket = basketPage.getProductPrices();
        List<Integer> pricesProductsInBasketNoDiscount = basketPage.getProductPricesNoDiscount();
        Integer totalPriceInBasket = basketPage.getTotalPrice();

        Assert.assertEquals(new HashSet<>(titlesProductsInBasket), new HashSet<>(titlesAddedProducts), "Названия товаров не совпадает");
        Assert.assertEquals(countProducts, (int) basketPage.getProductQuantities().stream().reduce(0, Integer::sum), "Количество товаров не совпадает");
        Assert.assertEquals(new HashSet<>(pricesProductsInBasket), new HashSet<>(pricesAddedProducts), "Цены товаров не совпадает");
        Assert.assertEquals(totalPriceInBasket, pricesProductsInBasketNoDiscount.stream().reduce(0, Integer::sum), "Сумма товаров не совпадает");
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
