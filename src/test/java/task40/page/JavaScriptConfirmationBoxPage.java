package task40.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptConfirmationBoxPage {
    private final WebDriver driver;
    private By buttonBy = By.xpath("//button[@onclick='myConfirmFunction()']");
    private By messageBy = By.id("confirm-demo");

    public JavaScriptConfirmationBoxPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickButton()
    {
        driver.findElement(buttonBy).click();
    }

    public String getMessageTextAndAcceptConfirmationBox()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return driver.findElement(messageBy).getText();
    }

    public String getMessageTextAndDismissConfirmationBox()
    {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return driver.findElement(messageBy).getText();
    }

    public String getAlertTextAndDismissConfirmationBox()
    {
        Alert alert = driver.switchTo().alert();
        String confirmBoxText = alert.getText();
        alert.dismiss();
        return confirmBoxText;
    }
}
