package TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Tests;

import BaseEntities.BaseTest;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.CartPage;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.CheckOutPage;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.LoginPage;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Pages.ProductsPage;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.Steps.LoginStep;
import TestsLesson14.HomeWork.SauceDemo.PageFactoryAndChainOfInvocationsAndValueObject.UserForCheckOut;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SmokeTest extends BaseTest {

    //Проверка открытия страницы продуктов
    //после введения верных данных логина и пароля
    @Test
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        ProductsPage productsPage = loginStep.loginWithRightCredentials(properties.getUsername(), properties.getPassword());

        Assert.assertEquals(productsPage.getTitleText().toLowerCase(Locale.ROOT),"products","Страница Products не открылась");
    }

    //Проверка появления элемента с ошибкой и текста в нем
    //после введения некорректрных данных в логин и пароль
    @Test
    public void negativeLoginTest(){
        LoginStep loginStep = new LoginStep(driver);
        LoginPage loginPage = loginStep.loginWithWrongCredentials("fffff", "rrrrr");

        Assert.assertEquals(loginPage.errorLabel.getText(),
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
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");

        Assert.assertEquals(productsPage.cartQuantityLabel.getText(), "1");
    }

    //Проверка появления выпадающего меню
    //при нажатии на соответствующую кнопку
    @Test
    public void positiveMenuListTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickMenuButton();
        Assert.assertTrue(productsPage.menuList.isDisplayed());
    }

    //Проверка на появление в корзине товара после добавления его в корзину
    @Test
    public void positiveCartTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        Assert.assertEquals(cartPage.purchaseInfo.getText(), productsPage.firstProductButton.getText());
    }
    //Проверка кнопки удаления товара из корзины
    @Test
    public void negativeCartRemoveTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        cartPage.clickRemoveButton();

        Assert.assertThrows(org.openqa.selenium.NoSuchElementException.class, () ->cartPage.purchaseInfo.isDisplayed());
    }

    private UserForCheckOut setupUser(){
        UserForCheckOut user = new UserForCheckOut();
        user.setFirstname("Alex");
        user.setLastname("Ivanov");
        user.setPostalCode("111");
        return user;
    }

    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля индекса
    @Test
    public void positiveCheckInInfoTest1() {
        UserForCheckOut user = setupUser();
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();

        checkOutPage.setFirstName(user.getFirstname());
        checkOutPage.setLastName(user.getLastname());
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.errorLabel.getText(), "Error: Postal Code is required");
        }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля фамилии
    @Test
    public void positiveCheckInInfoTest2() {
        UserForCheckOut user = setupUser();
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();

        checkOutPage.setFirstName(user.getFirstname());
        checkOutPage.setPostalCode(user.getPostalCode());
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.errorLabel.getText(), "Error: Last Name is required");
    }
    //Проверка появления элемента с ошибкой на странице check out
    //при отсутствии заполненного поля имени
    @Test
    public void positiveCheckInInfoTest3() {
        UserForCheckOut user = setupUser();
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();

        checkOutPage.setLastName(user.getLastname());
        checkOutPage.setPostalCode(user.getPostalCode());
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.errorLabel.getText(), "Error: First Name is required");
    }
    //Проверка возвращения на страницу корзины
    //при нажатии кнопки cancel на странице check out
    @Test
    public void positiveCheckOutCancel() {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage = loginPage.clickLoginButtonWithRightCredentials();

        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        CartPage cartPage = productsPage.clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickCheckOutButton();

        checkOutPage.clickCancel();
        Assert.assertTrue(cartPage.isPageOpened());
    }
    }