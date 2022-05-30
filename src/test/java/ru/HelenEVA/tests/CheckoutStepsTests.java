package ru.HelenEVA.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.pages.LoginPage;

@Feature("Тесты на авторизацию в системе и шаги выбора товара")
public class CheckoutStepsTests extends BaseTest {


    final static Logger logger = LoggerFactory.getLogger(CheckoutStepsTests.class);


    @Test
    @Description("Тест на авторизацию обычного пользователя")
    void authorisationPositiveTest() {

        logger.info("Authorization");
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                .zeroing();

    }

    @Test
    @Description("Тест шаги выбора товара обычного пользователя")
    void checkoutStepsPositiveTest()  {

        logger.info("Start checkout steps positive tests");
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage()
                //выбор товара Sauce Labs Fleece Jacket
                .clickAddFleeceJacketButton()
                .clickCartButton()

                .checkCartPageURL()
                //проверка наличия элемента remove
                .checkRemoveFleeceJacketButton()

                //ввод данных
                .clickToCheckoutButton()
                .checkOneStepPageUrl()
                .enterFirstName("Mary")
                .enterLastName("Brown")
                .enterPostalCode("0000")
                .clickToContinueButton()
                .checkTwoStepPageUrl()
                .checkFinishButton()

                //проверка наличия на странице заголовка Sauce Labs Fleece Jacket
                .checkHeadingPresence()
                //нажать на кнопку Finish
                .clickToFinishButton()
                .checkOrderPageUrl()
                .checkBackToProductsButton()
                .checkTitleIsCorrect()
                //возврат на домшнюю страницу
                .clickToBackHomeButton()
                .checkInventoryPageURL()
                .zeroing();
        logger.info("Checkout steps positive tests end");
    }
}
