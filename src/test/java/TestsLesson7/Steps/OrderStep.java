package TestsLesson7.Steps;

import TestsLesson7.BaseEntities.BaseStep;
import TestsLesson7.Pages.ProductsPage;
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
