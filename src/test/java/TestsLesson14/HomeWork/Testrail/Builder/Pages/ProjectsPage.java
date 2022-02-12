package TestsLesson14.HomeWork.Testrail.Builder.Pages;

import TestsLesson14.HomeWork.Testrail.Builder.BaseEntities.BasePage;
import TestsLesson14.HomeWork.Testrail.Builder.Core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

    private static ReadProperties properties = new ReadProperties();

    private final static By addProjectBy = By.xpath("//*[@href = 'index.php?/admin/projects/add']");
    private final static By myProjectEditButtonBy = By.xpath("//*[.='"+properties.getProjectName()+"']/ancestor::tr/td[2]//div");
    private final static By myProjectDeleteButtonBy = By.xpath("//*[.='"+properties.getEditedProjectName()+"']/ancestor::tr/td[3]//div");
    private final static By confirmationDeletingProjectButtonBy = By.xpath("//*[@id='deleteDialog']//input");
    private final static By confirmationOKButtonBy = By.xpath("//*[@id='deleteDialog']/div[3]/a");
    private final static By editedProjectBy = By.xpath("//*[.='"+properties.getEditedProjectName()+"']");

    public ProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqazxsw.testrail.io/index.php?/admin/projects/overview");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getAddProject().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getAddProject(){return driver.findElement(addProjectBy);}
    public WebElement getMyProjectEditButton(){return driver.findElement(myProjectEditButtonBy);}
    public WebElement getMyProjectDeleteButton(){return driver.findElement(myProjectDeleteButtonBy);}
    public WebElement getConfirmationDeletingProjectButton(){return driver.findElement(confirmationDeletingProjectButtonBy);}
    public WebElement getConfirmationOKButton(){return driver.findElement(confirmationOKButtonBy);}
    public WebElement getEditedProject(){return driver.findElement(editedProjectBy);}

    public void clickEditButton(){
        getMyProjectEditButton().click();
    }
    public void clickDeleteButton(){
        getMyProjectDeleteButton().click();
    }
    public void clickConfirmationDeletingButton(){
        getConfirmationDeletingProjectButton().click();
    }
    public void clickConfirmationOKButton(){
        getConfirmationOKButton().click();
    }
}
