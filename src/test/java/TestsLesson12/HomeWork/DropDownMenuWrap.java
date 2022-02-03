package TestsLesson12.HomeWork;

import TestsLesson9.Lesson9HomeWork.Core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class DropDownMenuWrap {
    private List<MyUIElement> list = new ArrayList<>();
    private WebDriver driver;
    private Waits waits;

    public DropDownMenuWrap(WebDriver driver, By by) {
        this.driver = driver;
        this.waits = new Waits(driver, 10);
       for (WebElement element: driver.findElements(by)){
           list.add(new MyUIElement(driver, element));
       }
    }

    public void dropDownMenuClick(By by){
        driver.findElement(by).click();
        waits.waitForVisibility(by);
    }

    public void selectByText(String text){
        for (MyUIElement element:list){
            String textOfDropDown = element.getText();
            if (textOfDropDown.contains(text)){
                element.click();
                break;
            }
        }
    }
}
