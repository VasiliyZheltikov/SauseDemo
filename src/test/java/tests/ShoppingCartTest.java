package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void checkItemNameAndPrice() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        productsPage.addItemToCart();
        String itemName = productsPage.getItemName();
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
