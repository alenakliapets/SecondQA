package TestsLesson14.HomeWork.SauceDemo.Builder.Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    public WebElement titleLabel;
    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;
    @FindBy(className = "bm-menu")
    public WebElement menuList;
    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartQuantityLabel;
    @FindBy(className = "product_sort_container")
    public WebElement filterSelect;
    @FindBy(partialLinkText = "Backpack")
    public WebElement firstProductButton;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addFirstProductCart;
    @FindBy(xpath = "//*[@src = '/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']")
    public WebElement photoFirstProductButton;

    private final static String endPoint = "inventory.html";
    private final static String addFirstProductCartButton =
           "//div[.='replace']/ancestor::div[@class='inventory_item_description']//button";

    public ProductsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
driver.get(properties.getURL() + endPoint);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return titleLabel.isDisplayed();}
        catch (NoSuchElementException ex){
            return false;
        }
    }
    public WebElement getAddToCartButtonForProduct(String productName){
        return driver.findElement(By.xpath(addFirstProductCartButton.replace("replace", productName)));}
    public String  getTitleText(){return titleLabel.getText();}
    //атомарные методы по работе с элементами
    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver, false);
    }
    public void clickAddToCartButton(String productName){
        getAddToCartButtonForProduct(productName).click();
    }
    public void clickMenuButton(){
        menuButton.click();
    }
}
