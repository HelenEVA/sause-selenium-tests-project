package ru.HelenEVA.pages;


import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryPage extends BaseAuthorizedPage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement buttonAddFleeceJacket;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage checkInventoryPageURL(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
        return this;
    }

    public InventoryPage checkCartOnThePage(){
        assertThat(cartButton.getSize(), not(IsEqual.equalTo("0")));
        return this;
    }

    public InventoryPage clickAddFleeceJacketButton(){
        buttonAddFleeceJacket.click();
        return this;
    }

    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }
}
