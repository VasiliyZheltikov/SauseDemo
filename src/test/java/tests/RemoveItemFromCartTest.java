package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(description = "Проверка удаления товара из корзины",
            testName = "Удаление товара из корзины",
            groups = {"regression"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Cart Page")
    @Feature("Remove item from cart")
    @Story("Deleting item from cart")
    @TmsLink("ITM-4")
    @Issue("ITM-4-1-8")
    @Description("Проверка удаления товара из корзины")
    public void removeItemFromCartTest(String username, String password) {
        loginPage.open()
                 .login(username, password)
                 .addItemToCart()
                 .moveToCart()
                 .removeItemFromCart();
        Assert.assertFalse(cartPage.ItemIsDisplaying(),
                "Товар не удалён");
    }
}
