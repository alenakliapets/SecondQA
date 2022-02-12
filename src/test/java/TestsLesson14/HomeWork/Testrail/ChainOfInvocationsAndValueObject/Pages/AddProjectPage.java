package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages;

import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final static By projectNameInputBy = By.name("name");
    private final static By addProjectButtonBy = By.id("accept");

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqwerty.testrail.io/index.php?/admin/projects/add/");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getAddProjectButton().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getProjectName(){return driver.findElement(projectNameInputBy);}
    public WebElement getAddProjectButton(){return driver.findElement(addProjectButtonBy);}

    public void setProjectName(String text){
        getProjectName().sendKeys(text);
    }
    public void clickAddProjectButton(){
        getAddProjectButton().click();
    }

}
