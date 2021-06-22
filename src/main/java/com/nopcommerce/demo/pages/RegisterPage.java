package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.soap.SAAJResult;

public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement actualEmptyFieldMessage;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath = "//div[@class='result']")
    WebElement registrationMessage;

    @FindBy(xpath = "//div[@class='page-title']")
    WebElement registerText;

    public void clickOnRegisterButton(){

        clickOnElement(registerButton);
        log.info("click on register button"+ registerButton.toString());
    }

    public String getActualRegistrationText(){
        log.info("getting text from register page"+ registerText.toString());
        return getTextFromElement(registerText);
    }

    public String actualTextOfEmptyFieldMessage(){
        log.info("getting text from emptyfield message"+ actualEmptyFieldMessage.toString());
        return getTextFromElement(actualEmptyFieldMessage);
    }

    public void sendTextToFirstNameField(String value){
        log.info("enter the first name"+ value+ "sending text to firstname field"+firstName.toString());
        sendTextToElement(firstName,value);
    }

    public void sendTextToLastNameField(String value){
        log.info("enter the last name"+ value+ "sending text to lastname field"+lastName.toString());
        sendTextToElement(lastName,value);
    }

    public void sendTextToEmailField(String value){
        log.info("enter the email"+ value+ "sending text to firstname field"+email.toString());
        sendTextToElement(email,value);
    }

    public void sendTextToPasswordField(String value){
        log.info("enter the password"+ value+ "sending text to firstname field"+password.toString());
        sendTextToElement(password,value);
    }

    public void sendTextToConfirmPasswordField(String value){
        log.info("enter the confirm password"+ value+ "sending text to firstname field"+confirmPassword.toString());
        sendTextToElement(confirmPassword,value);
    }

    public String getActualRegisterCompletionMessage(){
        log.info("getting text from registration message"+ registrationMessage.toString());
        return getTextFromElement(registrationMessage);
    }



}
