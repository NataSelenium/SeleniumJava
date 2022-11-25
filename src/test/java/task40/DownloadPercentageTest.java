package task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class DownloadPercentageTest {
    private WebDriver driver;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
        driver.manage().window().fullscreen();
    }
    @Test
    public void downloadPercentageTest() throws InterruptedException {
        WebElement button = driver.findElement(By.id("cricle-btn"));
        button.click();

        // Waiting 15 seconds for an element with text 50% to be present on the page, checking for its presence once every 250 milliseconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);

        WebElement loadingText = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement percentText = driver.findElement(By.className("percenttext"));
                if (percentText.getText().equals("50%"))
                {
                    driver.navigate().refresh();
                    System.out.println("50% is available now");
                    return percentText;
                }
                else
                {
                    System.out.println(percentText.getText() );
                    return null;
                }
            }
        });
    }
    @AfterEach
    void cleanUp()
    {
        driver.quit();
    }
}
