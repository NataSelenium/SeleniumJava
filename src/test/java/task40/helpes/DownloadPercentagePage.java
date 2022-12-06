package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public class DownloadPercentagePage {
    private final WebDriver driver;
    private String buttonId = "cricle-btn";
    private String percentTextName = "percenttext";
    private String percentsText = "50%";

    public DownloadPercentagePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getButtonWebElement()
    {
        return driver.findElement(By.id(buttonId));
    }

    public ExpectedCondition<Boolean> percentsCondition = ExpectedConditions.textMatches(By.className(percentTextName), Pattern.compile(percentsText));
}
