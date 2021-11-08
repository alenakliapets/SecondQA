package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class SmokeTest4 {

    @Test
    public void smokeTest4() throws InterruptedException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers"+File.separatorChar+"chromedriver").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        //Заполнение поля длина помещения
        WebElement lengthInput = driver.findElement(By.name("calc_roomwidth"));
        double defaultLength = 6.0;
        double actualLength = 10.0;
        while (defaultLength<actualLength-0.1){
            lengthInput.sendKeys(Keys.ARROW_UP);
            defaultLength = defaultLength + 0.1;}

        //Заполнение поля ширина помещения
        WebElement widthInput = driver.findElement(By.name("calc_roomheight"));
        double defaultWidth = 3.0;
        double actualWidth = 4.0;
        while (defaultWidth<actualWidth){
            widthInput.sendKeys(Keys.ARROW_UP);
            defaultWidth = defaultWidth + 0.1;}

        //Заполнение поля длина доски ламината
        WebElement lengthLaminat = driver.findElement(By.name("calc_lamwidth"));
        int defaultLengthLam = 1300;
        int actualLengthLam = 1330;
        while (defaultLengthLam<actualLengthLam){
            lengthLaminat.sendKeys(Keys.ARROW_UP);
            defaultLengthLam ++;}

        //Заполнение поля ширина доски ламината
        WebElement widthLaminat = driver.findElement(By.name("calc_lamheight"));
        int defaultWidthLam = 192;
        int actualWidthLam = 220;
        while (defaultWidthLam<actualWidthLam){
            widthLaminat.sendKeys(Keys.ARROW_UP);
            defaultWidthLam ++;}

        //Количество досок в пачке
        WebElement numberLaminates = driver.findElement(By.name("calc_inpack"));
        int defaultNumberLam = 12;
        int actualNumberLam = 14;
        while (defaultNumberLam<actualNumberLam){
            numberLaminates.sendKeys(Keys.ARROW_UP);
            defaultNumberLam ++;}

        //Стоимость квадратного метра
        WebElement costOnePack = driver.findElement(By.name("calc_price"));
        int defaultPrice = 500;
        int actualPrice = 450;
        while (defaultPrice>actualPrice){
            costOnePack.sendKeys(Keys.ARROW_DOWN);
            defaultPrice --;}

        //Направление укладки
        WebElement layingMethodLaminatElement = driver.findElement(By.name("calc_direct"));
        Select layingMethodLaminat = new Select(layingMethodLaminatElement);
        layingMethodLaminat.selectByValue("toh");

        //Смещение рядов
        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        int defaultOffset = 300;
        int actualOffset = 290;
        while (defaultOffset>actualOffset){
            offsetRows.sendKeys(Keys.ARROW_DOWN);
            defaultOffset --;}

        //Смещение рядов
        WebElement indentFromWall = driver.findElement(By.name("calc_walldist"));
        int defaultIndent = 10;
        int actualIndent = 9;
        while (defaultIndent>actualIndent){
            indentFromWall.sendKeys(Keys.ARROW_DOWN);
            defaultIndent --;}

        //Нажимаем кнопку расчет
//            WebElement calculateButton = driver.findElement(By.xpath("//div[@class='btn btn-secondary btn-lg tocalc']"));
//            calculateButton.click();

        //Сравниваем результат по площади укладки
        String expectedSquare = "39.75 м2.";
        WebElement square = driver.findElement(By.id("s_lam"));
        String actualSquare = square.getText();
        Assert.assertEquals(actualSquare,expectedSquare);

        //Сравниваем результат по количеству панелей
        String expectedNumber = "140 шт.";
        WebElement number = driver.findElement(By.id("l_count"));
        String actualNumber = number.getText();
        Assert.assertEquals(actualNumber,expectedNumber);

        //Сравниваем результат по количеству упаковок
        String expectedNumberPacks = "10 шт.";
        WebElement numberPacks = driver.findElement(By.id("l_packs"));
        String actualNumberPacks = numberPacks.getText();
        Assert.assertEquals(actualNumberPacks,expectedNumberPacks);

        //Сравниваем результат по стоимости
        String expectedPrice = "18433 руб.";
        WebElement price = driver.findElement(By.id("l_price"));
        String actualPriceLam = price.getText();
        Assert.assertEquals(actualPriceLam,expectedPrice);

        //Сравниваем результат по остаткам
        String expectedLeftovers = "0 шт.";
        WebElement leftovers = driver.findElement(By.id("l_over"));
        String actualLeftovers = leftovers.getText();
        Assert.assertEquals(actualLeftovers,expectedLeftovers);

//Сравниваем результат по отрезкам
        String expectedSegments = "14 шт.";
        WebElement segments = driver.findElement(By.id("l_trash"));
        String actualSegments = segments.getText();
        Assert.assertEquals(actualSegments,expectedSegments);


        Thread.sleep(2000);

        driver.quit();
    }
}