package TestsLesson6.BaseEntities;

import Core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected ReadProperties properties;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        properties = new ReadProperties();
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
