package TestsLesson6.Pages;

import TestsLesson6.BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private final static By titleLabelByClass = By.className("title");
    private final static By menuButtonById = By.id("react-burger-menu-btn");
    private final static By menuListByClass = By.className("bm-menu");
    private final static By cartButtonByClass = By.className("shopping_cart_link");
    private final static By cartQuantityLabelByClass = By.className("shopping_cart_badge");
    private final static By filterSelectByClass = By.className("product_sort_container");
    private final static By firstProductButtonByPartialText = By.partialLinkText("Backpack");
    private final static By addFirstProductCartButtonById = By.id("add-to-cart-sauce-labs-backpack");
    private final static By photoFirstProductButtonByXpath =
            By.xpath("//*[@src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']");

    public ProductsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Override
    public boolean isPageOpened() {
        try{
            return getTitleLabel().isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    public WebElement getTitleLabel(){return driver.findElement(titleLabelByClass);}
    public String  getTitleText(){return getTitleLabel().getText();}
    public WebElement getButtonMenu(){return driver.findElement(menuButtonById);}
    public WebElement getMenuList(){return driver.findElement(menuListByClass);}
    public WebElement getCart(){return driver.findElement(cartButtonByClass);}
    public WebElement getCartQuantityLabel(){return driver.findElement(cartQuantityLabelByClass);}
    public WebElement getFilter(){return driver.findElement(filterSelectByClass);}
    public WebElement getFirstProduct(){return driver.findElement(firstProductButtonByPartialText);}
    public WebElement getAddFirstProductCart(){return driver.findElement(addFirstProductCartButtonById);}
    public WebElement getPhotoFirstProduct(){return driver.findElement(photoFirstProductButtonByXpath);}

    public void clickCartButton(){
        getCart().click();
    }
    public void clickAddToCartButton(){
        getAddFirstProductCart().click();
    }
    public void clickMenuButton(){
        getButtonMenu().click();
    }
}
