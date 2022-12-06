package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertPage {
    private final WebDriver driver;

    private String xPathSelector = "//button[@onclick='myAlertFunction()']";

    public JavaScriptAlertPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getButtonWebElement()
    {
        return driver.findElement(By.xpath(xPathSelector));
    }
}
