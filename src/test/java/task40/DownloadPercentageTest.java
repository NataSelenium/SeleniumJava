package task40;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import task40.helpes.BaseTest;

import java.time.Duration;
import java.util.regex.Pattern;

import static task40.helpes.TestConstants.*;

public class DownloadPercentageTest extends BaseTest {

    public DownloadPercentageTest() {
        super(DOWNLOAD_PERCENTAGE_URL);
    }

    @Test
    public void downloadPercentageTest() throws InterruptedException {
        WebElement button = driver.findElement(By.id("cricle-btn"));
        button.click();

        // Waiting 15 seconds for an element with text 50% to be present on the page, checking for its presence once every 250 milliseconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.textMatches(By.className("percenttext"), Pattern.compile("50%")));
        driver.navigate().refresh();
    }
}
