package TestsLesson10.HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;
    private Waits wait;

    public BrowserService(){
        switch (properties.getBrowser().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                HashMap <String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", properties.getDownloadDir());

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);

                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        wait = new Waits(driver, properties.getTimeout());

    }
    public WebDriver getDriver() {
        return driver;
    }
}
