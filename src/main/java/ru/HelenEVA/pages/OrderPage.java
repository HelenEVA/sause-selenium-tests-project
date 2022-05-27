package ru.HelenEVA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderPage extends BaseAuthorizedPage {

    public OrderPage(WebDriver driver) {
        super(driver);
    }


    public OrderPage checkOrderPageUrl(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        return this;
    }

    public OrderPage checkBackToProductsButton(){
        assertThat(driver.findElements(By.name("back-to-products")).size(),not(equalTo(0)));
        return this;
    }

    public OrderPage checkTitleIsCorrect(){
        assertThat(driver.findElement(By.className("complete-header")).getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));
        return this;
    }

    public InventoryPage clickToBackHomeButton(){
        driver.findElement(By.id("back-to-products")).click();
        return new InventoryPage(driver);
    }
}
