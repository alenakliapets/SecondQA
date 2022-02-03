package TestsLesson12.HomeWork;

import TestsLesson9.Lesson9HomeWork.Core.Waits;
import org.openqa.selenium.*;
import java.util.List;

public class MyUIElement implements WebElement {
    private By by;
    private WebDriver driver;
    private WebElement webElement;
    private Waits waits;
    private JavascriptExecutor javascriptExecutor;

    public MyUIElement(WebDriver driver, By by) {
        this.by = by;
        this.driver = driver;
        this.webElement = driver.findElement(by);
        this.javascriptExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver, 10);
    }
    public MyUIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        this.javascriptExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver, 10);
    }

    @Override
    public void click() {
        try{webElement.click();}
        catch (ElementNotVisibleException elementNotVisibleException){
            try {scrollIntoView();
                waits.waitForClickable(webElement);
                webElement.click();}
            catch (Exception e){
                javascriptExecutor.executeScript("arguments[0].click();", webElement);
            }
        }
    }

    @Override
    public void submit() {
        scrollIntoView();
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        scrollIntoView();
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }

    public void scrollIntoView(){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public WebElement getParent (){
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", webElement);
    }
}
