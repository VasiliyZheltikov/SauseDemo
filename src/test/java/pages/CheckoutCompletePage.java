package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutCompletePage extends BasePage {

    private final By COMPLETE_NOTICE = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы оформления заказа")
    @Override
    public CheckoutCompletePage open() { // Loadable Page, Chain of invocations
        log.info("Opening CheckoutCompletePage");
        driver.get(BASE_URL + "checkout-complete.html");
        return this;
    }

    @Step("Нахождение текста уведомления об успешном оформлении заказа")
    public String getNotice() {
        log.info("Getting notice text about successful ordering");
        return driver.findElement(COMPLETE_NOTICE).getText();
    }
}
