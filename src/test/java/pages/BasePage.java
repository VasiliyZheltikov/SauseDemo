package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public abstract BasePage open();

    public void clickJS(WebElement element) {
        js.executeScript("arguments[0].click;", element);
    }
}
