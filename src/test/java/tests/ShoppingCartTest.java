package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {user, password}
        };
    }

    @Test(description = "Проверка добавления товара в корзину",
            testName = "Добавление товара в корзину",
            groups = {"smoke"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Cart Page")
    @Feature("Add item to cart")
    @Story("Adding item to cart")
    @TmsLink("ITM-4")
    @Description("Проверка добавления товара в корзину")
    public void checkItemNameAndPrice(String username, String password) { // Chain of invocations
        loginPage.open()
                 .login(username, password)
                 .addItemToCart();
        String itemName = productsPage.getItemNameOnProductsPage();
        String itemPrice = productsPage.getItemPrice();
        productsPage.moveToCart();
        softAssert.assertEquals(itemName,
                cartPage.getItemName(),
                "Название не соответствует");
        softAssert.assertEquals(itemPrice,
                cartPage.getItemPrice(),
                "Цена не соответствует");
        softAssert.assertAll();
    }
}
