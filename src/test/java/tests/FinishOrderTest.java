package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FinishOrderTest extends BaseTest {

    @Test
    public void finishOrderTest() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        productsPage.addItemToCart();
        productsPage.moveToCart();
        cartPage.checkout();
        checkoutYourInformationPage.login();
        checkoutOverviewPage.finish();
        Assert.assertEquals(checkoutCompletePage.getNotice(),
                "Thank you for your order!",
                "Не удалось успешно оформить заказ");
    }
}
