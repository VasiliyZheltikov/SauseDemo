package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test(description = "Проверка добавления товара в корзину",
            testName = "Добавление товара в корзину",
            groups = {"smoke"})
    public void checkItemNameAndPrice() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        productsPage.addItemToCart();
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
