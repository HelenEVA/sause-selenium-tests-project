package ru.HelenEVA.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    static WebDriver driver;

    static String username;
    static String password;
    static String baseUrl;

    static String firstname;
    static String lastname;
    static String postalcode;

    @BeforeAll
    static void beforeAllTests() throws IOException {
        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postalcode = properties.getProperty("postalcode");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterAll
    static void afterAllTests() {
        if (driver != null) {
            driver.quit();
        }
    }
}
