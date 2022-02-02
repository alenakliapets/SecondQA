package TestsLesson12.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxWrap {
    private final MyUIElement element;

    public CheckBoxWrap(WebDriver driver, By by) {
        this.element = new MyUIElement(driver, by);
    }

    public void click(){
        this.element.click();
    }

    public boolean isSelected(){
        return this.element.isSelected();
    }
    public void changeState(boolean doYouNeedSelected){
        if (this.isSelected() != doYouNeedSelected) {this.click();}
    }
}
