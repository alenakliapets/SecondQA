package TestsLesson7.Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;

    public BrowserService(){
        switch (properties.getBrowser().toLowerCase()){
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-gpu"); //отключение графического процессора
                chromeOptions.addArguments("window-size=1920,1200"); //размер экрана
                chromeOptions.addArguments("start-maximized");  // увеличивает окно браузера
                chromeOptions.setHeadless(properties.getHeadLess());

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                driver = new SafariDriver();
                break;
            default:
                throw new AssertionError("Данный браузер не поддерживается");
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
