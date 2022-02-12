package TestsLesson14.HomeWork.SauceDemo.Builder.Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;
    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;
    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;
    @FindBy(id = "cancel")
    public WebElement cancelButton;
    @FindBy(id = "continue")
    public WebElement continueButton;
    @FindBy(tagName = "h3")
    public WebElement errorLabel;

    private final static String endPoint = "checkout-step-one.html";

    public CheckOutPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endPoint);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return firstNameInput.isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    //атомарные методы по работе с элементами
    public void setFirstName(String text){
        firstNameInput.sendKeys(text);
    }
    public void setLastName(String text){
        lastNameInput.sendKeys(text);
    }
    public void setPostalCode(String text){
        postalCodeInput.sendKeys(text);
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void clickCancel(){
        cancelButton.click();
    }
}
