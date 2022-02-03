package TestsLesson12.HomeWork;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseTest;
import TestsLesson9.Lesson9HomeWork.Pages.ProjectsPage;
import TestsLesson9.Lesson9HomeWork.Steps.AddNewProjectStep;
import TestsLesson9.Lesson9HomeWork.Steps.LoginStep;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WrapperTests extends BaseTest {

    @Test
    public void checkBoxTest() throws InterruptedException {

        //Авторизация
        LoginStep loginStep = new LoginStep(driver);
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

        Thread.sleep(3000);
    }

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

        Thread.sleep(2000);
    }

    @Test
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

        Thread.sleep(2000);
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

        Thread.sleep(2000);
    }
}
