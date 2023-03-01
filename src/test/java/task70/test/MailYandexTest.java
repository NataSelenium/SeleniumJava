package task70.test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.remote.RemoteWebDriver;
import task70.page.HomePage;
import task70.page.LoginPage;
import task70.util.SauceTestWatcher;

import java.io.IOException;

import static task70.util.TestConfig.*;

public class MailYandexTest extends TestBase {

    public MailYandexTest()    {super(MAIL_YANDEX_URL);}

    @RegisterExtension
    SauceTestWatcher sauceTestWatcher = new SauceTestWatcher((RemoteWebDriver) super.driver);

    @Test
    @Tag("login")
    @DisplayName("Test #1")
    @Description("Login to yandex")
    void loginYandexMailTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        Assertions.assertTrue(homePage.isHomePagePresent());
    }

    @Test
    @Tag("login")
    @DisplayName("Test #2")
    @Description("Login to yandex with failed")
    @Disabled
    void loginYandexMailFailedTest() throws InterruptedException, IOException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        Assertions.assertTrue(homePage.isHomePagePresentFailed());
    }

    @Test
    @Tag("logout")
    @DisplayName("Test #3")
    @Description("Logout from yandex broken")
    @Disabled
    void logOutYandexMailFBrokenTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, "wrong_password");
        homePage.logOut(LOG_NAME);
        Assertions.assertTrue(logPage.isLoginPagePresent());
    }

    @Test
    @Tag("logout")
    @DisplayName("Test #4")
    @Description("Logout from yandex passed")
    void logOutYandexMailTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        homePage.logOut(LOG_NAME);
        Assertions.assertTrue(logPage.isLoginPagePresent());
    }
}
