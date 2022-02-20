package BaseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getLogger(this);

    public BaseStep(WebDriver driver){
        this.driver = driver;
    }
}
