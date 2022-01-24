package TestsLesson11.ClassWork.Wrapers;

import TestsLesson10.HomeWork.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrappersTest extends BaseTest {

    @Test
    public void buttonTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Button simpleAlertButton = new Button(driver, By.xpath("//button[.='Click for JS Prompt']"));
        simpleAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Text");
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'result']")));

        Assert.assertEquals(resultLabel.getText(), "You entered: Text");
    }

}
