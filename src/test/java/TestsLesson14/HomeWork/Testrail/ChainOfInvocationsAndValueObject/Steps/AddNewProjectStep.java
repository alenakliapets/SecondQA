package TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Steps;

import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.BaseEntities.BaseStep;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages.AddProjectPage;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages.DashboardPage;
import TestsLesson14.HomeWork.Testrail.ChainOfInvocationsAndValueObject.Pages.ProjectsPage;
import org.openqa.selenium.WebDriver;

public class AddNewProjectStep extends BaseStep {
    public AddNewProjectStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage addNewProject(String projectName){
        //Кликаем добавить новый проект
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.getAddNewProject().click();

        //Вводим имя нового проекта и кликаем добавить
        AddProjectPage addProjectPage = new AddProjectPage(driver, false);
        addProjectPage.setProjectName(projectName);
        addProjectPage.clickAddProjectButton();
        return new ProjectsPage(driver, false);
    }
}
