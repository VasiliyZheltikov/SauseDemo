package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final By CART = By.className("shopping_cart_link");
    private final By ITEMS_PRICES = By.className("inventory_item_price");
    private final By SORTER = By.className("product_sort_container");
    private final By SORTER_VALUE_PRICE_LOW_TO_HIGH = By.xpath("//option[@value='lohi']");

    private By itemAddingToCartIcon = By.id("add-to-cart-sauce-labs-bike-light");
    private By itemName = By.xpath("(//div[@class='inventory_item_name '])[2]");
    private By itemPrice = By.xpath("(//div[@class='inventory_item_price'])[2]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getItemName() {
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

    public Collection<String> getItemsPrices() {
        Collection<WebElement> pricesList = driver.findElements(ITEMS_PRICES);
        Collection<String> prices = new ArrayList<>();
        for (WebElement price : pricesList) {
            String value = price.getText();
            prices.add(value);
        }
        return prices;
    }

    public void sortItemsByPriceFromLowToHigh() {
        driver.findElement(SORTER).click();
        driver.findElement(SORTER_VALUE_PRICE_LOW_TO_HIGH).click();
    }

    public String getSortedItemsPricesLowToHigh() {
        Collection<String> prices = getItemsPrices();
        return prices.stream().sorted().toString();
    }
}
