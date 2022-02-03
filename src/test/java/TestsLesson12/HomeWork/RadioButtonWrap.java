package TestsLesson12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class RadioButtonWrap {
    private List<MyUIElement> list = new ArrayList<>();
    private WebDriver driver;

    public RadioButtonWrap(WebDriver driver, By by) {
        this.driver = driver;
        for (WebElement element: driver.findElements(by)){
            list.add(new MyUIElement(driver,element));
        }
    }

    public void selectByIndex(int index){
        for (MyUIElement element: list){
            if (Integer.parseInt(element.getAttribute("value")) == index){
                element.click();
                break;
            }
        }
    }

    public void selectByText(String text){
        for (MyUIElement element: list){
String textOfRadioButton = element.getParent().findElement(By.tagName("strong")).getText();
if (text.equalsIgnoreCase(textOfRadioButton)){
    element.click();
    break;
}
        }
    }
}
