package ru.HelenEVA.tests.tech;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.pages.InventoryPage;
import ru.HelenEVA.pages.LoginPage;
import ru.HelenEVA.tests.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@Epic("Технические тесты")
@Feature("Тесты на удаление и добавление cookie")
@Story("Тесты на удаление и добавление cookie")
public class CookiesTests extends BaseTest {
    final static Logger logger = LoggerFactory.getLogger(CookiesTests.class);

    @Test
    @Description("Тест на смену куки обычного пользователя на заблокированного")
    void setCookiesTest(){

        logger.info("Тест на смену куки обычного пользователя на заблокированного запущен");
        InventoryPage inventoryPage = new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(),equalTo("1"));
        logger.info("вход с "+ lockedOutUser);
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(new Cookie("session-username", "locked_out_user", "/"));
        assertThat(inventoryPage.getShoppingCartBadge().getText(),equalTo("0"));
        logger.info("Тест на смену куки обычного пользователя на заблокированного завершен");

    }

    @Test
    @Description("Тест на смену куки обычного пользователя на пользователя с медленным интернетом")
    void setCookiesTest2() {

        logger.info("Тест на смену куки обычного пользователя на пользователя с медленным интернетом запущен");
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        logger.info("вход с "+ performanceUser);
        driver.manage().addCookie(new Cookie("session-username", "performance_glitch_user", "/"));
        assertThat(inventoryPage.getShoppingCartBadge().getText(),equalTo("0"));
        logger.info("Тест на смену куки обычного пользователя на пользователя с медленным интернетом завершен");
    }

    @Test
    @Description("Тест на смену куки обычного пользователя на проблемного")
    void setCookiesTest3() {

        logger.info("Тест на смену куки обычного пользователя на проблемного запущен");
        InventoryPage inventoryPage = new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        assertThat(inventoryPage.getShoppingCartBadge().getText(), equalTo("1"));
        driver.manage().deleteAllCookies();
        logger.info("вход с "+ problemUser);
        driver.manage().addCookie(new Cookie("session-username", "problem_user", "/"));
        assertThat(inventoryPage.getShoppingCartBadge().getText(),equalTo("0"));
        logger.info("Тест на смену куки обычного пользователя на проблемного завершен");
    }


    @AfterEach
    void tearDown() {
        getDriver().get(getBaseUrl());
        new LoginPage(getDriver())
                .enterLogin(getUsername())
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing()
                .enterLogin(problemUser)
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing()
                .enterLogin(performanceUser)
                .enterPassword(getPassword())
                .clickLoginButton()
                .zeroing();
    }


}
