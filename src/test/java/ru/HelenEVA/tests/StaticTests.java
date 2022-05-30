package ru.HelenEVA.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.pages.LoginPage;


@Epic("Статические тесты")
@Feature("Тесты на наличие элементов")
@Story("Тесты на наличие элементов")
public class StaticTests extends BaseTest {

    final static Logger logger = LoggerFactory.getLogger(StaticTests.class);

    @Test
    @Description("Проверка наличия элементов на основной странице оформления заказа")
    void ElementsTests(){


        logger.info("Start static tests");
        logger.info("Authorization");
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickAddFleeceJacketButton()
                .clickCartButton()
                .clickToCheckoutButton()
                .checkOneStepPageUrl()
                .checkHeaderLabel()
                .checkHeaderSecondaryContainerLabel()
                .checkLogoLabel()
                .checkInfoField()
                .checkInfoWrapperField()
                .checkFirstNameInput()
                .checkLastNameInput()
                .checkPostalCodeInput()
                .checkCancelButton()
                .checkContinueButton()
                .checkShoppingCartContainerButton()
                .checkReactMenu()
                .clickReactMenuButton()
                .checkSidebar()
                .checkAboutSidebarLink()
                .checkLogoutSidebarLink()
                .checkResetSidebarLink()
                .clickReactMenuCloseButton()
                .checkFooterField()
                .checkSocialNetworksButtons()
                .checkRobotImage()
                .checkFooterCopyLabel();
        logger.info("Static tests end");
    }

}
