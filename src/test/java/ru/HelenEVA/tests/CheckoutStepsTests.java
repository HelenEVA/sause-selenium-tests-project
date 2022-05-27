package ru.HelenEVA.tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.pages.LoginPage;


public class CheckoutStepsTests extends BaseTest {


    final static Logger logger = LoggerFactory.getLogger(CheckoutStepsTests.class);


    @Test
    void authorisationPositiveTest() {

        logger.info("Authorization");
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkCartOnThePage();

    }

    @Test
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
                .checkInventoryPageURL();
        logger.info("Checkout steps positive tests end");
    }
}
