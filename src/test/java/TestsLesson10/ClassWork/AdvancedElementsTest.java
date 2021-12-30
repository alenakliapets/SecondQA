package TestsLesson10.ClassWork;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedElementsTest extends BaseTest {
@Test
    public void hoverTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/hovers");

    List <WebElement> list = driver.findElements(By.className("figure"));

    Actions actions = new Actions(driver);
    actions.moveToElement(list.get(0))
            .pause(1000)
            .moveToElement(list.get(2))
            .pause(1000)
            .moveToElement(list.get(0))
            .build().perform();
        waits.waitForVisibility(By.xpath("//h5[text() = 'name: user1']"));
}

@Test
    public void contextTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/context_menu");

    WebElement hotSpot = driver.findElement(By.id("hot-spot"));
    Actions actions = new Actions(driver);
    actions.moveToElement(hotSpot)
            .contextClick()
            .build().perform();

    Thread.sleep(2000);
}

@Test
    public void dragAndDropTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/drag_and_drop");

    WebElement a = driver.findElement(By.id("column-a"));
    WebElement b = driver.findElement(By.id("column-b"));

    Actions actions = new Actions(driver);
    actions.dragAndDrop(a, b).build().perform();
    Thread.sleep(3000);
}

@Test
    public void uploadFileTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/upload");

    WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file' and @name = 'file']"));

    uploadFile.sendKeys("/Users/elenaklepec/Downloads/photo_2021-10-07 16.51.52.jpeg");

    driver.findElement(By.id("file-submit")).click();

    waits.waitForVisibility(By.xpath("//h3[text() = 'File Uploaded!']"));
    Thread.sleep(5000);
}
}
