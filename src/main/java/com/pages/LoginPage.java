package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //1. By Locator
    private By emailId = By.name("username");
    private By password = By.name("password");
    private By signInButton = By.xpath("//*[@value='Log In']");
    private By forgotPwdLink = By.linkText("Forgot login info?");

    //2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page action
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String passwd) {
        driver.findElement(password).sendKeys(passwd);
    }

    public void qlickOnLogin() {
        driver.findElement(signInButton).click();
    }

}
