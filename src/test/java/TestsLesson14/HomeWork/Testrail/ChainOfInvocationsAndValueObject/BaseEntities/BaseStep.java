package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities;

import TestsLesson9.Lesson9HomeWork.Core.Waits;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected Waits wait;

    public BaseStep(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver, 20);
    }

}
