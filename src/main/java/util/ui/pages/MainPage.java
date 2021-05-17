package util.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='signInButton']")
    private WebElement signInButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String login, String password) {
        sendKeys(loginInput, login);
        sendKeys(passwordInput, password);
        clickButton(signInButton);
    }


}