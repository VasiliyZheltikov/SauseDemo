package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1,
            description = "Проверка успешной авторизации",
            testName = "Авторизация со стандартным логином и паролем",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Authorization")
    @Story("Log in system")
    @TmsLink("ITM-4")
    @Description("Проверка успешной авторизации в системе")
    public void checkLogin() {
        loginPage.open()
                .login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened(),
                "Ошибка авторизации");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData",
            priority = 2,
            description = "Проверка входа в систему без пароля, без логина, с неверными логином и паролем",
            testName = "Негативные сценарии входа в систему",
            groups = {"regression"},
            dependsOnMethods = {"checkLogin"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Authorization")
    @Story("Log in System")
    @TmsLink("ITM-4")
    @Issue("ITM-4-1-4")
    @Issue("ITM-4-1-5")
    @Issue("ITM-4-1-6")
    @Description("Проверка открытия пользователем карточки товара")
    public void checkLoginWithNegativeValues(String user, String password, String expectedMessage) {
        loginPage.open()
                 .login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }

}
