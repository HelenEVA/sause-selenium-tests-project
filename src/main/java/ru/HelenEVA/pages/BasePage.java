package ru.HelenEVA.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30))
                .implicitlyWait(Duration.ofSeconds(4));

        initElements(this.driver, this);
    }

    public boolean existElementById(String locator) {
        try {
            driver.findElement(By.id(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
