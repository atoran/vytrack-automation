package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        // page object classes needs constructor
        //here we have to call the PageFactory.initElements();
        //this comes from selenium and we pass a webdriver object and "this" as parameter
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userNameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement logInButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement errorMessage;

    public void login(String username, String password){
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        logInButton.click();
    }
}
