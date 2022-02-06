package TestsLesson9.Lesson9HomeWork.Steps;


import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseStep;
import TestsLesson9.Lesson9HomeWork.Pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Логирование")
    public void login(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
    }
}
