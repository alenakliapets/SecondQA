package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages;

import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProject extends BasePage {

    private final static By editNameProjectBy = By.id("name");
    private final static By saveEditedProjectBy = By.id("accept");

    public EditProject(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqwerty.testrail.io/index.php?/admin/projects/edit/8");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getSaveEditedProject().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getEditNameProject(){return driver.findElement(editNameProjectBy);}
    public WebElement getSaveEditedProject(){return driver.findElement(saveEditedProjectBy);}

    public void clickSaveButton(){
        getSaveEditedProject().click();
    }
    public void clearProjectName(){getEditNameProject().clear();}
    public void setNewProjectName(String text){
        getEditNameProject().sendKeys(text);
    }

}
