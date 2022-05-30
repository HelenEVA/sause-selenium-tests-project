package ru.HelenEVA.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "[data-test='login-button']")
    private WebElement loginButton;
    @FindBy(className = "error-button")
    WebElement errorButton;
    @FindBy(css = "[data-test='error']")
    WebElement errorLogIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести логин")
    public LoginPage enterLogin(String loginName){
        loginInput.click();
        loginInput.sendKeys(loginName);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password){
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }


    @Step("Нажать кнопку 'логин'")
    public InventoryPage clickLoginButton (){

        loginButton.click();
        return new InventoryPage(driver);
    }

    @Step("Очистка полей авторизации")
    public LoginPage cleaningAuthorization() {
        errorButton.click();
        loginInput.clear();
        passwordInput.clear();
        return this;
    }
    public LoginPage checkErrorLogIn() {
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/"));
        assertThat(errorLogIn.getAccessibleName(), equalTo("Epic sadface: Username and password do not match any user in this service"));
        return this;
    }



}
