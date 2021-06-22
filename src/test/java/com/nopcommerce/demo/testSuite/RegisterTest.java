package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends TestBase {

        LoginPage loginPage;
        SoftAssert softAssert;
        HomePage homePage;
        RegisterPage registerPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUp(){
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void verifyNavigateToRegisterPageSuccessfully(){
        homePage.clickOnLoginLink();
        loginPage.clicOnRegisterButton();
        String expectedRegisterText = "Register";
        String actualRegesterText = registerPage.getActualRegistrationText();
        softAssert.assertEquals(expectedRegisterText,actualRegesterText);
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    public void verifyWithInvalidCredentials(){
       homePage.clickOnLoginLink();
       loginPage.clicOnRegisterButton();
       registerPage.clickOnRegisterButton();
       String expectedEmptyFieldMessage= "First name is required.";
       String actualEmptyFieldMessage = registerPage.actualTextOfEmptyFieldMessage();
       softAssert.assertEquals(expectedEmptyFieldMessage,actualEmptyFieldMessage);
       softAssert.assertAll();
    }


    @Test(groups = {"regression"},priority = 0)
    public void verifyRegistrationSuccessfully(){
        homePage.clickOnLoginLink();
        loginPage.clicOnRegisterButton();
        registerPage.sendTextToFirstNameField("julian");
        registerPage.sendTextToLastNameField("bartoz");
        registerPage.sendTextToEmailField("julian@yahoo.com");
        registerPage.sendTextToPasswordField("julbar5236");
        registerPage.sendTextToConfirmPasswordField("julbar5236");
        registerPage.clickOnRegisterButton();
        String expectedCompletionMessage = "Your registration completed";
        String actualCompletionMessage = registerPage.getActualRegisterCompletionMessage();
        softAssert.assertEquals(expectedCompletionMessage,actualCompletionMessage);
        softAssert.assertAll();

    }
}
