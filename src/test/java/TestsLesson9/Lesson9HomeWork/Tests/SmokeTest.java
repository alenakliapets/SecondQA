package TestsLesson9.Lesson9HomeWork.Tests;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseTest;
import TestsLesson9.Lesson9HomeWork.Core.StaticProvider;
import TestsLesson9.Lesson9HomeWork.Pages.*;
import TestsLesson9.Lesson9HomeWork.Steps.AddNewProjectStep;
import TestsLesson9.Lesson9HomeWork.Steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Locale;

public class SmokeTest extends BaseTest {

    //Проверка входа на сайт с верными данными эл. почты и пароля
    @Test
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        Assert.assertEquals(new DashboardPage(driver, false).getAllProjectsLabel().getText().
                toLowerCase(Locale.ROOT),"all projects", "Страница Projects не открылась");
    }

    //Проверка входа на сайт с незаполненным адресом эл. почты
    @Test
    public void negativeLoginTest1() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("", "1111");

        LoginPage loginPage = new LoginPage(driver, false);
        Assert.assertTrue(loginPage.getEmailIsRequired().isDisplayed());
    }

    //Проверка входа на сайт с незаполненным паролем и адресом электронной почты
    @Test
    public void negativeLoginTest2() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("", "");

        LoginPage loginPage = new LoginPage(driver, false);
        Assert.assertTrue((loginPage.getPasswordIsRequired().isDisplayed()) && (loginPage.getEmailIsRequired().isDisplayed()));
    }

    //Проверка входа на сайт с неверным паролем и адресом эл. почты
    @Test
    public void negativeLoginTest3() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("qwerty", "12345");

        LoginPage loginPage = new LoginPage(driver, false);
        Assert.assertTrue(loginPage.getPasswordEmailIsIncorrect().isDisplayed());
    }

    // Создание, редактирование, удаление проекта с использованием invocationCount
    @Test(invocationCount = 5)
    public void positiveAddEditDeleteTest(){
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        //Добавление нового проекта
        AddNewProjectStep addNewProjectStep = new AddNewProjectStep(driver);
        addNewProjectStep.addNewProject(properties.getProjectName());

        // Кликаем кнопку редактировать проект
        ProjectsPage projectsPage = new ProjectsPage(driver,false);
        projectsPage.clickEditButton();

        //Очищаем поле с именем проекта, вводим новое отредактированное имя и кликаем сохранить
        EditProject editProject = new EditProject(driver, false);
        editProject.clearProjectName();
        editProject.setNewProjectName(properties.getEditedProjectName());
        editProject.clickSaveButton();

        //Кликаем на странице проектов кнопку удалить проект, подтверждаем свое решение и кливаем ОК
        projectsPage.clickDeleteButton();
        projectsPage.clickConfirmationDeletingButton();
        projectsPage.clickConfirmationOKButton();

        //Проверяем, есть ли на странице проект с редактируемым именем после его удаления
       Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class,
               () ->projectsPage.getEditedProject().isDisplayed());
    }

    @Test(dataProvider = "dataForTestCase", dataProviderClass = StaticProvider.class)
    public void positiveAddTestCaseTest(String title, String section, String template,
                                        String type, String priority) throws InterruptedException {
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        //Добавление нового проекта
        AddNewProjectStep addNewProjectStep = new AddNewProjectStep(driver);
        addNewProjectStep.addNewProject(properties.getProjectNameFor6Test());

        //Переход на страницу информации о проекте
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getProjectInformation().click();

        //Переход на страницу добавления нового тест кейса
        ProjectInformationPage projectInformationPage = new ProjectInformationPage(driver, false);
        projectInformationPage.clickAddTestCase();

        //Введение данных нового тест кейса
        AddTestCasePage addTestCasePage = new AddTestCasePage(driver, false);
        addTestCasePage.setTitleInput(title); // Название тест кейса
        addTestCasePage.clickSectionButton();
        addTestCasePage.setSectionInput(section); // Секция тест кейса
        addTestCasePage.clickTemplateButton();
        addTestCasePage.setTemplateInput(template);// Шаблон тест кейса
        addTestCasePage.clickTypeButton();
        addTestCasePage.setTypeInput(type); // Тип тест кейса
        addTestCasePage.clickPriorityButton();
        addTestCasePage.setPriorityInput(priority); // Приоритет тест кейса

        addTestCasePage.clickAcceptButton(); // Сохранение тест кейса

        TestCaseInformationPage testCaseInformationPage = new TestCaseInformationPage(driver, false);

        Assert.assertTrue(testCaseInformationPage.getAddingSuccessfulLabel().isDisplayed());
    }
}
