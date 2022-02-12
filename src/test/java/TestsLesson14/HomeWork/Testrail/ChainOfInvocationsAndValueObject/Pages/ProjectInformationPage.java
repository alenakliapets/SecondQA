package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages;

import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectInformationPage extends BasePage {

    private final static By addTestCaseBy = By.id("sidebar-cases-add");

    public ProjectInformationPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get("https://alenaqwerty.testrail.io/index.php?/projects/overview/6");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getAddTestCase().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getAddTestCase(){return driver.findElement(addTestCaseBy);}

    public void clickAddTestCase(){
        getAddTestCase().click();
    }
}
