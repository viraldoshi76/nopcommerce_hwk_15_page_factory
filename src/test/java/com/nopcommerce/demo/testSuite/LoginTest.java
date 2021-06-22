package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUp(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void verifyUserShouldNavigateToLoginPage(){
        homePage.clickOnLoginLink();
        String expectedText = "Welcome, Please Sign In!";
        String actualText = loginPage.getActualText();
        softAssert.assertEquals(expectedText,actualText);
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyInvalidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterInvalidEmail("root1@gmail.com");
        loginPage.enterInvalidPassword("iuoerlf12548");
        loginPage.clickOnLoginButton();
        String expectedInvalidMessage = "No customer account found";
        String actualInvalidMessage = loginPage.getInvalidMessageActualText();
        softAssert.assertEquals(expectedInvalidMessage,actualInvalidMessage);
        softAssert.assertAll();
    }

    @Test(groups = {"regression"},priority = 1)
    public void verifyvalidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterInvalidEmail("jack@gmail.com");
        loginPage.enterInvalidPassword("jack1234");
        loginPage.clickOnLoginButton();
        String expectedLogOutText = "Log out";
        String actualLogOutText = homePage.logoutTextToVerify();
        softAssert.assertEquals(expectedLogOutText,actualLogOutText);
        softAssert.assertAll();



    }




}
