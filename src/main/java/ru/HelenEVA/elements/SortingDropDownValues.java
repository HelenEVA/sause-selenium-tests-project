package ru.HelenEVA.elements;

import lombok.Getter;
import org.openqa.selenium.By;

public enum SortingDropDownValues {
    NAME_ASC(By.cssSelector("[data-test=product_sort_container] > [value=az]"), "Name (A to Z)"),
    NAME_DESC(By.cssSelector("[data-test=product_sort_container] > [value=za]"), "Name (Z to A)"),
    PRICE_ASC(By.cssSelector("[data-test=product_sort_container] > [value=lohi]"), "Name (Z to A)"),
    PRICE_DESC(By.cssSelector("[data-test=product_sort_container] > [value=hilo]"), "Name (Z to A)");


    @Getter
    By elementLocator;
    @Getter
    String title;
    SortingDropDownValues( By cssSelector, String title) {
        this.elementLocator = cssSelector;
        this.title = title;
    }

    public SortingDropDownValues getByValue(String title) {
        return SortingDropDownValues.valueOf(title);
    }

}