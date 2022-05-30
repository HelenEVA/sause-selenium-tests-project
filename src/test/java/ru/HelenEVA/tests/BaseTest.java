package ru.HelenEVA.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.HelenEVA.ScreenshotMaker.makeScreenshotOnFailure;

public abstract class BaseTest {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    @Getter
    public static WebDriver driver;

    @Getter
    public static String username;
    @Getter
    public static String password;
    @Getter
    static String baseUrl;
    static String firstname;
    static String lastname;
    static String postalcode;
    public static String lockedOutUser;
    public static String problemUser;
    public static String performanceUser;


    @BeforeAll
    static void beforeAllTests() throws IOException {

        driver = WebDriverManager.chromedriver().create();

        properties.load(new FileInputStream(PATH_TO_PROPERTIES));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        firstname = properties.getProperty("firstname");
        lastname = properties.getProperty("lastname");
        postalcode = properties.getProperty("postalcode");
        lockedOutUser = properties.getProperty("lockedOut.username");
        problemUser = properties.getProperty("problem.username");
        performanceUser = properties.getProperty("performance.username");

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    void afterEach() throws IOException {
        Allure.addAttachment("Page screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
    }

    @AfterAll
    static void afterAllTests() {
        if (driver != null) {
            driver.quit();
        }
    }
}
