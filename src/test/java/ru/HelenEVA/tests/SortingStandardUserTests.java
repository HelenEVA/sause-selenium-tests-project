package ru.HelenEVA.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.elements.SortingDropDownValues;
import ru.HelenEVA.pages.InventoryPage;
import ru.HelenEVA.pages.LoginPage;

@Epic("Тесты на сортировку")
@Feature("Тесты на сортировку товаров на сайте")
@Story("Тесты на сортировку товаров на сайте https://www.saucedemo.com/ ")
public class SortingStandardUserTests extends BaseTest {
    static final Logger logger = LoggerFactory.getLogger(SortingStandardUserTests.class);

    @BeforeAll
    static void beforeSuit() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL();
    }
    @Test
    @Description("Тест на сортировку AZ")
    void nameAZStandardUserTest() {
        logger.info("Тест на сортировку AZ запущен");
        new InventoryPage( driver)
                .chooseSortingOption(SortingDropDownValues.NAME_ASC)
                .checkAZSorting();
        logger.info("Тест на сортировку AZ завершен");

    }

    @Test
    @Description("Тест на сортировку ZA")
    void nameZAStandardUserTest() {
        logger.info("Тест на сортировку ZA  запущен");
        new InventoryPage( driver)
                .chooseSortingOption(SortingDropDownValues.NAME_DESC)
                .checkZASorting();
        logger.info("Тест на сортировку ZA завершен");
    }

    @Test
    @Description("Тест на сортировку ToHigh")
    void priceToHighStandardUserTest() {
        logger.info("Тест на сортировку ToHigh  запущен");
        logger.info("ник " + username);
        logger.info("пароль " + password);
        new InventoryPage( driver)
                .chooseSortingOption(SortingDropDownValues.PRICE_ASC)
                .checkToHighSorting();
        logger.info("Тест на сортировку ToHigh завершен");
    }

    @Test
    @Description("Тест на сортировку ToLow")
    void priceToLowStandardUserTest() {
        logger.info("Тест на сортировку ToLow  запущен");
        new InventoryPage( driver)
                .chooseSortingOption(SortingDropDownValues.PRICE_DESC)
                .checkToLowSorting();
        logger.info("Тест на сортировку ToLow завершен");
    }

    @AfterAll
    static void endOfSortingTests() {

        logger.info("Тесты на сортировку завершены");
    }
}
