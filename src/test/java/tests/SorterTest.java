package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class SorterTest extends BaseTest {

    @Test
    public void sortPriceLowToHigh() {
        loginPage.open(); // открыт сайт
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD); // логин с переходом в Page Products
        Collection<Double> sortedItemsPrices = productsPage.getSortedItemsPricesLowToHigh(); // метод сортировки цен
        productsPage.sortItemsByPriceFromLowToHigh(); // сортировка цен на сайте
        Assert.assertEquals(productsPage.getItemsPrices(),
                sortedItemsPrices,
                "Цены отсортированы неверно");
    }
}
