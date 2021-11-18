package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
//Домашняя работа начинается со SmokeTest2

//https://calc.by/weight-and-calories/body-mass-index-calculator.html
public class SmokeTest {
    @Test
    public void smokeTest1() throws InterruptedException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
       driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
       Thread.sleep(3000);

       WebElement heightInput = driver.findElement(By.id("bmiVar1"));
        heightInput.sendKeys("183");

       WebElement weightInput = driver.findElement(By.name("bmiVar2"));
        weightInput.sendKeys("58");

       WebElement calculateButton = driver.findElement(By.className("btn-calculate"));
        calculateButton.click();
        Thread.sleep(1000);

String expectedIMTResult = "17.32";
WebElement actualIMTResultElement = driver.findElement(By.id("AnswerBMI"));
String actualIMTResult = actualIMTResultElement.getText();

Assert.assertEquals(actualIMTResult,expectedIMTResult);

        String expectedIMTMessage = "Недостаточной массе тела";
        WebElement actualIMTMessageElement = driver.findElement(By.id("AnswerBMI1"));
        String actualIMTMessage = actualIMTMessageElement.getText();

        Assert.assertEquals(actualIMTMessage,expectedIMTMessage);

        driver.quit();

    }

    @Test
    public void smokeTest2() throws InterruptedException{

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(3000);

        //Направление укладки ламината (по ширине комнаты)
        WebElement layingDirectionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", layingDirectionLaminate);
        layingDirectionLaminate.click();

        WebElement layingMethodLaminatElement = driver.findElement(By.tagName("select"));
        Select layingMethodLaminat = new Select(layingMethodLaminatElement);

        //Выбор нужного элемента в выпадающем списке
        layingMethodLaminat.selectByIndex(2);

        //Заполнение поля длина комнаты
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        //Заполнение поля ширина комнаты
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        //Заполнение поля длина доски ламината
        WebElement laminatLength = driver.findElement(By.id("ln_lam_id"));
        laminatLength.clear();
        laminatLength.sendKeys("2000");

        //Заполнение поля ширина доски ламината
        WebElement laminatWidth = driver.findElement(By.id("wd_lam_id"));
        laminatWidth.clear();
        laminatWidth.sendKeys("200");

        //Нажатие кнопки рассчитать
        WebElement calculateButton = driver.findElement(By.partialLinkText("Рассчитать"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        calculateButton.click();
        Thread.sleep(1500);

        //Количество досок ламината
        String expectedNumberLaminates = "53";
        WebElement actualNumberLaminatesElement = driver.findElement(By.xpath("//div[@class='calc-result']/div[1]/span"));
        String actualNumberLaminates = actualNumberLaminatesElement.getText();

        Assert.assertEquals(actualNumberLaminates,expectedNumberLaminates);

        // Количество пачек ламината
        String expectedNumberPacksLaminate = "7";
        WebElement actualNumberPacksElement = driver.findElement(By.xpath("//div[@class='calc-result']/div[2]/span"));
        String actualNumberPacksLaminate = actualNumberPacksElement.getText();

        Assert.assertEquals(actualNumberPacksLaminate,expectedNumberPacksLaminate);

        driver.quit();

    }


}


