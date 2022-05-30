package ru.HelenEVA.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseAuthorizedPage extends BasePage {

    @FindBy(id = "react-burger-cross-btn")
    WebElement reactMenuClose;
    @FindBy(id = "react-burger-menu-btn")
    WebElement reactMenu;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetButton;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;

    public BaseAuthorizedPage(WebDriver driver) {
        super(driver);
    }


    @Step ("Нажать кнопку всплывающего меню")
    public BaseAuthorizedPage clickReactMenuButton(){
        reactMenu.click();
        return this;
    }


    public BaseAuthorizedPage checkSidebar(){

        assertThat(driver.findElements(By.id("inventory_sidebar_link")).size(), not(equalTo("0")));
        return this;
    }

    public BaseAuthorizedPage checkAboutSidebarLink(){

        assertThat(driver.findElements(By.id("about_sidebar_link")).size(), not(equalTo(0)));
        return this;
    }


    public BaseAuthorizedPage checkLogoutSidebarLink(){

        assertThat(driver.findElements(By.id("logout_sidebar_link")).size(), not(equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkResetSidebarLink(){

        assertThat(driver.findElements(By.id("reset_sidebar_link")).size(), not(equalTo(0)));
        return this;
    }

    public BaseAuthorizedPage checkFooterField(){
        assertThat(driver.findElements(By.className("footer")).size(), not(equalTo("0")));
        return this;
    }

    public BaseAuthorizedPage checkSocialNetworksButtons(){
        assertThat(driver.findElements(By.className("social_twitter")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("social_facebook")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("social_linkedin")).size(), not(equalTo("0")));
        return this;
    }

    public BaseAuthorizedPage checkRobotImage(){
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo("0")));
        return this;
    }

    public BaseAuthorizedPage checkFooterCopyLabel(){
        assertThat(driver.findElement(By.className("footer_copy")).getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        return this;
    }



    @Step ("Нажать на выход из высплывающего меню")
    public BaseAuthorizedPage clickReactMenuCloseButton(){

        reactMenuClose.click();
        return this;
    }


    @Step ("Обнуление корзины и разлогин")
    public LoginPage zeroing() {
        reactMenu.click();
        resetButton.click();
        logoutButton.click();
        return new LoginPage(driver);
    }

}