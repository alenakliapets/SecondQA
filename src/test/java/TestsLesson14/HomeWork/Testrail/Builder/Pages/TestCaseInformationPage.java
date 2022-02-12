package TestsLesson14.HomeWork.Testrail.Builder.Pages;


import TestsLesson14.HomeWork.Testrail.Builder.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCaseInformationPage extends BasePage {

    private final static By addingSuccessfulLabelBy = By.xpath("//*[text()='Successfully added the new test case. ']");

    public TestCaseInformationPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqwerty.testrail.io/index.php?/cases/view/11");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getAddingSuccessfulLabel().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getAddingSuccessfulLabel(){return driver.findElement(addingSuccessfulLabelBy);}
}
