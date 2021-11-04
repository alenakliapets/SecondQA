package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

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



//       WebElement customsCalculator = driver.findElement(By.linkText("Таможенные калькуляторы"));
//        Assert.assertTrue(customsCalculator != null);
//
//       WebElement otherCalcuator = driver.findElement(By.partialLinkText("Прочие"));
//        Assert.assertTrue(otherCalcuator != null);
//
//       List <WebElement> webElementList = driver.findElements(By.tagName("section"));
//        Assert.assertEquals(webElementList.size(),2);

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

        WebElement layingMethodLaminatElement = driver.findElement(By.tagName("select"));
        Select layingMethodLaminat = new Select(layingMethodLaminatElement);

        //Выбор нужного элемента в выпадающем списке
        layingMethodLaminat.selectByIndex(2);

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement laminatLength = driver.findElement(By.id("ln_lam_id"));
        laminatLength.clear();
        laminatLength.sendKeys("2000");

        WebElement laminatWidth = driver.findElement(By.id("wd_lam_id"));
        laminatWidth.clear();
        laminatWidth.sendKeys("200");

        //Направление укладки ламината

        WebElement layingDirectionLaminate = driver.findElement(By.id("direction-laminate-id1"));
        layingDirectionLaminate.click();

        Thread.sleep(3000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, 5000);");
//        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight," +
//                "document.body.scrollHeight,document.documentElement.clientHeight));");

        Thread.sleep(10000);
        WebElement calculateButton = driver.findElement(By.partialLinkText("Рассчитать"));
        calculateButton.click();
        Thread.sleep(5000);

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


