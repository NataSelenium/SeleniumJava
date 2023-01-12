package task60.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task60.page.HomePage;
import task60.page.LoginPage;

import static task60.util.TestConfig.*;

public class MailYandexTest extends TestBase {

    public MailYandexTest()    {super(MAIL_YANDEX_URL);}

    @Test
    void loginYandexMailTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        Assertions.assertTrue(homePage.isHomePagePresent());
    }

    @Test
    void logOutYandexMailTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        homePage.logOut(LOG_NAME);
        Assertions.assertTrue(logPage.isLoginPagePresent());
    }
}
