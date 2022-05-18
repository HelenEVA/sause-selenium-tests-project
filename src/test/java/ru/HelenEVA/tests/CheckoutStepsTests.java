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

public class CheckoutStepsTests {

    static WebDriver driver;

    @BeforeAll
    static void beforeAll(){
        
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        //изменить размеры окна - максимум
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    void authorisationPositiveTest(){

        //ввод логина
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //ввод пароля
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //нажать на кнопку Login
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        //проверка на переход на страницу
        assertThat(driver.getCurrentUrl(),equalTo("https://www.saucedemo.com/inventory.html"));

        //проверка на наличие элемента
        assertThat(driver.findElements(By.cssSelector("#shopping_cart_container")).size(),not(equalTo(0)));

    }

    @Test

    void checkoutStepsPositiveTest() throws InterruptedException {

        //авторизация
        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        //выбор товара Sauce Labs Fleece Jacket
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.id("shopping_cart_container")).click();

        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/cart.html"));
        //проверка наличия элемента remove
        assertThat(driver.findElements(By.name("remove-sauce-labs-fleece-jacket")).size(),not(equalTo(0)));

        //ввод данных
        driver.findElement(By.id("checkout")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-one.html"));
        driver.findElement(By.id("first-name")).sendKeys("Mary");
        driver.findElement(By.id("last-name")).sendKeys("Brown");
        driver.findElement(By.id("postal-code")).sendKeys("0000");
        driver.findElement(By.id("continue")).click();

        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-step-two.html"));
        assertThat(driver.findElements(By.name("finish")).size(),not(equalTo(0)));
        //проверка наличия на странице заголовка Sauce Labs Fleece Jacket
        assertThat(driver.findElement(By.cssSelector("#item_5_title_link")).getAccessibleName(), equalTo("Sauce Labs Fleece Jacket"));

        //нажать на кнопку Finish
        driver.findElement(By.id("finish")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/checkout-complete.html"));
        assertThat(driver.findElements(By.name("back-to-products")).size(),not(equalTo(0)));
        assertThat(driver.findElement(By.className("complete-header")).getAccessibleName(), equalTo("THANK YOU FOR YOUR ORDER"));

        //возврат на домшнюю страницу
        driver.findElement(By.id("back-to-products")).click();
        assertThat(driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));


        //Thread.sleep(3000);

    }

    @AfterAll
    static void afterAll(){
        driver.quit();
    }
}
