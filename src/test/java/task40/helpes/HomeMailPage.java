package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeMailPage {

    private final WebDriver driver;
    private String xPathSelector;
    private WebElement logNameWebElement;

    public HomeMailPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getXPathSelector(String log) {
        xPathSelector = "//a/span[text()='" + log + "']";
        return xPathSelector;
    }

    public WebElement getLogNameWebElement(String userNameXPath)
    {
        //Explicit wait - WebDriver is waiting during for 10 seconds when login name label appears on the page
        logNameWebElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(userNameXPath)));
        return logNameWebElement;
    }
}
