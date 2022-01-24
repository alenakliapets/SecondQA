package TestsLesson11.ClassWork;

import TestsLesson10.HomeWork.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {
    @Test
    public void frameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);

        WebElement element = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent()    парент вернет на 1 уровень выше,
        //                                      а дефолт контент на первоначальную страницу

        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }
    @Test
    public void frameTest1(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement element = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent()    парент вернет на 1 уровень выше,
        //                                      а дефолт контент на первоначальную страницу

        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @Test
    public void frameTest2(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        WebElement element = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent()    парент вернет на 1 уровень выше,
        //                                      а дефолт контент на первоначальную страницу

        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }
}
