package TestsLesson6.Pages;

import TestsLesson6.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By continueShoppingButtonById = By.id("continue-shopping");
    private final static By checkOutButtonById = By.id("checkout");

    public CartPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get("https://www.saucedemo.com/cart.html");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getCheckOut().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    public WebElement getButtonMenu(){return driver.findElement(menuButtonById);}
    public WebElement getCart(){return driver.findElement(cartButtonByClass);}
    public WebElement getContinueShopping(){return driver.findElement(continueShoppingButtonById);}
    public WebElement getCheckOut(){return driver.findElement(checkOutButtonById);}
}
