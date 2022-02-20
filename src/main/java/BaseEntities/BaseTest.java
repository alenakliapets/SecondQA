package BaseEntities;

import Core.BrowserService;
import Core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;
    public ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    @BeforeTest
    public void setupTest(){
        properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod(){
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
