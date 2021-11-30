package TestsLesson6.Steps;

import TestsLesson6.BaseEntities.BaseStep;
import TestsLesson6.Pages.ProductsPage;
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
