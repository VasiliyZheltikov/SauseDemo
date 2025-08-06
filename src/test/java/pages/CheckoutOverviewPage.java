package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By ITEM_NAME = By.className("inventory_item_name");
    private final By ITEM_PRICE = By.className("inventory_item_price");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие окна подтверждения заказа")
    @Override
    public CheckoutOverviewPage open() { // Loadable Page, Chain of invocations
        driver.get(BASE_URL + "checkout-step-two.html");
        return this;
    }

    @Step("Нахождение наименования товара на странице подтверждения заказа")
    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Нахождение цены товара на странице подтверждения заказа")
    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Нажатие кнопки оформления заказа")
    public CheckoutCompletePage finish() { // Chain of invocations
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
