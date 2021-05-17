package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@role='dialog']//button[.='Ok']")
    private WebElement welcomeDialogOkButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='signInButton']")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void closeWelcomeDialog(){
        clickButton(welcomeDialogOkButton);
    }

    public void signIn(String login, String password) {
        sendKeys(loginInput, login);
        sendKeys(passwordInput, password);
        clickButton(signInButton);
    }


}