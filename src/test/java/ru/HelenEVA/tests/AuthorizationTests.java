package ru.HelenEVA.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import ru.HelenEVA.pages.LoginPage;

@Feature("Тесты на авторизацию")
@Story("Тесты на авторизацию")

public class AuthorizationTests extends BaseTest {

    @Test
    @Description("Тест на авторизацию стандартного пользователя")
    void AuthorizationTest1() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .zeroing();
    }


    @Test
    @Description("Тест на авторизацию проблемного пользователя")
    void AuthorizationTest2() {
        new LoginPage(driver)
                .enterLogin(problemUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .zeroing();
    }

    @Test
    @Description("Тест на авторизацию пользователя с медленным интернетом")
    void AuthorizationTest3() {
        new LoginPage(driver)
                .enterLogin(performanceUser)
                .enterPassword(password)
                .clickLoginButton()
                .checkInventoryPageURL()
                .zeroing();
    }

    @Test
    @Description("Тест на авторизацию с неверным паролем")
    void AuthorizationTest4() {
        new LoginPage(driver)
                .enterLogin(username)
                .enterPassword(password + "0000")
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLogIn()
                .cleaningAuthorization();
    }

    @Test
    @Description("Тест на авторизацию заблокированного пользователя")
    void AuthorizationTest5() {
        new LoginPage(driver)
                .enterLogin(lockedOutUser)
                .enterPassword(password)
                .clickLoginButton();
        new LoginPage(driver)
                .checkErrorLogIn()
                .cleaningAuthorization();
    }

}
