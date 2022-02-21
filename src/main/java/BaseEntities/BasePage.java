package BaseEntities;


import Core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        properties = new ReadProperties();
        PageFactory.initElements(this.driver, this);
        if (openPageByUrl){
            openPage();
        }
        waitForOpen();
    }
    protected  void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator){
            throw  new AssertionError("Page was not opened");
        }
    }
}
