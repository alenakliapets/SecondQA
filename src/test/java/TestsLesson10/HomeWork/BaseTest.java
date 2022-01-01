package TestsLesson10.HomeWork;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;
    protected ReadProperties properties;
    protected Waits waits;

    @BeforeTest
    public void setupTest(){
        properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod(){
        driver = new BrowserService().getDriver();
        waits = new Waits(driver, properties.getTimeout());
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
