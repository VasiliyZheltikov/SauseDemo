package pages;

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
    private final By ITEM_NAME_IN_ITEM_CARD = By.cssSelector(".inventory_details_name.large_size");

    private By itemAddingToCartIcon = By.id("add-to-cart-sauce-labs-bike-light");
    private By itemName = By.xpath("(//div[@class='inventory_item_name '])[2]");
    private By itemPrice = By.xpath("(//div[@class='inventory_item_price'])[2]");
    private By itemImage = By.xpath("(//div[@class='inventory_item_img'])[2]");
    private By itemImageInItemCard = By.xpath("//img[@alt='Sauce Labs Bike Light']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getItemNameOnProductsPage() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public void addItemToCart() {
        driver.findElement(itemAddingToCartIcon).click();
    }

    public void moveToCart() {
        driver.findElement(CART).click();
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public Collection<Double> getItemsPrices() {
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> prices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            prices.add(Double.valueOf(value));
        }
        return prices;
    }

    public void sortItemsByPriceFromLowToHigh() {
        driver.findElement(SORTER).click();
        driver.findElement(SORTER_VALUE_PRICE_LOW_TO_HIGH).click();
    }

    public Collection<Double> getSortedItemsPricesLowToHigh() {
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<Double> sortedPrices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String value = price.getText().substring(1);
            sortedPrices.add(Double.valueOf(value));
        }
        return sortedPrices.stream().sorted().toList();
    }

    public void openItemCardByName() {
        driver.findElement(itemName).click();
    }

    public void openItemCardByImage() {
        driver.findElement(itemImage).click();
    }

    public String getItemNameInItemCard() {
        return driver.findElement(ITEM_NAME_IN_ITEM_CARD).getText();
    }

    public boolean getItemImageInItemCard() {
        return driver.findElement(itemImageInItemCard).isDisplayed();
    }
}
