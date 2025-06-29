package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By ITEM = By.className("cart_item");
    private final By ITEM_NAME = By.className("inventory_item_name");
    private final By ITEM_PRICE = By.className("inventory_item_price");
    private final By REMOVE_BUTTON = By.cssSelector("[class~=cart_button]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public boolean ItemIsDisplaying() {
        try {
            return driver.findElement(ITEM).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public void removeItemFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
    }
}
