package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.security.x509.X400Address;

import javax.rmi.CORBA.Util;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
    WebElement welcomeText;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//li[contains(text(),'No customer account found')]")
    WebElement invalidLoginMessage;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement validEmail;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement validPassword;

    @FindBy(xpath = "//button[@class='button-1 register-button']")
    WebElement registerButton;

    public String getActualText(){
        log.info("Gettig text from loginpage" + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void enterInvalidEmail(String value){
        log.info("enter the email address"+ value+ "send to text on"+email.toString()) ;
        sendTextToElement(email,value);
    }

    public void enterInvalidPassword(String value){
        log.info("enter the password"+ value+ "send to text on"+password.toString()) ;
        sendTextToElement(password,value);
    }

    public void clickOnLoginButton(){

        clickOnElement(loginButton);
        log.info("click on login button"+ loginButton.toString());
    }

    public String getInvalidMessageActualText(){
        log.info("Getting text from Invalid message "+ invalidLoginMessage.toString());
        return getTextFromElement(invalidLoginMessage);
    }

    public void enterValidEmail(String value){
        log.info("enter the valid email"+ value+ "send to text on"+validEmail.toString()) ;
        sendTextToElement(validEmail,value);
    }

    public void entervalidPassword(String value){
        log.info("enter the valid password"+ value+ "send to text on"+validPassword.toString()) ;
        sendTextToElement(validPassword,value);
    }

    public void clicOnRegisterButton(){

        clickOnElement(registerButton);
        log.info("click on register button"+registerButton.toString());
    }


}
