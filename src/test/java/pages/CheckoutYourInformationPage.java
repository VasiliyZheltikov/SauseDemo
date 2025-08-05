package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
    public CheckoutYourInformationPage open() { // Loadable Page, Chain of invocations
        log.info("Opening CheckoutYourInformationPage");
        driver.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    @Step("Авторизация на странице проверки заказа с параметрами: " +
            "First Name = {firstName}, " +
            "Last Name = {lastName}, " +
            "Postal Code = {postalCode}")
    public CheckoutOverviewPage login(String firstName, String lastName, String postalCode) { // Chain of invocations
        log.info("Log in CheckoutOverviewPage");
        log.info("Filling first name field...");
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        log.info("First name has been successfully filled");
        log.info("Filling last name field...");
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        log.info("Last name has been successfully filled");
        log.info("Filling postal code field...");
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(postalCode);
        log.info("Postal code has been successfully filled");
        log.info("Clicking at the Continue button...");
        driver.findElement(CONTINUE_BUTTON).click();
        log.info("Continue button has been successfully clicked");
        return new CheckoutOverviewPage(driver);
    }
}
