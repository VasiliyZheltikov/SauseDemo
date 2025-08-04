package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "Test", "Test", "12345"}
        };
    }

    @Test(description = "Проверка оформления заказа",
            testName = "Проверка правильности оформления заказа",
            groups = {"smoke"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Checkout Your Information Page")
    @Feature("Verify Order")
    @Story("Verifying Order")
    @TmsLink("ITM-4")
    @Issue("ITM-4-2")
    @Description("Проверка добавленных в заказ товаров и их цен")
    public void checkoutTest(String username, String password,
                             String firstName, String lastName, String postalCode) {
        loginPage.open()
                        .login(username, password)
                        .addItemToCart()
                        .moveToCart();
        String itemName = cartPage.getItemName();
        String itemPrice = cartPage.getItemPrice();
        cartPage.checkout()
                .login(firstName, lastName, postalCode);
        softAssert.assertEquals(checkoutOverviewPage.getItemName(),
                itemName,
                "Неверное название товара");
        softAssert.assertEquals(checkoutOverviewPage.getItemPrice(),
                itemPrice,
                "Неверная цена товара");
        softAssert.assertAll();
    }
}
