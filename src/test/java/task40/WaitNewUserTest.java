package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task40.helpes.BaseTest;

import java.time.Duration;

import static task40.helpes.TestConstants.WAIT_NEW_USER_URL;

public class WaitNewUserTest extends BaseTest {

    public WaitNewUserTest() {
        super(WAIT_NEW_USER_URL);
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
}
