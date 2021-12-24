package TestsLesson9.Lesson9HomeWork.Pages;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final static By emailInputBy = By.id("name");
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

    public WebElement getEmailInput(){return driver.findElement(emailInputBy);}
    public WebElement getPasswordInput(){return driver.findElement(passwordInputBy);}
    public WebElement getLoginButton(){return driver.findElement(loginButtonBy);}
    public WebElement getEmailIsRequired(){return driver.findElement(emailIsRequiredBy);}
    public WebElement getPasswordIsRequired(){return driver.findElement(passwordIsRequiredBy);}
    public WebElement getPasswordEmailIsIncorrect(){return driver.findElement(passwordEmailIsIncorrectBy);}

    public void setEmailName(String text){
        getEmailInput().sendKeys(text);
    }
    public void setPassword(String text){
        getPasswordInput().sendKeys(text);
    }
    public void clickLoginButton(){
        getLoginButton().click();
    }
}
