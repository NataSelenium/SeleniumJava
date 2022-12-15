package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class DownloadPercentagePage {
    private final WebDriver driver;
    private By buttonBy = By.id("cricle-btn");
    private By percentTextBy = By.className("percenttext");
    private String percentsText = "50%";
    private String zeroPercentText = "0%";

    public DownloadPercentagePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButton()
    {
        driver.findElement(buttonBy).click();
    }

    // Waiting 15 seconds for an element with text 50% to be present on the page, checking for its presence once every 250 milliseconds.
    public void waitFiftyPercentsDownloading()
    {
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofMillis(10))
                        .ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.textMatches(percentTextBy, Pattern.compile(percentsText)));
    }

    public Boolean verifyZeroPercentCondition()
    {
        return driver.findElement(percentTextBy).getText().equals(zeroPercentText);
    }
}
