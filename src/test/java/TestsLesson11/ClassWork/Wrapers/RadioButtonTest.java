package TestsLesson11.ClassWork.Wrapers;

import TestsLesson10.HomeWork.BaseTest;
import TestsLesson9.Lesson9HomeWork.Steps.LoginStep;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getEmail(), properties.getPassword());
        driver.get("https://alenaqaz.testrail.io/index.php?/admin/projects/add");
        RadioButton radioButton = new RadioButton(driver, By.xpath("//*[@name = 'suite_mode']"));
        //radioButton.selectByIndex(3);
        radioButton.selectByText("Use multiple test suites to manage cases");

        Thread.sleep(5000);

    }
}
