package TestsLesson7.Tests;

import TestsLesson7.BaseEntities.BaseTest;
import TestsLesson7.Pages.CartPage;
import TestsLesson7.Pages.CheckOutPage;
import TestsLesson7.Pages.LoginPage;
import TestsLesson7.Pages.ProductsPage;
import TestsLesson7.Steps.CheckOutStep;
import TestsLesson7.Steps.LoginStep;
import TestsLesson7.Steps.OrderStep;
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

        Assert.assertEquals(new ProductsPage(driver, false).getTitleText().
                toLowerCase(Locale.ROOT),"products","Страница Products не открылась");
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
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        Assert.assertEquals(new ProductsPage(driver, false).getCartQuantityLabel().getText(),
                "1");
    }

    //Проверка появления выпадающего меню
    //при нажатии на соответствующую кнопку
    @Test
    public void positiveMenuListTest(){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickMenuButton();
        Assert.assertTrue(productsPage.getMenuList().isDisplayed());
    }

    //Проверка на появление в корзине товара после добавления его в корзину
    @Test
    public void positiveCartTest(){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        Assert.assertEquals(new CartPage(driver, false).getPurchaseInfo().getText(),
                productsPage.getFirstProduct().getText());
    }
    //Проверка кнопки удаления товара из корзины
    @Test
    public void negativeCartRemoveTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickRemoveButton();

        Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class, () ->cartPage.getPurchaseInfo().isDisplayed());
    }

    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля индекса
    @Test
    public void positiveCheckInInfoTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutStep checkOutStep = new CheckOutStep(driver);
        checkOutStep.checkOut("Aaaa", "Ssss", "");

        Assert.assertEquals(new CheckOutPage(driver, false).getErrorLabel().getText(),
                "Error: Postal Code is required");
        }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля фамилии
    @Test
    public void positiveCheckInInfoTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutStep checkOutStep = new CheckOutStep(driver);
        checkOutStep.checkOut("Aaaa", "", "Sss");

        Assert.assertEquals(new CheckOutPage(driver, false).getErrorLabel().getText(),
                "Error: Last Name is required");
    }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля имени
    @Test
    public void positiveCheckInInfoTest3() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutStep checkOutStep = new CheckOutStep(driver);
        checkOutStep.checkOut("", "DDDdd", "Sss");

        Assert.assertEquals(new CheckOutPage(driver, false).getErrorLabel().getText(),
                "Error: First Name is required");
    }
    //Проверка возвращения на страницу корзины
    //при нажатии кнопки cancel на странице check out
    @Test
    public void positiveCheckOutCancel() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Backpack");

        ProductsPage productsPage = new ProductsPage(driver, false);
        productsPage.clickCartButton();

        CartPage cartPage = new CartPage(driver, false);
        cartPage.clickCheckOutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver, false);

        checkOutPage.clickCancel();
        Assert.assertTrue(cartPage.isPageOpened());
    }
    }