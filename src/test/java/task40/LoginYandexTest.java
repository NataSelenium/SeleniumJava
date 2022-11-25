package task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import task40.helpes.HomeMailPage;
import task40.helpes.LoginPage;

import java.time.Duration;

public class LoginYandexTest {
private WebDriver driver;
    @BeforeEach
    void  setup()
    {
        driver = new ChromeDriver();
        //Implicit wait - WebDriver polls the DOM for 5 seconds when trying to find any element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @ParameterizedTest
    @CsvSource({
           "maguar74,        YellowLeaf21%",
            "rosemagic16,         November5%",
    })
    void loginYandexMailTest(String logName, String  pass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredential(logName, pass);

        //Implicit wait - test scenario is stopped for 2000 milliseconds
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        HomeMailPage homeMailPage = new HomeMailPage(driver);
        String userNameXPath = homeMailPage.getXPathSelector(logName);
        WebElement userName = homeMailPage.getLogNameWebElement(userNameXPath);
        Assertions.assertTrue(userName.isEnabled());
    }

    @AfterEach
    void cleanup()
    {
        driver.quit();
    }
}
