package ui.tests;

import org.junit.Test;
import util.ui.pages.MainPage;
import util.ui.pages.data.User;

public class UiLoginPageTests {

    @Test
    public void loginWithValidUserTest() {
        User user = new User();
        MainPage mainPage = new MainPage(TestSuite.driver);
        mainPage.signIn(user.getLogin(), user.getPassword());
    }

}
