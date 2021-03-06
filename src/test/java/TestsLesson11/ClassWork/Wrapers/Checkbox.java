package TestsLesson11.ClassWork.Wrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    private final UIElement element;

    public Checkbox(WebDriver driver, By by){
        this.element = new UIElement(driver, by);
    }

    public void click(){
        this.element.click();
    }

    public boolean isSelected(){
       return this.element.isSelected();
    }

    public void changeState(boolean makeSelected){
        if (this.isSelected() !=makeSelected) this.click();
    }
}
