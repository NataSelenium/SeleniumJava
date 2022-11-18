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
    private String logName = "RoseMagic16";
    private String pass = "NovemberLeaves2*";

    @BeforeEach
    void  setup()
    {
        driver = new ChromeDriver();
    }

    @Test
    void loginYandexMailTest()
    {
        driver.get("https://mail.yandex.com");

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='PSHeader-Right']//button"));

        Assertions.assertTrue(loginButton.isDisplayed(), "The login button is displayed");
        loginButton.click();

        WebElement loginInput = driver.findElement(By.id("passp-field-login"));
        loginInput.sendKeys(logName);

        WebElement signInButton = driver.findElement(By.id("passp:sign-in"));
        signInButton.click();

        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("passp-field-passwd")));
        passwordInput.sendKeys(pass);

        WebElement signInConfirmButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("passp:sign-in")));
        signInConfirmButton.click();

        WebElement telemostService = driver.findElement(By.xpath("//span[@class='PSHeaderService-Text' and text()='Telemost']"));
        Assertions.assertTrue(telemostService.getText().equals("Telemost"));

        WebElement composeLink = driver.findElement(By.linkText("#compose"));
        Assertions.assertTrue(composeLink.isDisplayed());

        WebElement labelRemindMe = driver.findElement(By.cssSelector("div[title='Remind me later']"));
        Assertions.assertEquals("div", labelRemindMe.getTagName());
    }

    @AfterEach
    void cleanup()
    {
        driver.quit();
    }
}
