package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import task40.helpes.BaseTest;
import task40.helpes.HomeMailPage;
import task40.helpes.LoginPage;

import static task40.helpes.TestConstants.*;

public class LoginYandexTest extends BaseTest {

    public LoginYandexTest() {
        super(MAIL_YANDEX_URL);
    }

    @ParameterizedTest
    @CsvSource({
           "WhiteDecember22,        GreenMonday22&",
            "RoseMagic16,         November5%",
    })
    void loginYandexMailTest(String logName, String  pass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.enterCredential(logName, pass);

        //Implicit wait - test scenario is stopped for 2000 milliseconds
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        HomeMailPage homeMailPage = new HomeMailPage(driver);
        String userNameXPath = homeMailPage.getXPathSelector(logName);
        WebElement userName = homeMailPage.getLogNameWebElement(userNameXPath);
        Assertions.assertTrue(userName.isEnabled());
    }
}
