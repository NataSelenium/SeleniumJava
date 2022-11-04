package task30;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumMailYandexTest {
    private WebDriver driver;
    private String log_name = "RoseMagic16";
    private String pass = "NovemberLeaves2*";

    @BeforeEach
    void  setup()
    {
        driver = new ChromeDriver();
    }

    @Test
    void loginYandexMailTest()
    {

        FindLocatorClass find = new FindLocatorClass();
        driver.get("https://mail.yandex.com");
        WebElement loginButton = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//div[@class='PSHeader-Right']//button");

        Assertions.assertTrue(loginButton.isDisplayed(), "The login button is displayed");
        loginButton.click();

        WebElement loginInput = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//input[@id='passp-field-login']");
        loginInput.sendKeys(log_name);

        WebElement signInButton = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//button[@id='passp:sign-in']");
        signInButton.click();
        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='passp-field-passwd']")));

        passwordInput.sendKeys(pass);
        WebElement signInButton2 = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='passp:sign-in']")));
        signInButton2.click();

        WebElement telemostService = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//span[@class='PSHeaderService-Text' and text()='Telemost']");
        Assertions.assertTrue(telemostService.getText().equals("Telemost"));

        WebElement composeLink = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//a[@href='#compose']");
        Assertions.assertTrue(composeLink.isDisplayed());

        WebElement labelRemindMe = find.getWebElementByLocatorParameter(driver, LocationByType.XPATH, "//div[@title='Remind me later']");
        Assertions.assertEquals("div", labelRemindMe.getTagName());

    }

    @AfterEach
    void cleanup()
    {
        driver.quit();
    }
}
