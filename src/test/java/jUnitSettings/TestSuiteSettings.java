package jUnitSettings;

import apiTests.tests.ApiLoginPageTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import uiTests.UiLoginPageTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(Suite.class)
@Suite.SuiteClasses ({UiLoginPageTests.class, ApiLoginPageTests.class})
public class TestSuiteSettings {

    public static WebDriver driver;
    public static BasePage basePage;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(System.getProperty("url"));
    }

    @AfterClass
    public static void tearDown() throws IOException {
        basePage.takeScreenshot();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}