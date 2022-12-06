package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptConfirmationBoxPage {
    private final WebDriver driver;
    private String xPathSelector = "//button[@onclick='myConfirmFunction()']";
    private String messageId = "confirm-demo";

    public JavaScriptConfirmationBoxPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getButtonWebElement()
    {
        return driver.findElement(By.xpath(xPathSelector));
    }

    public WebElement getAlertMessageText()
    {
        return driver.findElement(By.id(messageId));
    }
}
