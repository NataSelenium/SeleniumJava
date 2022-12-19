package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;
import task40.page.HomeMailPage;
import task40.page.LoginPage;

import static task40.util.TestConstants.*;

public class LoginYandexTest extends BaseTest {
    public WebDriverWait wait;
    public LoginYandexTest() {
        super(MAIL_YANDEX_URL);
    }

    @ParameterizedTest
    @CsvSource({
           "WhiteDecember22,        GreenMonday22&",
            "RoseMagic16,         November5%",
    })
    void loginYandexMailTest(String logName, String  pass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(super.driver, wait);
        loginPage.logIn(logName, pass);
        //Implicit wait - test scenario is stopped for 2000 milliseconds
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        HomeMailPage homeMailPage = new HomeMailPage(driver);
        String actualUserName = homeMailPage.getLoginNameLabel(logName);
        Assertions.assertEquals(logName,actualUserName);
    }
}
