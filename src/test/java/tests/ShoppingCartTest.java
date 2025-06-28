package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void checkItemNameAndPrice() {
        driver.get("https://www.saucedemo.com/");
        softAssert.assertEquals(driver.findElement(By.className("login_logo")).getText(), "Swag Labs");
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // заполнение Username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // заполнение Password
        driver.findElement(By.id("login-button")).click(); // нажатие кнопки Login
        // driver.findElement(By.id("password")).submit() - ещё один способ завершить авторизацию
        softAssert.assertEquals(driver.findElement(By.className("title")).getText(), "Products");
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click(); // добавление товара в корзину
        softAssert.assertEquals(driver.findElement(By.id("remove-sauce-labs-bike-light")).getText(), "Remove");
        String productPrice = driver.findElement(By.xpath("(//div" +
                "[@class='inventory_item_price'])[2]")).getText(); // запись в переменную цены товара
        String productName = driver.findElement(By.xpath("(//div" +
                "[@class='inventory_item_name '])[2]")).getText(); // запись в переменную названия товара
        driver.findElement(By.className("shopping_cart_link")).click(); // переход в корзину
        softAssert.assertEquals(driver.findElement(By.className("title")).getText(), "Your Cart");
        softAssert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), productName);
        softAssert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), productPrice);
        softAssert.assertAll();
    }
}
