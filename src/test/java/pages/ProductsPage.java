package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");
    private final By CART = By.className("shopping_cart_link");
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
}
