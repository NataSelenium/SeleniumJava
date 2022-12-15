package task40.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {
    private final WebDriver driver;
    private By buttonBy = By.xpath("//button[@onclick='myAlertFunction()']");

    public JavaScriptAlertPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButton()
    {
        driver.findElement(buttonBy).click();
    }

    public String getTextAndCloseAlert()
    {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        return textOnAlert;
    }
}
