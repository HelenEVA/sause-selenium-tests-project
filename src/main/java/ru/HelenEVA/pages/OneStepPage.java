package ru.HelenEVA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneStepPage extends BaseAuthorizedPage {

    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(id = "continue")
    private WebElement continueButton;


    public OneStepPage(WebDriver driver) {
        super(driver);
    }

    public OneStepPage checkOneStepPageUrl(){
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        return this;
    }

    public OneStepPage enterFirstName(String fName){

        firstName.sendKeys(fName);
        return this;
    }

    public OneStepPage enterLastName(String lName){
        lastName.sendKeys(lName);
        return this;
    }

    public OneStepPage enterPostalCode(String code){
        postalCode.sendKeys(code);
    return this;
    }

    public OneStepPage checkReactMenu(){
        assertThat(driver.findElements(By.id("react-burger-menu-btn")).size(), not(equalTo("0")));
        return this;
    }


    public OneStepPage checkHeaderLabel(){
        assertThat(driver.findElements(By.cssSelector("header_label")).size(), not(equalTo("0")));
        return this;

    }

    public OneStepPage checkHeaderSecondaryContainerLabel(){
        assertThat(driver.findElements(By.className("header_secondary_container")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.className("header_secondary_container")).getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        return this;
    }

    public OneStepPage checkLogoLabel(){
        assertThat(driver.findElements(By.cssSelector(".app_logo")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkShoppingCartContainerButton(){
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkInfoField(){
        assertThat(driver.findElements(By.cssSelector("checkout_info")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkInfoWrapperField(){
        assertThat(driver.findElements(By.cssSelector("checkout_info_wrapper")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkFirstNameInput(){

        assertThat(driver.findElement(By.id("first-name")).getAccessibleName(), equalTo("First Name"));
        assertThat(driver.findElements(By.id("first-name")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkLastNameInput(){
        assertThat(driver.findElement(By.id("last-name")).getAccessibleName(), equalTo("Last Name"));
        assertThat(driver.findElements(By.id("last-name")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkPostalCodeInput(){
        assertThat(driver.findElement(By.id("postal-code")).getAccessibleName(), equalTo("Zip/Postal Code"));
        assertThat(driver.findElements(By.id("postal-code")).size(), not(equalTo("0")));
        return this;
    }

    public OneStepPage checkCancelButton(){
        assertThat(driver.findElements(By.name("cancel")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.name("cancel")).getAccessibleName(), equalTo("Go back CANCEL"));
        return this;
    }

    public OneStepPage checkContinueButton(){

        assertThat(driver.findElements(By.name("continue")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.name("continue")).getAccessibleName(), equalTo("Continue"));
        return this;

    }


    public TwoStepPage clickToContinueButton() {
        continueButton.click();
        return new TwoStepPage(driver);
    }
}
