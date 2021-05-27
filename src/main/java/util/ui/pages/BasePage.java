package util.ui.pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButton(WebElement button) {
        waitUntilElementIsClickable(button);
        button.click();
    }

    protected void sendKeys(WebElement webElement, String text) {
        waitUntilElementIsVisible(webElement);
        webElement.click();
        webElement.sendKeys(text);
    }
    public void waitUntilElementIsClickable(WebElement webElement) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
        }
    }
    public void waitUntilElementIsVisible(WebElement webElement) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
        }
    }
    public static void takeScreenshot() throws IOException {
        String generatedString = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss").format(new Date(System.currentTimeMillis()));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(String.format("c:\\tmp\\%s.png",generatedString)));
    }
}