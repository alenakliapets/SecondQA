package Lesson13;

import TestsLesson12.HomeWork.CheckBoxWrap;
import TestsLesson12.HomeWork.DropDownMenuWrap;
import TestsLesson12.HomeWork.RadioButtonWrap;
import TestsLesson9.Lesson9Classwork.Retry;
import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseTest;
import TestsLesson9.Lesson9HomeWork.Pages.ProjectsPage;
import TestsLesson9.Lesson9HomeWork.Steps.AddNewProjectStep;
import TestsLesson9.Lesson9HomeWork.Steps.LoginStep;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureAnnotationsTests extends BaseTest {
public int attempt = 1;
    @Feature("Feature_1")
    @Story("Story_1")
    @Link(value = "#_testng", url = "https:docs.qameta.io/allure/#_testng")
    @Description("чек бокс тест")
    @Flaky
    @Test(retryAnalyzer = Retry.class)
    public void checkBoxTest() throws InterruptedException {

        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        Thread.sleep(2000);
        loginStep.login(properties.getEmail(), properties.getPassword());

        //Добавление нового проекта
        AddNewProjectStep addNewProjectStep = new AddNewProjectStep(driver);
        addNewProjectStep.addNewProject(properties.getProjectName());

        // Кликаем кнопку редактировать проект
        ProjectsPage projectsPage = new ProjectsPage(driver,false);
        projectsPage.clickEditButton();

        //Создание нового элемента чек бокса со страницы редактирования проекта
        CheckBoxWrap checkBox = new CheckBoxWrap(driver, By.id("show_announcement"));
        checkBox.changeState(true); // Нам нужно, чтобы чек бокс был нажат

        if (attempt<3){
            attempt++;
            throw new NullPointerException();
        }

        Assert.assertTrue(true);
    }

    @Features(value={@Feature("Feature_1"), @Feature("Feature_2")})
    @Story("Story_1")
    @Link(name="#_testng", type = "mylink")
    @Description("Первый радио баттон тест")
    @TmsLink("1")
    @Issue("2")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void radioButtonByIndexTest() throws InterruptedException {
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        // Кликаем кнопку редактировать проект
        ProjectsPage projectsPage = new ProjectsPage(driver,true);
        projectsPage.clickEditButton();

        //Создаем элемент radio button и кликаем на элементе с индексом 2
        RadioButtonWrap radioButton = new RadioButtonWrap(driver,By.xpath("//*[@name = 'suite_mode']"));
        radioButton.selectByIndex(2);

      //  Thread.sleep(2000);
    }

    @Test(description = "Второй радио баттон тест")
    public void radioButtonByTextTest() throws InterruptedException {
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        // Кликаем кнопку редактировать проект
        ProjectsPage projectsPage = new ProjectsPage(driver,true);
        projectsPage.clickEditButton();

        //Создаем элемент radio button и кликаем на элементе с нужным текстом
        RadioButtonWrap radioButton = new RadioButtonWrap(driver,By.xpath("//*[@name = 'suite_mode']"));
        radioButton.selectByText("Use multiple test suites to manage cases");

      //  Thread.sleep(2000);
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());

        //Создаем элемент дроп дауна, на лекции было сказано выбрать любое меню такого типа на сайте,
        DropDownMenuWrap dropDownMenu = new DropDownMenuWrap(driver,
                By.xpath("//*[@id = 'helpDropdown']//a[contains(@class, 'dropdown-menu-link')]"));

        // Кликаем элемент для появления меню на странице
        dropDownMenu.dropDownMenuClick(By.id("navigation-menu"));

        // Выбираем нужную строку меню
        dropDownMenu.selectByText("Keyboard Shortcuts");

     //   Thread.sleep(2000);
    }
}
