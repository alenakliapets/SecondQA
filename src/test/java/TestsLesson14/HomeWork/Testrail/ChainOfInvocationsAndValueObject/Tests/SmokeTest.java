package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Tests;


import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities.BaseTest;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Core.StaticProvider;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages.*;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Steps.AddNewProjectStep;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Steps.LoginStep;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.TestCaseInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SmokeTest extends BaseTest {

    //Проверка входа на сайт с верными данными эл. почты и пароля
    @Test
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithRightCredentials(properties.getEmail(), properties.getPassword());

        Assert.assertEquals(new DashboardPage(driver, false).getAllProjectsLabel().getText().
                toLowerCase(Locale.ROOT),"all projects", "Страница Projects не открылась");
    }

    //Проверка входа на сайт с незаполненным адресом эл. почты
    @Test
    public void negativeLoginTest1() {

        LoginStep loginStep = new LoginStep(driver);
        LoginPage loginPage = loginStep.loginWithWrongCredentials("", "1111");

        Assert.assertTrue(loginPage.getEmailIsRequired().isDisplayed());
    }

    //Проверка входа на сайт с незаполненным паролем и адресом электронной почты
    @Test
    public void negativeLoginTest2() {

        LoginStep loginStep = new LoginStep(driver);
        LoginPage loginPage = loginStep.loginWithWrongCredentials("", "");

        Assert.assertTrue((loginPage.getPasswordIsRequired().isDisplayed()) && (loginPage.getEmailIsRequired().isDisplayed()));
    }

    //Проверка входа на сайт с неверным паролем и адресом эл. почты
    @Test
    public void negativeLoginTest3() {

        LoginStep loginStep = new LoginStep(driver);
        LoginPage loginPage = loginStep.loginWithWrongCredentials("qwerty", "12345");

        Assert.assertTrue(loginPage.getPasswordEmailIsIncorrect().isDisplayed());
    }

    // Создание, редактирование, удаление проекта с использованием invocationCount
    @Test(invocationCount = 2)
    public void positiveAddEditDeleteTest(){
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithRightCredentials(properties.getEmail(), properties.getPassword());

        //Добавление нового проекта
        AddNewProjectStep addNewProjectStep = new AddNewProjectStep(driver);
        ProjectsPage projectsPage = addNewProjectStep.addNewProject(properties.getProjectName());

        // Кликаем кнопку редактировать проект
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

    private TestCaseInformation setupTestCase(){
        TestCaseInformation testCaseInformation = new TestCaseInformation();
        testCaseInformation.setTitle("Test Case Title");
        testCaseInformation.setSection("Test Cases"+ "\n");
        testCaseInformation.setTemplate("Test Case (Steps)"+"\n");
        testCaseInformation.setType("Regression"+"\n");
        testCaseInformation.setPriority("Critical"+"\n");
        return testCaseInformation;
    }

    @Test
    public void positiveAddTestCaseTest() throws InterruptedException {
        TestCaseInformation testCaseInformation = setupTestCase();
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithRightCredentials(properties.getEmail(), properties.getPassword());

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
        addTestCasePage.setTitleInput(testCaseInformation.getTitle()); // Название тест кейса
        Thread.sleep(2000);
        addTestCasePage.clickSectionButton();
        addTestCasePage.setSectionInput(testCaseInformation.getSection()); // Секция тест кейса
        Thread.sleep(2000);
        addTestCasePage.clickTemplateButton();
        addTestCasePage.setTemplateInput(testCaseInformation.getTemplate());// Шаблон тест кейса
        Thread.sleep(2000);
        addTestCasePage.clickTypeButton();
        addTestCasePage.setTypeInput(testCaseInformation.getType()); // Тип тест кейса
        Thread.sleep(2000);
        addTestCasePage.clickPriorityButton();
        addTestCasePage.setPriorityInput(testCaseInformation.getPriority()); // Приоритет тест кейса
        Thread.sleep(2000);
        addTestCasePage.clickAcceptButton(); // Сохранение тест кейса

        TestCaseInformationPage testCaseInformationPage = new TestCaseInformationPage(driver, false);

        Assert.assertTrue(testCaseInformationPage.getAddingSuccessfulLabel().isDisplayed());
    }
}
