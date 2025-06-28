package tests;

import org.testng.annotations.Test;

import java.util.stream.Stream;

public class SorterTest extends BaseTest {

    @Test
    public void sortPriceLowToHigh() {
        loginPage.open();
        loginPage.login(LOGIN_STANDARD_USER, CORRECT_PASSWORD);
        Stream<String> sortedItemsPrices = productsPage.getSortedItemsPricesLowToHigh();
        productsPage.sortItemsByPriceFromLowToHigh();
        softAssert.assertEquals(productsPage.getItemsPrices(),
                sortedItemsPrices,
                "Цены отсортированы неверно");
    }
}
