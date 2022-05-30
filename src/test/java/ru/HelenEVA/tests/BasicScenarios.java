package ru.HelenEVA.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.HelenEVA.pages.LoginPage;

@Epic("Тесты на основные сценарии разными пользователями")
@Feature("Тесты на основые шаги добавления товаров и проверка наличия элементов на странице")
@Story("Тесты на основые шаги добавления товаров и проверка наличия элементов на странице")

public class BasicScenarios extends BaseTest {


    @Test
    @Description("Тест на добавление товара в корзину пользователем с медленным интернетом")
    void goToProductPageWithPerformanceUserTest(){

        new LoginPage(driver)
                .enterLogin(performanceUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsBikeLightImg()
                .checkCartOnThePage()
                .zeroing();
    }

    @Test
    @Description("Тест на добавление 2 товаров в корзину пользователем с медленным интернетом и переход в корзину")
    void putTheGoodsAndGoToTheCartWithPerformanceUserTest(){

        new LoginPage(driver)
                .enterLogin(performanceUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsOnesieButton()
                .clickCartButton()
                .checkCartPageURL()
                .zeroing();
    }


    @Test
    @Description("Тест на добавление товара в корзину проблемным пользователем")
    void goToProductPageWithProblemUserTest(){

        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsBikeLightImg()
                .checkCartOnThePage()
                .zeroing();
    }

    @Test
    @Description("Тест на добавление 3 товаров в корзину проблемным пользователем")
    void put3ItemsAndGoToTheCartWithProblemUserTest(){

        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsOnesieButton()
                .clickSauceLabsBikeLightButton()
                .clickSauceLabsBoltTShirtButton()
                .clickCartButton()
                .checkCartPageURL()
                .zeroing();
    }

    @Test
    @Description("Тест на наличие элементов на странице при входе проблемного пользователя")
    void presenceOfElementsWithProblemsUserTest(){
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .checkFooterField()
                .checkSocialNetworksButtons()
                .checkRobotImage()
                .zeroing();
    }

    @Test
    @Description("Тест на наличие ошибки при оформлении заказа в поле ввода при входе проблемного пользователя")
    void errorInOrderingWithProblemsUserTest(){

        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsOnesieButton()
                .clickSauceLabsBikeLightButton()
                .clickSauceLabsBoltTShirtButton()
                .clickCartButton()
                .checkCartPageURL()
                .clickToCheckoutButton()
                .checkOneStepPageUrl()
                .enterFirstName("Bob")
                .enterLastName("Smith")
                .enterPostalCode("0000")
                .clickToContinueButton()
                .checkTwoStepPageUrl()
                .zeroing();

    }

    @Test
    @Description("Тест на наличие неактивной кнопки при выборе товара при входе проблемного пользователя")
    void errorInactiveButtonWithProblemsUserTest (){

        new LoginPage(driver)
        .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickAddFleeceJacketButton()
                .checkRemoveFleeceJacketInInventoryPageButton()
                .zeroing();


    }

    @Test
    @Description("Тест на наличие ошибки при отмене выбранного товара при входе проблемного пользователя")
    void errorDeselectItemWithProblemsUserTest (){

        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .clickSauceLabsBoltTShirtButton()
                .checkRemoveSauceLabsOnesie()
                .zeroing();
    }


}
