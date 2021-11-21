package TestsLesson6.Pages;

import TestsLesson6.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {

    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By firstNameInputById = By.id("first-name");
    private final static By lastNameInputById = By.id("last-name");
    private final static By postalCodeInputById = By.id("postal-code");
    private final static By cancelButtonById = By.id("cancel");
    private final static By continueButtonById = By.id("continue");


    public CheckOutPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getFirstName().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement getButtonMenu(){return driver.findElement(menuButtonById);}
    public WebElement getCart(){return driver.findElement(cartButtonByClass);}
    public WebElement getFirstName(){return driver.findElement(firstNameInputById);}
    public WebElement getLastName(){return driver.findElement(lastNameInputById);}
    public WebElement getPostalCode(){return driver.findElement(postalCodeInputById);}
    public WebElement getCancelButton(){return driver.findElement(cancelButtonById);}
    public WebElement getContinueButton(){return driver.findElement(continueButtonById);}

}
