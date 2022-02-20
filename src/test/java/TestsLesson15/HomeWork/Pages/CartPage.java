package TestsLesson15.HomeWork.Pages;


import BaseEntities.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;
    @FindBy(id = "continue-shopping")
    public WebElement cartButton;
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    public WebElement checkOutButton;
    @FindBy(className = "inventory_item_name")
    public WebElement purchaseInfo;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removePurchaseButton;

    public CartPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get("https://www.saucedemo.com/cart.html");
    }

    @Override
    public boolean isPageOpened() {
        logger.info("Проверка, открылась ли страница CartPage");
        try{
            return checkOutButton.isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    //атомарные методы по работе с элементами
    public void clickRemoveButton(){
        removePurchaseButton.click();
    }
    public CheckOutPage clickCheckOutButton(){
        checkOutButton.click();
        return new CheckOutPage(driver,false);
    }
}
