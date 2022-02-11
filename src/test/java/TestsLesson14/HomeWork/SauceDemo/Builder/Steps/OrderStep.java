package TestsLesson14.HomeWork.SauceDemo.Builder.Steps;

import BaseEntities.BaseStep;
import TestsLesson14.HomeWork.SauceDemo.Builder.Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class OrderStep extends BaseStep {
    public OrderStep(WebDriver driver) {
        super(driver);
    }

    public void orderOneProduct(String productName){
        ProductsPage productsPage = new ProductsPage(driver, true);
        productsPage.clickAddToCartButton(productName);
    }
    public void addToCart(String productName){

    }
}
