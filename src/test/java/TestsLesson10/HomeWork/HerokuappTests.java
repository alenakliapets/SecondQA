package TestsLesson10.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuappTests extends BaseTest{

    @Test
    public void contextTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions
                .moveToElement(hotSpot)
                .contextClick()
                .build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void dynamicControlsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBox = driver.findElement(By.xpath("//*[@type = 'checkbox']"));
        WebElement removeButton = driver.findElement(By.xpath("//*[@onclick = 'swapCheckbox()']"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(checkBox)
                .click()
                .build().perform();
        actions
                .moveToElement(removeButton)
                .click()
                .build().perform();

        waits.waitForVisibility(By.xpath("//*[@id = 'message']"));
        waits.waitForInvisibility(checkBox);

        WebElement enable = driver.findElement(By.xpath("//*[@onclick = 'swapInput()']"));

        waits.waitForVisibility(By.xpath("//*[@disabled]"));

        actions
                .moveToElement(enable)
                .click()
                .build().perform();

        waits.waitForVisibility(By.xpath("//*[@id='message']"));
        waits.waitForInvisibility(By.xpath("//*[@disabled]"));
    }

    @Test
    public void uploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement upload = driver.findElement(By.xpath("//input[@type='file' and @name = 'file']"));

        String fileName = "photo_2021-10-07 16.51.52.jpeg";

        upload.sendKeys(properties.getUserDir()+fileName);
        driver.findElement(By.id("file-submit")).click();

        waits.waitForVisibility(By.xpath("//h3[text() = 'File Uploaded!']"));

        Assert.assertEquals(driver.findElement
                (By.xpath("//*[@id = 'uploaded-files']")).getText(), fileName);
    }


}
