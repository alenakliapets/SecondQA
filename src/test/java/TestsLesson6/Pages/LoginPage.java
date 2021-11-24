package TestsLesson6.Pages;

import TestsLesson6.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //селекторы
    private final static By userNameInputBy = By.id("user-name");
    private final static By passwordInputBy = By.id("password");
    private final static By loginButtonBy = By.id("login-button");
    private final static By errorLabelByTag = By.tagName("h3");

    //конструктор

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

    //геттеры
public WebElement getUserNameInput(){return driver.findElement(userNameInputBy);}
public WebElement getPasswordInput(){return driver.findElement(passwordInputBy);}
public WebElement getLoginButton(){return driver.findElement(loginButtonBy);}
public WebElement getErrorLabel(){return driver.findElement(errorLabelByTag);}

    //атомарные методы по работе с элементами
public void setUserName(String text){
        getUserNameInput().sendKeys(text);
}
public void setPassword(String text){
        getPasswordInput().sendKeys(text);
    }
    public void clickLoginButton(){
        getLoginButton().click();
    }
}
