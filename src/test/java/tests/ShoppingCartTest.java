package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void checkItemNameAndPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCart();
        String itemName = productsPage.getItemName();
        String itemPrice = productsPage.getItemPrice();
        productsPage.moveToCart();
        softAssert.assertEquals(itemName, cartPage.getItemName());
        softAssert.assertEquals(itemPrice, cartPage.getItemPrice());
        softAssert.assertAll();
    }
}
