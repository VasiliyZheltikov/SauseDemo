package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }
}
