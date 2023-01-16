package task70.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task70.page.HomePage;
import task70.page.LoginPage;

import static task60.util.TestConfig.*;

public class YandexHomePageScreenShotTest extends TestBase {

    public YandexHomePageScreenShotTest()    {super(MAIL_YANDEX_URL);}

    @Test
    void makeYandexMailHomePageScreenShortTest() throws InterruptedException {
        LoginPage logPage = new LoginPage(super.driver);
        HomePage homePage = logPage.logIn(LOG_NAME, PASSWORD);
        homePage.takeHomePageScreenShot(super.driver);
        Assertions.assertTrue(homePage.isScreenShotFileExist());
    }
}
