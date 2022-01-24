package TestsLesson11.ClassWork;

import TestsLesson10.HomeWork.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedElements extends BaseTest {

    @Test
    public void simpleAlertsTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button [.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'result']")));

        Assert.assertEquals(resultLabel.getText(), "You successfully clicked an alert");
    }
    @Test
    public void mediumAlertsTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'result']")));

        Assert.assertEquals(resultLabel.getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertsTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Text");
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'result']")));

        Assert.assertEquals(resultLabel.getText(), "You entered: Text");
    }
}
