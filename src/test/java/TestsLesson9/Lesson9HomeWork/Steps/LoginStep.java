package TestsLesson9.Lesson9HomeWork.Steps;


import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseStep;
import TestsLesson9.Lesson9HomeWork.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}