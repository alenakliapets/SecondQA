package TestsLesson11.ClassWork;

import TestsLesson10.HomeWork.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JSTest extends BaseTest {

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement button = driver.findElement(By.tagName("button"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", button);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("added-manually")));
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.onliner.by");

        WebElement button = driver.findElement(By.xpath("//a[.='Все статьи о людях']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", button);

        Thread.sleep(2000);

    }



}
