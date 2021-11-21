package TestsLesson6.Tests;

import TestsLesson6.BaseEntities.BaseTest;
import TestsLesson6.Pages.LoginPage;
import TestsLesson6.Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {
    @Test
    public void positiveLoginTest() {

        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);

        Assert.assertEquals(productsPage.getTitleText(),"PRODUCTS","Страница Products не открылась");
    }

    @Test
    public void negativeLoginTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("fffff");
        loginPage.setPassword("rrrrr");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    //Homework CartPage, CheckOutPage, ProductsPage and all tests below
    @Test
    public void positiveCartIconTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();

        Assert.assertEquals(productsPage.getCartQuantityLabel().getText(), "1");
    }
    }