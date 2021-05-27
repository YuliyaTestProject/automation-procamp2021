package ui.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ui.pages.BasePage;
import util.ui.properties.PropertiesUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(Suite.class)
@Suite.SuiteClasses ({UiLoginPageTests.class})
public class TestSuite {

    private static PropertiesUtil propertiesUtil = PropertiesUtil.getInstance();
    protected static WebDriver driver;
    private static String pathToChrome = propertiesUtil.get("config.properties", "path.to.chrome.driver");
    private static String url = propertiesUtil.get("config.properties", "url");


    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", pathToChrome);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterClass
    public static void tearDown() throws IOException {

        BasePage.takeScreenshot();
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}