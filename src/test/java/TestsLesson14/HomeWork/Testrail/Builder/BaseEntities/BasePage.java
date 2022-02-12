package TestsLesson14.HomeWork.Testrail.Builder.BaseEntities;

import TestsLesson9.Lesson9HomeWork.Core.ReadProperties;
import TestsLesson9.Lesson9HomeWork.Core.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected ReadProperties properties;
    protected Waits waits;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        properties = new ReadProperties();
        waits = new Waits(driver, properties.getTimeout());

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
