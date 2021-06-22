package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement logInLink;

    @FindBys({@FindBy(xpath = "//ul[@class='top-menu notmobile']//a")})
    List<WebElement> computerDropDown;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[@href='/computers']")
    WebElement computerLink;

    @FindBy(xpath = "//a[contains(text(),'Desktops')]")
    WebElement desktopTabLink;

    @FindBy(xpath = "//a[contains(text(),'Notebooks')]")
    WebElement notebooksTabLink;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutText;




    public void clickOnLoginLink() {
        clickOnElement(logInLink);
        log.info("click on loginlink"+ logInLink.toString());
    }

    public void clickOnComputerLink() {
        clickOnElement(computerLink);
        log.info("click on computerLink"+ computerLink.toString());
    }

    public void hooverOnComputerLink(){
        mouseHoverToElement(computerLink);
        log.info("mouse hoover on loginlink"+ logInLink.toString());
    }

    public void hooverAndClickOnDesktopLink(){
        mouseHoverToElementAndClick(desktopTabLink);
        log.info("mouse hoover and click on desktoplink" + desktopTabLink);
    }

    public void hooverAndClickOnNotebooksLink(){
        mouseHoverToElementAndClick(notebooksTabLink);
        log.info("mouse hoover and click on notebookslink" + notebooksTabLink);

    }

    public String logoutTextToVerify(){
        return getTextFromElement(logoutText);
    }


}
