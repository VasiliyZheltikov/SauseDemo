package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By COMPLETE_NOTICE = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-complete.html");
    }

    public String getNotice() {
        return driver.findElement(COMPLETE_NOTICE).getText();
    }
}
