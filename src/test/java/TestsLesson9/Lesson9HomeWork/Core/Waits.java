package TestsLesson9.Lesson9HomeWork.Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {

    private WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
    }

    public WebElement waitForVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibilityElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityAll(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Boolean waitForInvisibility(By by){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public Boolean waitForInvisibility(WebElement webElement){
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
