package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SorterTest extends BaseTest {

    @Test
    public void sortPriceLowToHigh() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        String sortedItemsPrices = productsPage.getSortedItemsPricesLowToHigh();
        productsPage.sortItemsByPriceFromLowToHigh();
        Assert.assertEquals(productsPage.getItemsPrices(),
                sortedItemsPrices,
                "Цены отсортированы неверно");
    }
}
