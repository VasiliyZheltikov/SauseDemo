package tests;

import org.testng.annotations.Test;

public class OpenItemCardTest extends BaseTest {

    @Test
    public void openItemCardTest() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        String productNameOnProductPage = productsPage.getItemNameOnProductsPage();
        productsPage.openItemCardByName();
        softAssert.assertEquals(productsPage.getItemNameInItemCard(),
                productNameOnProductPage,
                "Открыта карточка товара с другим названием");
        productsPage.open();
        productsPage.openItemCardByImage();
        softAssert.assertTrue(productsPage.getItemImageInItemCard().isDisplayed(),
                "Ошибка отображения фотографии товара");
        softAssert.assertEquals(productsPage.getItemImageInItemCard().getDomProperty("alt"),
                productsPage.getItemNameInItemCard(),
                "Открыта фотография другого товара");
        softAssert.assertAll();
    }
}
