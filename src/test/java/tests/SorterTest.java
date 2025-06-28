package tests;

import org.testng.annotations.Test;

public class SorterTest extends BaseTest {

    @Test
    public void sortPriceLowToHigh() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        String sortedItemsPrices = productsPage.getSortedItemsPricesLowToHigh();
        productsPage.sortItemsByPriceFromLowToHigh();
        softAssert.assertEquals(productsPage.getItemsPrices().toString(),
                sortedItemsPrices,
                "Цены отсортированы неверно");
    }
}
