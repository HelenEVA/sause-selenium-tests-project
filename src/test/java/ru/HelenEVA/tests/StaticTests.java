package ru.HelenEVA.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.HelenEVA.pages.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class StaticTests extends BaseTest {

    final static Logger logger = LoggerFactory.getLogger(StaticTests.class);

    @Test
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
