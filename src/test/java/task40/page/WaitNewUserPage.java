package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitNewUserPage {
    public final WebDriver driver;
    private By buttonBy = By.id("save");
    private By loadingTextBy = By.id("loading");

    public WaitNewUserPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButton()
    {
        driver.findElement(buttonBy).click();
    }

    public boolean getLoadingTextState()
    {
        return
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(loadingTextBy), "First Name :"));
    }
}
