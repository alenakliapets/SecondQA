package TestsLesson9.Lesson9HomeWork.Pages;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestCasePage extends BasePage {

    private final static By titleInputBy = By.xpath("//*[@id='title' and @name='title']");
    private final static By acceptButtonBy = By.xpath("//*[@id='accept']");
    private final static By sectionInputBy = By.xpath("//div[@id='section_id_chzn']//div[@class='chzn-search']//input");
    private final static By sectionButtonBy =
            By.xpath("//div[@id='section_id_chzn' and @class='chzn-container chzn-container-single']//div//b");
    private final static By templateInputBy = By.xpath("//div[@id='template_id_chzn']//div[@class='chzn-search']//input");
    private final static By templateButtonBy =
            By.xpath("//div[@id='template_id_chzn' and @class='chzn-container chzn-container-single']//div//b");
    private final static By typeInputBy = By.xpath("//div[@id='type_id_chzn']//div[@class='chzn-search']//input");
    private final static By typeButtonBy =
            By.xpath("//div[@id='type_id_chzn' and @class='chzn-container chzn-container-single']//div//b");
    private final static By priorityInputBy = By.xpath("//div[@id='priority_id_chzn']//div[@class='chzn-search']//input");
    private final static By priorityButtonBy =
            By.xpath("//div[@id='priority_id_chzn' and @class='chzn-container chzn-container-single']//div//b");

    public AddTestCasePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://alenaqwerty.testrail.io/index.php?/cases/add/6");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getTitleInput().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getTitleInput(){return driver.findElement(titleInputBy);}
    public WebElement getAcceptButton(){return driver.findElement(acceptButtonBy);}
    public WebElement getSectionInput(){return driver.findElement(sectionInputBy);}
    public WebElement getSectionButton(){return driver.findElement(sectionButtonBy);}
    public WebElement getTemplateInput(){return driver.findElement(templateInputBy);}
    public WebElement getTemplateButton(){return driver.findElement(templateButtonBy);}
    public WebElement getTypeInput(){return driver.findElement(typeInputBy);}
    public WebElement getTypeButton(){return driver.findElement(typeButtonBy);}
    public WebElement getPriorityInput(){return driver.findElement(priorityInputBy);}
    public WebElement getPriorityButton(){return driver.findElement(priorityButtonBy);}

    public void setSectionInput(String text){
        getSectionInput().sendKeys(text);
    }
    public void clickSectionButton(){
        getSectionButton().click();
    }
    public void setTemplateInput(String text){
       getTemplateInput().sendKeys(text);
    }
    public void clickTemplateButton(){
        getTemplateButton().click();
    }
    public void setTypeInput(String text){
       getTypeInput().sendKeys(text);
    }
    public void clickTypeButton(){
        getTypeButton().click();
    }
    public void setPriorityInput(String text){
       getPriorityInput().sendKeys(text);
    }
    public void clickPriorityButton(){
        getPriorityButton().click();
    }
    public void setTitleInput(String text){
        getTitleInput().sendKeys(text);
    }
    public void clickAcceptButton(){
        getAcceptButton().click();
    }
}
