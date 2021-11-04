package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SmokeTest3 {

        @Test
        public void smokeTest3() throws InterruptedException{
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
            String absolutePath = file.getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", absolutePath);
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
            Thread.sleep(3000);

//            WebElement heightInput = driver.findElement(By.id("bmiVar1"));
//            heightInput.sendKeys("183");
//
//            WebElement weightInput = driver.findElement(By.name("bmiVar2"));
//            weightInput.sendKeys("58");
//
//            WebElement calculateButton = driver.findElement(By.className("btn-calculate"));
//            calculateButton.click();
//            Thread.sleep(1000);
//
//            String expectedIMTResult = "17.32";
//            WebElement actualIMTResultElement = driver.findElement(By.id("AnswerBMI"));
//            String actualIMTResult = actualIMTResultElement.getText();
//
//            Assert.assertEquals(actualIMTResult,expectedIMTResult);
//
//            String expectedIMTMessage = "Недостаточной массе тела";
//            WebElement actualIMTMessageElement = driver.findElement(By.id("AnswerBMI1"));
//            String actualIMTMessage = actualIMTMessageElement.getText();
//
//            Assert.assertEquals(actualIMTMessage,expectedIMTMessage);
//
//

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





}
