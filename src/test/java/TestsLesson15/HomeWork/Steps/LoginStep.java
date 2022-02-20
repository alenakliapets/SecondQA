package TestsLesson15.HomeWork.Steps;


import BaseEntities.BaseStep;
import TestsLesson15.HomeWork.Pages.LoginPage;
import TestsLesson15.HomeWork.Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public ProductsPage loginWithRightCredentials(String username, String password){
        logger.info("Вход на сайт с верными данными");
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        return loginPage.clickLoginButtonWithRightCredentials();
    }
    public LoginPage loginWithWrongCredentials(String username, String password){
        logger.info("Вход на сайт с неверными данными");
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        return loginPage.clickLoginButtonWithWrongCredentials();
    }
}
