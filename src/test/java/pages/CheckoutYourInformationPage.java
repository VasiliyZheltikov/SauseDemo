package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {

    private final By FIRST_NAME_FIELD = By.id("first-name");
    private final By LAST_NAME_FIELD = By.id("last-name");
    private final By POSTAL_CODE_FIELD = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы проверки заказа")
    @Override
    public CheckoutYourInformationPage open() {
        driver.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    @Step("Авторизация на странице проверки заказа с параметрами: " +
            "First Name = {firstName}, " +
            "Last Name = {lastName}, " +
            "Postal Code = {postalCode}")
    public CheckoutOverviewPage login(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutOverviewPage(driver);
    }
}
