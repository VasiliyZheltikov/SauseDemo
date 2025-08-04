package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FinishOrderTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "Test", "Test", "12345"}
        };
    }

    @Test(description = "Проверка успешного оформления заказа",
            testName = "Завершение оформления заказа",
            groups = {"smoke"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Checkout Complete Page")
    @Feature("Finish Order")
    @Story("Finishing Order")
    @TmsLink("ITM-4")
    @Issue("ITM-4-3")
    @Description("Проверка успешного оформления заказа")
    public void finishOrderTest(String username, String password,
                                String firstName, String lastName, String postalCode) {
        loginPage.open()
                 .login(username, password)
                 .addItemToCart()
                 .moveToCart()
                 .checkout()
                 .login(firstName, lastName, postalCode)
                 .finish();
        Assert.assertEquals(checkoutCompletePage.getNotice(),
                "Thank you for your order!",
                "Текст уведомления отличается");
    }
}
