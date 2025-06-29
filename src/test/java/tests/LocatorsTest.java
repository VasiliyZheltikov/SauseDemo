package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {

    @Test
    public void checkLocators() {
        setup();
        driver.get("https://www.saucedemo.com/");
        // By id
        driver.findElement(By.id("user-name"));
        // By name
        driver.findElement(By.name("login-button"));
        // By classname
        driver.findElement(By.className("login_logo"));
        // By tagname
        driver.findElement(By.tagName("h4"));
        // By linktext
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.linkText("All Items"));
        // By partial link text
        driver.findElement(By.partialLinkText("Reset"));
        // By xpath: attribute
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        // By xpath: text
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        // By xpath: partial attribute
        driver.findElement(By.xpath("//div[contains(@data-test,'price')]"));
        // By xpath: partial text
        driver.findElement(By.xpath("//div[contains(text(),'Bike Light')]"));
        // By xpath: ancestor
        driver.findElement(By.xpath("//ul[@class='social']/li/ancestor::*"));
        // By xpath: descendant
        driver.findElement(By.xpath("//div[@class='inventory_list']/descendant::*"));
        // By xpath: following
        driver.findElement(By.xpath("//div[@id='contents_wrapper']/following::*"));
        // By xpath: parent
        driver.findElement(By.xpath("//div[@class='inventory_item_desc']/parent::div"));
        // By xpath: preceding
        driver.findElement(By.xpath("//li[@class='social_linkedin']/preceding::*"));
        // By xpath: AND
        driver.findElement(By.xpath("//div[div and a]"));
        // By css: .class
        driver.findElement(By.cssSelector(".product_sort_container"));
        // By css: .class1.class2
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
        // By css: .class1 .class2
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        // By css: #id
        driver.findElement(By.cssSelector("#logout_sidebar_link"));
        // By css: tagname
        driver.findElement(By.cssSelector("nav"));
        // By css: tagname.class
        driver.findElement(By.cssSelector("div.inventory_item_img"));
        // By css: [attribute=value]
        driver.findElement(By.cssSelector("[data-test=inventory-item-description]"));
        // By css: [attribute~=value]
        driver.findElement(By.cssSelector("[class~=btn]"));
        // By css: [attribute|=value]
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.cssSelector("[class|=back]"));
        // By css: [attribute^=value]
        driver.findElement(By.cssSelector("[class^=cart]"));
        // By css: [attribute$=value]
        driver.findElement(By.cssSelector("[class$=label]"));
        // By css: [attribute*=value]
        driver.findElement(By.cssSelector("[href*=sauce]"));
        close();
    }
}
