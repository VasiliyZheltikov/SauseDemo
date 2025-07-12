package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

public class SorterTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(description = "Проверка сортировки товара по цене (по возрастанию)",
            testName = "Сортировка товаров по возрастанию цены",
            groups = {"regression"},
            dataProvider = "LoginData")
    @Severity(SeverityLevel.MINOR)
    @Owner("Zheltikov Vasiliy")
    @Link("https://www.saucedemo.com/")
    @Epic("Products Page")
    @Feature("Sorter items by price")
    @Story("Sortering items by price from low to high")
    @TmsLink("ITM-4")
    @Description("Проверка отображения товаров при сортировке цены по возрастанию")
    public void sortPriceLowToHigh(String username, String password) {
        loginPage.open(); // открыт сайт
        loginPage.login(username, password); // логин с переходом в Page Products
        Collection<Double> sortedItemsPrices = productsPage.getSortedItemsPricesLowToHigh(); // метод сортировки цен
        productsPage.sortItemsByPriceFromLowToHigh(); // сортировка цен на сайте
        Assert.assertEquals(productsPage.getItemsPrices(),
                sortedItemsPrices,
                "Цены отсортированы неверно");
    }
}
