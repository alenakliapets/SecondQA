package TestsLesson14;


import TestsLesson14.Models.User;
import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseStep;
import TestsLesson9.Lesson9HomeWork.Pages.DashboardPage;
import TestsLesson9.Lesson9HomeWork.Pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Логирование с корректными данными")
    public DashboardPage login(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);

        return  new DashboardPage(driver, false);
    }
    public DashboardPage login(User user){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(user.getEmail());
        loginPage.setPassword(user.getPassword());
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);

        return  new DashboardPage(driver, false);
    }
    public void loginIncorrect(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
    }
}
