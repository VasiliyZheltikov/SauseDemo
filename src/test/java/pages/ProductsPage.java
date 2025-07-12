package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final By CART = By.className("shopping_cart_link");
    private final By ITEMS_PRICES = By.className("inventory_item_price");
    private final By SORTER = By.className("product_sort_container");
    private final By SORTER_VALUE_PRICE_LOW_TO_HIGH = By.xpath("//option[@value='lohi']");
    private final By ITEM_NAME_IN_ITEM_CARD = By.cssSelector("[class~=inventory_details_name]");
    private final By ITEM_IMAGE_IN_ITEM_CARD = By.className("inventory_details_img");

    private By itemAddingToCartIcon = By.id("add-to-cart-sauce-labs-bike-light");
    private By itemName = By.xpath("(//div[@class='inventory_item_name '])[2]");
    private By itemPrice = By.xpath("(//div[@class='inventory_item_price'])[2]");
    private By itemImage = By.xpath("(//div[@class='inventory_item_img'])[2]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы с товарами")
    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Нахождение наименования товара на странице товаров")
    public String getItemNameOnProductsPage() {
        return driver.findElement(itemName).getText();
    }

    @Step("Нахождение цены товара на странице товара")
    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    @Step("Добавление товара в корзину")
    public void addItemToCart() {
        driver.findElement(itemAddingToCartIcon).click();
    }

    @Step("Переход в корзину")
    public void moveToCart() {
        driver.findElement(CART).click();
    }

    @Step("Проверка открытия страницы с товарами")
    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Нахождение всех цен товаров на странице с товарами")
    public Collection<Double> getItemsPrices() {
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> prices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            prices.add(Double.valueOf(value));
        }
        return prices;
    }

    @Step("Выбор значения сортировщика цен - по возрастанию")
    public void sortItemsByPriceFromLowToHigh() {
        driver.findElement(SORTER).click();
        driver.findElement(SORTER_VALUE_PRICE_LOW_TO_HIGH).click();
    }

    @Step("Сортировка найденных цен товаров по возрастанию")
    public Collection<Double> getSortedItemsPricesLowToHigh() {
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> sortedPrices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            sortedPrices.add(Double.valueOf(value));
        }
        return sortedPrices.stream().sorted().toList();
    }
    @Step("Открытие карточки товара кликом на название товара")
    public void openItemCardByName() {
        driver.findElement(itemName).click();
    }

    @Step("Открытие карточки товара кликом на изображение товара")
    public void openItemCardByImage() {
        driver.findElement(itemImage).click();
    }

    @Step("Нахождение названия товара в карточке товара")
    public String getItemNameInItemCard() {
        return driver.findElement(ITEM_NAME_IN_ITEM_CARD).getText();
    }

    @Step("Определение открытого изображение в карточке товара")
    public WebElement getItemImageInItemCard() {
        return driver.findElement(ITEM_IMAGE_IN_ITEM_CARD);
    }
}
