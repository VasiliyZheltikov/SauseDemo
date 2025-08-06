package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта SauseDemo")
    @Override
    public LoginPage open() { // Loadable Page, Chain of invocations
        log.info("Opening LoginPage");
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вход в систему с именем пользователя {user} и паролем {password}")
    public ProductsPage login(String user, String password) { // Chain of invocations
        log.info("Log in LoginPage");
        log.info("Filling Login field: {}", user);
        driver.findElement(LOGIN_FIELD).sendKeys(user); // заполнение Username
        log.info("Login field has been successfully filled");
        log.info("Filling Password field {}", password);
        driver.findElement(PASSWORD_FIELD).sendKeys(password); // заполнение Password
        log.info("Password field has been successfully filled");
        log.info("Clicking on the Login button...");
//        clickJS(driver.findElement(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Login button has been successfully clicked");
        return new ProductsPage(driver);
    }

    @Step("Получение текста ошибки авторизации в системе")
    public String getErrorMessage() {
        log.info("Getting error message (wrong auth data)");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
