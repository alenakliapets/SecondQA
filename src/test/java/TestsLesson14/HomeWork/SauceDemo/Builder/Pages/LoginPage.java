package TestsLesson14.HomeWork.SauceDemo.Builder.Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   // @FindBy(id = "user-name")
    public WebElement userNameInput(){return driver.findElement(By.id("user-name"));}
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(tagName = "h3")
    public WebElement errorLabel;

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
        return userNameInput().isDisplayed();}
       catch (NoSuchElementException ex){
           return false;
       }
    }
    //атомарные методы по работе с элементами
    public void setUserName(String text){
    userNameInput().sendKeys(text);
}
    public void setPassword(String text){
    passwordInput.sendKeys(text);
    }
    public ProductsPage clickLoginButtonWithRightCredentials(){
        loginButton.click();
        return new ProductsPage(driver, false);
    }
    public LoginPage clickLoginButtonWithWrongCredentials(){
        loginButton.click();
        return this;
    }
}
