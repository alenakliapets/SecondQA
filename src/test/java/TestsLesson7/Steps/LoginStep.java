package TestsLesson7.Steps;

import TestsLesson7.BaseEntities.BaseStep;
import TestsLesson7.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}
