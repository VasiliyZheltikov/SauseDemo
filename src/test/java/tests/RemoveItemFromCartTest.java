package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {

    @Test
    public void removeItemFromCartTest() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        productsPage.addItemToCart();
        productsPage.moveToCart();
        cartPage.removeItemFromCart();
        Assert.assertFalse(cartPage.ItemIsDisplaying(),
                "Товар не удалён");
    }
}
