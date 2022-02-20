package TestsLesson9.Lesson9HomeWork.Pages;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BasePage;
import TestsLesson9.Lesson9HomeWork.Core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private static ReadProperties properties = new ReadProperties();

    private final static By allProjectsLabelBy = By.className("content-header-title");
    private final static By addNewProjectBy = By.id("sidebar-projects-add");
    private final static By projectInformationBy =
            By.xpath("//*[@class='row project flex-projects-row']//a[.='"+properties.getProjectNameFor6Test()+"']");

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqazxsw2.testrail.io/index.php?/dashboard");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getAddNewProject().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getAllProjectsLabel(){return driver.findElement(allProjectsLabelBy);}
    public WebElement getAddNewProject(){return driver.findElement(addNewProjectBy);}
    public WebElement getProjectInformation(){return driver.findElement(projectInformationBy);}

}
