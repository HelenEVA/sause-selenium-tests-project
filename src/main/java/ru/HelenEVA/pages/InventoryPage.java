package ru.HelenEVA.pages;


import io.qameta.allure.Step;
import lombok.Getter;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.HelenEVA.elements.SortingDropDownValues;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryPage extends BaseAuthorizedPage {


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAddBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement buttonAddFleeceJacket;

    @FindBy(css = ".inventory_item_img")
    WebElement sauceLabsBikeLightImg;

    @Getter
    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;

    @Getter
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement buttonSauceLabsOnesie;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement buttonSauceLabsBackpack;

    @FindBy (id = "remove-sauce-labs-onesie")
    WebElement buttonRemoveSauceLabsOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement buttonSauceLabsBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement buttonSauceLabsBoltTShirt;

    @Getter
    @FindBy(css = "[data-test=product_sort_container]")
    WebElement sortingDropdown;

    @FindBy(css = "#header_container")
    WebElement filterButton;
    @Getter
    @FindBy(css = "#header_container > div.header_secondary_container > div.right_component > span > select")
    WebElement filterAZButton;

    @Getter
    @FindBy(css = "#item_4_img_link > img")
    WebElement imgBackpack;
    @Getter
    @FindBy(css = "#item_4_title_link")
    WebElement itemBackpack;
    @Getter
    @FindBy(css = "#item_0_title_link")
    WebElement itemBikeLight;
    @Getter
    @FindBy(css = "#item_0_img_link > img")
    WebElement imgBikeLight;
    @Getter
    @FindBy(css = "#item_1_title_link")
    WebElement itemBoltTShirt;
    @Getter
    @FindBy(css = "#item_1_img_link > img")
    WebElement imgBoltTShirt;
    @Getter
    @FindBy(css = "#item_5_title_link")
    WebElement itemFleeceJacket;
    @Getter
    @FindBy(css = "#item_5_img_link > img")
    WebElement imgFleeceJacket;
    @Getter
    @FindBy(css = "#item_2_title_link")
    WebElement itemOnesie;
    @Getter
    @FindBy(css = "#item_2_img_link > img")
    WebElement imgOnesie;
    @Getter
    @FindBy(css = "#item_3_title_link")
    WebElement itemTShirtRed;

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

    @Step("Нажать кнопку 'add to cart' товара Fleece Jacket")
    public InventoryPage clickAddFleeceJacketButton(){
        buttonAddFleeceJacket.click();
        return this;
    }

    @Step("Нажать на изображение товара Sauce Labs Bike Light")
    public InventoryPage clickSauceLabsBikeLightImg(){
        sauceLabsBikeLightImg.click();
        return this;
    }

    @Step("Нажать кнопку 'add to cart' товара Sauce Labs Onesie")
    public InventoryPage clickSauceLabsOnesieButton(){
        buttonSauceLabsOnesie.click();
        return this;
    }

    @Step("Нажать кнопку 'add to cart' товара Sauce Labs Bike Light")
    public InventoryPage clickSauceLabsBikeLightButton(){
        buttonSauceLabsBikeLight.click();
        return this;

    }


    @Step("Нажать кнопку 'add to cart' товара Sauce Labs Bolt T-Shirt")
    public InventoryPage clickSauceLabsBoltTShirtButton(){
        buttonSauceLabsBoltTShirt.click();
        return this;

    }

    public InventoryPage checkRemoveSauceLabsOnesie(){
        assertThat(driver.findElements(By.name("remove-sauce-labs-onesie")).size(),not(equalTo(0)));
        return this;
    }

    public InventoryPage checkRemoveFleeceJacketInInventoryPageButton(){
        assertThat(driver.findElements(By.name("remove-sauce-labs-fleece-jacket")).size(),not(equalTo(0)));
        return this;
    }

    @Step("Нажать кнопку 'корзина'")
    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }

    @Step("Выбираем вариант сортировки товара")
    public InventoryPage chooseSortingOption(SortingDropDownValues value) {
        filterButton.click();
        driver.findElement(value.getElementLocator()).click();
        return this;
    }

    public InventoryPage checkAZSorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());
        listOfProductNamesTest.add(itemFleeceJacket.getAccessibleName());
        listOfProductNamesTest.add(itemOnesie.getAccessibleName());
        listOfProductNamesTest.add(itemTShirtRed.getAccessibleName());

        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkZASorting() {
        List<String> listOfProductNames = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductNamesTest = new ArrayList<>();
        listOfProductNamesTest.add(itemTShirtRed.getAccessibleName());
        listOfProductNamesTest.add(itemOnesie.getAccessibleName());
        listOfProductNamesTest.add(itemFleeceJacket.getAccessibleName());
        listOfProductNamesTest.add(itemBoltTShirt.getAccessibleName());
        listOfProductNamesTest.add(itemBikeLight.getAccessibleName());
        listOfProductNamesTest.add(itemBackpack.getAccessibleName());


        for (int i = 0; i < listOfProductNamesTest.size(); i++) {
            assertThat(listOfProductNamesTest.get(i), equalTo(listOfProductNames.get(i)));
        }
        return this;
    }

    public InventoryPage checkToHighSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemOnesie.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());
        listOfProductPrices.add(itemTShirtRed.getAccessibleName());
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemFleeceJacket.getAccessibleName());

        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }

    public InventoryPage checkToLowSorting() {
        List<String> listOfProductPrices = driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> listOfProductPricesTest = new ArrayList<>();
        listOfProductPrices.add(itemFleeceJacket.getAccessibleName());
        listOfProductPrices.add(itemBackpack.getAccessibleName());
        listOfProductPrices.add(itemTShirtRed.getAccessibleName());
        listOfProductPrices.add(itemBoltTShirt.getAccessibleName());
        listOfProductPrices.add(itemBikeLight.getAccessibleName());
        listOfProductPrices.add(itemOnesie.getAccessibleName());

        for (int i = 0; i < listOfProductPricesTest.size(); i++) {
            assertThat(listOfProductPricesTest.get(i), equalTo(listOfProductPrices.get(i)));
        }
        return this;
    }
}
