package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By COMPLETE_NOTICE = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы оформления заказа")
    @Override
    public CheckoutCompletePage open() {
        driver.get(BASE_URL + "checkout-complete.html");
        return this;
    }

    @Step("Нахождение текста уведомления об успешном оформлении заказа")
    public String getNotice() {
        return driver.findElement(COMPLETE_NOTICE).getText();
    }
}
