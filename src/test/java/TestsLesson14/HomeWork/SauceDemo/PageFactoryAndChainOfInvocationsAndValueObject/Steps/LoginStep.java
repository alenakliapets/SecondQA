package TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Steps;


import BaseEntities.BaseStep;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.LoginPage;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProductsPage loginWithRightCredentials(String username, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        return loginPage.clickLoginButtonWithRightCredentials();
    }
    public LoginPage loginWithWrongCredentials(String username, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        return loginPage.clickLoginButtonWithWrongCredentials();
    }
}
