package TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Steps;

import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.ProductsPage;
import BaseEntities.BaseStep;
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
