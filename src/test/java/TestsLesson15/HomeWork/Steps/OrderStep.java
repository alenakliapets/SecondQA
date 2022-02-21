package TestsLesson15.HomeWork.Steps;

import BaseEntities.BaseStep;
import TestsLesson15.HomeWork.Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class OrderStep extends BaseStep {
    public OrderStep(WebDriver driver) {
        super(driver);
    }

    public void orderOneProduct(String productName){
        logger.info("Добавление в корзину продукта");
        ProductsPage productsPage = new ProductsPage(driver, true);
        productsPage.clickAddToCartButton(productName);
    }
    public void addToCart(String productName){

    }
}
