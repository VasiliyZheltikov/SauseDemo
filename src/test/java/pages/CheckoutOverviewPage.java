package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By ITEM_NAME = By.className("inventory_item_name");
    private final By ITEM_PRICE = By.className("inventory_item_price");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-step-two.html");
    }

    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public void finish() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
