package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeMailPage {

    private final WebDriver driver;

    public HomeMailPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getLoginNameLabel(String name)
    {
        String xPathSelector = "//a/span[text()='" + name + "']";
        //Explicit wait - WebDriver is waiting during for 10 seconds when login name label appears on the page
        WebElement logNameWebElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPathSelector)));
        return logNameWebElement.getText();
    }
}
