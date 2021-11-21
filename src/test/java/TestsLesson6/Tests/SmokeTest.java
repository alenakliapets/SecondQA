package TestsLesson6.Tests;

import TestsLesson6.BaseEntities.BaseTest;
import TestsLesson6.Pages.CartPage;
import TestsLesson6.Pages.CheckOutPage;
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

    @Test
    public void positiveMenuListTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickMenuButton();
        Assert.assertTrue(productsPage.getMenuList().isDisplayed());
    }
    @Test
    public void positiveCartTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);

        Assert.assertEquals(cartPage.getPurchaseInfo().getText(), productsPage.getFirstProduct().getText());
    }
    @Test
    public void negativeCartRemoveTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickRemoveButton();

        Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class, () ->cartPage.getPurchaseInfo().isDisplayed());
    }
    @Test
    public void positiveCheckInInfoTest1() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setFirstName("Aaa");
        checkOutPage.setLastName("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: Postal Code is required");
        }
    @Test
    public void positiveCheckInInfoTest2() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setFirstName("Aaa");
        checkOutPage.setPostalCode("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: Last Name is required");
    }
    @Test
    public void positiveCheckInInfoTest3() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setLastName("Aaa");
        checkOutPage.setPostalCode("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: First Name is required");
    }
    @Test
    public void positiveCheckOutCancel() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton();
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.clickCancel();
        Assert.assertTrue(cartPage.isPageOpened());
    }
    }