package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenItemCardTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(description = "Проверка открытия карточки товара",
            testName = "Открытие карточки товара",
            groups = {"regression"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Products Page")
    @Feature("Open item card")
    @Story("Opening item card")
    @TmsLink("ITM-4")
    @Issue("ITM-4-1")
    @Description("Проверка открытия пользователем карточки товара")
    public void openItemCardTest(String username, String password) {
        loginPage.open();
        loginPage.login(username, password);
        String productNameOnProductPage = productsPage.getItemNameOnProductsPage();
        productsPage.openItemCardByName();
        softAssert.assertEquals(productsPage.getItemNameInItemCard(),
                productNameOnProductPage,
                "Открыта карточка товара с другим названием");
        productsPage.open();
        productsPage.openItemCardByImage();
        softAssert.assertEquals(productsPage.getItemImageInItemCard().getDomProperty("alt"),
                productsPage.getItemNameInItemCard(),
                "Изображение товара не соответствует ожидаемому");
        softAssert.assertAll();
    }
}
