package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By ITEM = By.className("cart_item");
    private final By ITEM_NAME = By.className("inventory_item_name");
    private final By ITEM_PRICE = By.className("inventory_item_price");
    private final By REMOVE_BUTTON = By.cssSelector("[class~=cart_button]");
    private final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage open() { // Loadable Page, Chain of invocations
        driver.get(BASE_URL + "cart.html");
        return this;
    }

    public boolean ItemIsDisplaying() {
        try {
            return driver.findElement(ITEM).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Нахождение цены товара в корзине")
    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Нахождение наименования товара в корзине")
    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Удаление товара из корзины")
    public CartPage removeItemFromCart() { // Chain of invocations
        driver.findElement(REMOVE_BUTTON).click();
        return this;
    }

    @Step("Нажатие кнопки Checkout в корзине")
    public CheckoutYourInformationPage checkout() { // Chain of invocations
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutYourInformationPage(driver);
    }
}
