package TestsLesson9.Lesson9HomeWork.Steps;

import TestsLesson9.Lesson9HomeWork.BaseEntities.BaseStep;
import TestsLesson9.Lesson9HomeWork.Pages.AddProjectPage;
import TestsLesson9.Lesson9HomeWork.Pages.DashboardPage;
import org.openqa.selenium.WebDriver;

public class AddNewProjectStep extends BaseStep {
    public AddNewProjectStep(WebDriver driver) {
        super(driver);
    }

    public void addNewProject(String projectName){
        //Кликаем добавить новый проект
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.getAddNewProject().click();

        //Вводим имя нового проекта и кликаем добавить
        AddProjectPage addProjectPage = new AddProjectPage(driver, false);
        addProjectPage.setProjectName(projectName);
        addProjectPage.clickAddProjectButton();
    }
}
