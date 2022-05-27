package ru.HelenEVA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends BaseAuthorizedPage {

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    private WebElement buttonRemoveFleeceJacket;

    @FindBy(css = "#item_5_title_link")
    private WebElement fleeceJacketOnTheCart;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        return this;
    }

    public CartPage checkRemoveFleeceJacketButton(){
        assertThat(driver.findElements(By.name("remove-sauce-labs-fleece-jacket")).size(),not(equalTo(0)));
        return this;
    }

    public OneStepPage clickToCheckoutButton() {
        checkoutButton.click();
        return new OneStepPage(driver);
    }



}
