package ru.HelenEVA.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class StaticTests {

    static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));

    }

    @Test
            void popUpMenuTests() {

        assertThat(driver.findElements(By.id("react-burger-menu-btn")).size(), not(equalTo("0")));
        driver.findElement(By.id("react-burger-menu-btn")).click();
        assertThat(driver.findElements(By.id("inventory_sidebar_link")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.id("about_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("logout_sidebar_link")).size(), not(equalTo(0)));
        assertThat(driver.findElements(By.id("reset_sidebar_link")).size(), not(equalTo(0)));
        driver.findElement(By.id("react-burger-cross-btn")).click();
    }

    @Test
    void pageHeaderTests(){
        assertThat(driver.findElements(By.cssSelector("header_label")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("header_secondary_container")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.className("header_secondary_container")).getText(), equalTo("CHECKOUT: YOUR INFORMATION"));
        assertThat(driver.findElements(By.cssSelector(".app_logo")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(), not(equalTo("0")));

    }

    @Test
    void inputFieldsTests (){
        assertThat(driver.findElements(By.cssSelector("checkout_info")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.cssSelector("checkout_info_wrapper")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.id("first-name")).getAccessibleName(), equalTo("First Name"));
        assertThat(driver.findElements(By.id("first-name")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.id("last-name")).getAccessibleName(), equalTo("Last Name"));
        assertThat(driver.findElements(By.id("last-name")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.id("postal-code")).getAccessibleName(), equalTo("Zip/Postal Code"));
        assertThat(driver.findElements(By.id("postal-code")).size(), not(equalTo("0")));

    }

    @Test
    void lowerBondTests(){
        assertThat(driver.findElements(By.name("cancel")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.name("cancel")).getAccessibleName(), equalTo("Go back CANCEL"));
        assertThat(driver.findElements(By.name("continue")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.name("continue")).getAccessibleName(), equalTo("Continue"));
    }

    @Test
    void halfPageTests(){
        assertThat(driver.findElements(By.className("footer")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("social_twitter")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("social_facebook")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("social_linkedin")).size(), not(equalTo("0")));
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo("0")));
        assertThat(driver.findElement(By.className("footer_copy")).getText(), equalTo("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
        assertThat(driver.findElements(By.className("footer_robot")).size(), not(equalTo("0")));

    }

    @AfterAll
    static void afterAll(){
        driver.quit();
    }
}
