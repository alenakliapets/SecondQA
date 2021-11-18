package TestsLesson5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;

public class SelectorsTest2 {

    @Test
    public void homeworkFirstPage() {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("drivers" + File.separatorChar + "chromedriver").getFile());
    String absolutePath = file.getAbsolutePath();
    System.setProperty("webdriver.chrome.driver",absolutePath);
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");

    WebElement userNameById = driver.findElement(By.id("user-name"));
    WebElement userNameByName = driver.findElement(By.name("user-name"));
    WebElement userNameByXPath = driver.findElement(By.xpath("//*[@data-test = 'username']"));
    WebElement userNameByCSS = driver.findElement(By.cssSelector("[data-test = 'username']"));

    WebElement passwordById = driver.findElement(By.id("password"));
    WebElement passwordByName = driver.findElement(By.name("password"));
    WebElement passwordByXPath = driver.findElement(By.xpath("//*[@data-test = 'password']"));
    WebElement passwordByCSS = driver.findElement(By.cssSelector("[data-test = 'password']"));

    WebElement loginById = driver.findElement(By.id("login-button"));
    WebElement loginByName = driver.findElement(By.name("login-button"));
    WebElement loginByClass = driver.findElement(By.className("submit-button"));
    WebElement loginByXPath = driver.findElement(By.xpath("//*[@data-test = 'login-button']"));
    WebElement loginByCSS = driver.findElement(By.cssSelector("[data-test = 'login-button']"));

driver.quit();
}
    @Test
    public void homeworkSecondPage() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers" + File.separatorChar + "chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userNameById = driver.findElement(By.id("user-name"));
        userNameById.sendKeys("standard_user");

        WebElement passwordById = driver.findElement(By.id("password"));
        passwordById.sendKeys("secret_sauce");

        WebElement loginById = driver.findElement(By.id("login-button"));
        loginById.click();

        WebElement buttonMenuById = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement buttonMenuByXPath = driver.findElement(By.xpath("//*[@id = 'react-burger-menu-btn']"));
        WebElement buttonMenuByCSS = driver.findElement(By.cssSelector("[id = 'react-burger-menu-btn']"));

        WebElement CartByClass = driver.findElement(By.className("shopping_cart_link"));
        WebElement CartByXPath = driver.findElement(By.xpath("//*[@class = 'shopping_cart_link']"));
        WebElement CartByCSS = driver.findElement(By.cssSelector(".shopping_cart_link"));

        WebElement filterByClass = driver.findElement(By.className("product_sort_container"));
        WebElement filterByXPath = driver.findElement(By.xpath("//*[@class = 'product_sort_container']"));
        WebElement filterByCSS = driver.findElement(By.cssSelector(".product_sort_container"));

        WebElement firstProductByPartialText = driver.findElement(By.partialLinkText("Backpack"));
        WebElement firstProductByText = driver.findElement(By.linkText("Sauce Labs Backpack"));
        WebElement firstProductByXPath = driver.findElement(By.xpath("//*[. = 'Sauce Labs Backpack']"));

        WebElement firstProductPriceByXpath = driver.findElement(By.xpath("//*[@class = 'inventory_list']/div[1]//div[@class = 'inventory_item_price']"));
        String text = firstProductPriceByXpath.getText();

        WebElement addCartById = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        WebElement addCartByName = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        WebElement addCartByXPath = driver.findElement(By.xpath("//*[@data-test = 'add-to-cart-sauce-labs-backpack']"));
        WebElement addCartByCss = driver.findElement(By.cssSelector("[data-test = 'add-to-cart-sauce-labs-backpack']"));

        WebElement photoItemByXpath = driver.findElement(By.xpath("//*[@src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']"));
        WebElement photoItemByCss = driver.findElement(By.cssSelector("[src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']"));

        String firstProductName = firstProductByText.getText();
        System.out.println("Название товара: "+firstProductName);
        System.out.println("Цена товара: "+text);

        driver.quit();
    }
}
