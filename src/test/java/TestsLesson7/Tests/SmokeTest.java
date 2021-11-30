package TestsLesson7.Tests;

import TestsLesson7.BaseEntities.BaseTest;
import TestsLesson7.Pages.CartPage;
import TestsLesson7.Pages.CheckOutPage;
import TestsLesson7.Pages.LoginPage;
import TestsLesson7.Pages.ProductsPage;
import TestsLesson7.Steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SmokeTest extends BaseTest {

    //Проверка открытия страницы продуктов
    //после введения верных данных логина и пароля
    @Test
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        ProductsPage productsPage = new ProductsPage(driver, false);

        Assert.assertEquals(productsPage.getTitleText().toLowerCase(Locale.ROOT),"products","Страница Products не открылась");
    }

    //Проверка появления элемента с ошибкой и текста в нем
    //после введения некорректрных данных в логин и пароль
    @Test
    public void negativeLoginTest(){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("fffff", "rrrrr");

        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    //Homework CartPage, CheckOutPage, ProductsPage and all tests below
    //Проверка появления на значке с корзиной символа "1"
    //при добавлении одного товара
    @Test
    public void positiveCartIconTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");

        Assert.assertEquals(productsPage.getCartQuantityLabel().getText(), "1");
    }

    //Проверка появления выпадающего меню
    //при нажатии на соответствующую кнопку
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

    //Проверка на появление в корзине товара после добавления его в корзину
    @Test
    public void positiveCartTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);

        Assert.assertEquals(cartPage.getPurchaseInfo().getText(), productsPage.getFirstProduct().getText());
    }
    //Проверка кнопки удаления товара из корзины
    @Test
    public void negativeCartRemoveTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickRemoveButton();

        Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class, () ->cartPage.getPurchaseInfo().isDisplayed());
    }

    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля индекса
    @Test
    public void positiveCheckInInfoTest1() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setFirstName("Aaa");
        checkOutPage.setLastName("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: Postal Code is required");
        }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля фамилии
    @Test
    public void positiveCheckInInfoTest2() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setFirstName("Aaa");
        checkOutPage.setPostalCode("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: Last Name is required");
    }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля имени
    @Test
    public void positiveCheckInInfoTest3() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.setLastName("Aaa");
        checkOutPage.setPostalCode("Sss");
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getErrorLabel().getText(), "Error: First Name is required");
    }
    //Проверка возвращения на страницу корзины
    //при нажатии кнопки cancel на странице check out
    @Test
    public void positiveCheckOutCancel() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.clickCancel();
        Assert.assertTrue(cartPage.isPageOpened());
    }
    }