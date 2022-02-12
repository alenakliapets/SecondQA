package TestsLesson14;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage extends BasePage {
    @CacheLookup
    @FindBy(id = "name")
    public WebElement emailInput;
   // private final static By emailInputBy = By.id("name");
    @FindBys({
            @FindBy(className = "form-group"),
            @FindBy(css = "input.form-control[name = 'name']")}
    )
    public WebElement name;

    @FindAll({
            @FindBy(id = "suite_mode_single"),
            @FindBy(id = "suite_mode_single_baseline"),
            @FindBy(id = "suite_mode_multi"),
    })
    public List <WebElement> optionsList;

    private final static By passwordInputBy = By.id("password");
    private final static By loginButtonBy = By.id("button_primary");
    private final static By emailIsRequiredBy = By.xpath("//*[.='Email/Login is required.']");
    private final static By passwordIsRequiredBy = By.xpath("//*[.='Password is required.']");
    private final static By passwordEmailIsIncorrectBy =
            By.xpath("//*[.='Email/Login or Password is incorrect. Please try again.']");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL());
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getLoginButton().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

//    public WebElement getEmailInput(){return waits.waitForVisibility(emailInputBy);}
    public WebElement getPasswordInput(){return driver.findElement(passwordInputBy);}
    public WebElement getLoginButton(){return driver.findElement(loginButtonBy);}
    public WebElement getEmailIsRequired(){return driver.findElement(emailIsRequiredBy);}
    public WebElement getPasswordIsRequired(){return driver.findElement(passwordIsRequiredBy);}
    public WebElement getPasswordEmailIsIncorrect(){return driver.findElement(passwordEmailIsIncorrectBy);}

    public void setEmailName(String text){
        emailInput.sendKeys(text);
    }
    public void setPassword(String text){
        getPasswordInput().sendKeys(text);
    }
    public void clickLoginButton(){
        getLoginButton().click();
    }
}
