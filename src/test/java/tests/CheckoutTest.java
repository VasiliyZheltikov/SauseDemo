package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Проверка оформления заказа",
            testName = "Проверка правильности оформления заказа",
            groups = {"smoke"})
    public void checkoutTest() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        productsPage.addItemToCart();
        productsPage.moveToCart();
        String itemName = cartPage.getItemName();
        String itemPrice = cartPage.getItemPrice();
        cartPage.checkout();
        checkoutYourInformationPage.login();
        softAssert.assertEquals(checkoutOverviewPage.getItemName(),
                itemName,
                "Неверное название товара");
        softAssert.assertEquals(checkoutOverviewPage.getItemPrice(),
                itemPrice,
                "Неверная цена товара");
        softAssert.assertAll();
    }
}
