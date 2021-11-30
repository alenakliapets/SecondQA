package TestsLesson6.Steps;

import TestsLesson6.BaseEntities.BaseStep;
import TestsLesson6.Pages.LoginPage;
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
