package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1,
            description = "Проверка успешной авторизации",
            testName = "Авторизация со стандартным логином и паролем",
            groups = {"smoke"})
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user1", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
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
    public void checkLoginWithNegativeValues(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }

}
