package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Opening CheckoutOverviewPage");
        driver.get(BASE_URL + "checkout-step-two.html");
        return this;
    }

    @Step("Нахождение наименования товара на странице подтверждения заказа")
    public String getItemName() {
        log.info("Finding item's name at the CheckoutOverviewPage");
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Нахождение цены товара на странице подтверждения заказа")
    public String getItemPrice() {
        log.info("Finding item's price at the CheckoutOverviewPage");
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Нажатие кнопки оформления заказа")
    public CheckoutCompletePage finish() { // Chain of invocations
        log.info("Clicking at the Finish button at the CheckoutOverviewPage");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
