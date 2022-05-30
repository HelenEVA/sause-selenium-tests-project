package ru.HelenEVA.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwoStepPage extends BaseAuthorizedPage {

    @FindBy (id = "finish")
    private WebElement finishButton;

    public TwoStepPage(WebDriver driver) {
        super(driver);
    }

    public TwoStepPage checkTwoStepPageUrl(){

        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        return this;
    }

    public TwoStepPage checkFinishButton(){
        assertThat(driver.findElements(By.name("finish")).size(),not(equalTo(0)));
        return this;
    }

    public TwoStepPage checkHeadingPresence(){
        assertThat(driver.findElement(By.cssSelector("#item_5_title_link")).getAccessibleName(), equalTo("Sauce Labs Fleece Jacket"));
        return this;
    }

    @Step ("Нажать кнопку 'финиш'")
    public OrderPage clickToFinishButton(){
        finishButton.click();
        return new OrderPage(driver);
    }
}
