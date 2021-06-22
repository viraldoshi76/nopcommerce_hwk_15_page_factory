package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ComputerTest extends TestBase {

    LoginPage loginPage;
    SoftAssert softAssert;
    HomePage homePage;
    RegisterPage registerPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    NotebooksPage notebooksPage;

    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void setUp() {
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        notebooksPage = new NotebooksPage();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void veirfyClickOnComputers(){
        homePage.clickOnComputerLink();
        String expectedComputerText = "Computers";
        String actualComputerText = computerPage.navigateToComputerPageSuccessfully();
        softAssert.assertEquals(expectedComputerText,actualComputerText);
        softAssert.assertAll();

    }

    @Test(groups = {"smoke","regression"})
    public void verifyClickAndNavigateToDesktopLink(){
        homePage.hooverOnComputerLink();
        homePage.hooverAndClickOnDesktopLink();
        String expectedDesktopTitleText = "Desktops";
        String actualDesktopTitleText = desktopsPage.getTextFromDesktopPageTitle();
        softAssert.assertEquals(expectedDesktopTitleText,actualDesktopTitleText);
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyClickAndNavigateToNotebooksLink(){
        homePage.hooverOnComputerLink();
        homePage.hooverAndClickOnNotebooksLink();
        String expectedNotebooksTitleText = "Notebooks";
        String actualNotebooksTitleText = notebooksPage.navigateToNotebooksPageSuccessfully();
        softAssert.assertEquals(expectedNotebooksTitleText,actualNotebooksTitleText);
        softAssert.assertAll();

    }





}
