package TestsLesson14.HomeWork.Testrail.Builder.Steps;


import TestsLesson14.HomeWork.Testrail.Builder.BaseEntities.BaseStep;
import TestsLesson14.HomeWork.Testrail.Builder.Pages.DashboardPage;
import TestsLesson14.HomeWork.Testrail.Builder.Pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Логирование с верными данными")
    public DashboardPage loginWithRightCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
        return new DashboardPage(driver, false);
    }
    @Step("Логирование с неверными данными")
    public LoginPage loginWithWrongCredentials(String email, String password){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setEmailName(email);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
        return new LoginPage(driver, false);
    }
}
