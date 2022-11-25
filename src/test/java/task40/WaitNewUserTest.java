package task40;

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

public class WaitNewUserTest {
    private WebDriver driver;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
        driver.manage().window().fullscreen();
    }
    @Test
    public void waitNewUserTest() throws InterruptedException {
        WebElement button = driver.findElement(By.id("save"));
        button.click();

        WebElement loadingText = driver.findElement(By.id("loading"));
        boolean loadingState = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElement(loadingText,"First Name :"));

        Assertions.assertTrue(loadingState);
    }

    @AfterEach
    void cleanUp()
    {
        driver.quit();
    }
}
