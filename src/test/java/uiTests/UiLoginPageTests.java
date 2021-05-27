package uiTests;

import jUnitSettings.TestSuiteSettings;
import org.junit.Test;
import pages.LoginPage;
import testData.User;


public class UiLoginPageTests {

    @Test
    public void loginWithValidUserTest() {
        User user = new User();
        LoginPage loginPage = new LoginPage(TestSuiteSettings.driver);
        loginPage.closeWelcomeDialog();
        //loginPage.signIn(user.getLogin(), user.getPassword());
    }

}
