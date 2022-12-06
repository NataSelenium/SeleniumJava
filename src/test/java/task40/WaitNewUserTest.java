package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task40.helpes.BaseTest;
import task40.helpes.WaitNewUserPage;

import java.time.Duration;

import static task40.helpes.TestConstants.*;

public class WaitNewUserTest extends BaseTest {

    public WaitNewUserTest() {
        super(WAIT_NEW_USER_URL);
    }

    @Test
    public void waitNewUserTest() throws InterruptedException {
        WaitNewUserPage page = new WaitNewUserPage(super.driver);

        WebElement button = page.getButtonWebElement();
        button.click();

        WebElement loadingText = page.getLoadingTextWebElement();
        boolean loadingState = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElement(loadingText,"First Name :"));

        Assertions.assertTrue(loadingState);
    }
}
