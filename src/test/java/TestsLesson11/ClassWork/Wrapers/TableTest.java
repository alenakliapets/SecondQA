package TestsLesson11.ClassWork.Wrapers;

import TestsLesson10.HomeWork.BaseTest;
import TestsLesson9.Lesson9HomeWork.Steps.LoginStep;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TableTest extends BaseTest {

    @Test
    public void tableTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());
        driver.get("https://alenaqaz.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        System.out.println(table.rowsCount());
        System.out.println(table.getElementFromCell(9,0).getText());
        UIElement editButton = table.getElementFromCell("Test", 0, 1);
        editButton.click();
       // Thread.sleep(5000);

    }
}
