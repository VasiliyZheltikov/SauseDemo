package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

@Log4j2
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
    @Override
    public ProductsPage open() { // Loadable Page, Chain of invocations
        log.info("Opening ProductsPage");
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    @Step("Нахождение наименования товара на странице товаров")
    public String getItemNameOnProductsPage() {
        log.info("finding item's name at the ProductsPage");
        return driver.findElement(itemName).getText();
    }

    @Step("Нахождение цены товара на странице товара")
    public String getItemPrice() {
        log.info("finding item's price at the ProductsPage");
        return driver.findElement(itemPrice).getText();
    }

    @Step("Добавление товара в корзину")
    public ProductsPage addItemToCart() { // Chain of invocations
        log.info("Adding items to the Cart");
        driver.findElement(itemAddingToCartIcon).click();
        return this;
    }

    @Step("Переход в корзину")
    public CartPage moveToCart() { // Chain of invocations
        log.info("Moving to the CartPage");
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    @Step("Проверка открытия страницы с товарами")
    public boolean isPageOpened() {
        log.info("Checking ProductsPage is opened");
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Нахождение всех цен товаров на странице с товарами")
    public Collection<Double> getItemsPrices() {
        log.info("Finding all items' prices on the ProductPage");
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> prices = new ArrayList<>();
        log.info("Saving items' prices to the pricesList collection");
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            prices.add(Double.valueOf(value));
        }
        return prices;
    }

    @Step("Выбор значения сортировщика цен - по возрастанию")
    public ProductsPage sortItemsByPriceFromLowToHigh() { // Chain of invocations
        log.info("Clicking to the sorter icon");
        driver.findElement(SORTER).click();
        log.info("Choosing sorter value from low to high prices");
        driver.findElement(SORTER_VALUE_PRICE_LOW_TO_HIGH).click();
        return this;
    }

    @Step("Сортировка найденных цен товаров по возрастанию")
    public Collection<Double> getSortedItemsPricesLowToHigh() {
        log.info("Finding all items' prices, sorted from low to high");
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> sortedPrices = new ArrayList<>();
        log.info("Saving all items' prices, sorted from low to high, to the sortedPrices collection");
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            sortedPrices.add(Double.valueOf(value));
        }
        return sortedPrices.stream().sorted().toList();
    }
    @Step("Открытие карточки товара кликом на название товара")
    public void openItemCardByName() {
        log.info("Opening item's card clicking on item's name");
        driver.findElement(itemName).click();
    }

    @Step("Открытие карточки товара кликом на изображение товара")
    public void openItemCardByImage() {
        log.info("Opening item's card clicking on item's picture");
        driver.findElement(itemImage).click();
    }

    @Step("Нахождение названия товара в карточке товара")
    public String getItemNameInItemCard() {
        log.info("Finding item's name at the item's card");
        return driver.findElement(ITEM_NAME_IN_ITEM_CARD).getText();
    }

    @Step("Определение открытого изображение в карточке товара")
    public WebElement getItemImageInItemCard() {
        log.info("Getting item's picture from the item's card");
        return driver.findElement(ITEM_IMAGE_IN_ITEM_CARD);
    }
}
