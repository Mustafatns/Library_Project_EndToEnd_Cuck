package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
    public WebElement signInButton;

    // =========================================================

//    public WebElement getEmailInput() {
//        return emailInput;
//    }
//
//    public void setEmailInput(WebElement emailInput) {
//        this.emailInput = emailInput;
//    }
//
//    public WebElement getPasswordInput() {
//        return passwordInput;
//    }
//
//    public void setPasswordInput(WebElement passwordInput) {
//        this.passwordInput = passwordInput;
//    }
//
//    public WebElement getSignInButton() {
//        return signInButton;
//    }
//
//    public void setSignInButton(WebElement signInButton) {
//        this.signInButton = signInButton;
//    }
}
