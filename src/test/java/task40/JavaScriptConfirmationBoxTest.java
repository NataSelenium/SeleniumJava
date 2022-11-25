package task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptConfirmationBoxTest {
    private WebDriver driver;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().window().fullscreen();
    }
    @Test
    public void confirmAcceptBoxTest()
    {
        WebElement button = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        button.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            WebElement message = driver.findElement(By.id("confirm-demo"));
            Assertions.assertEquals("You pressed OK!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void confirmCancelBoxTest()
    {
        WebElement button = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        button.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            WebElement message = driver.findElement(By.id("confirm-demo"));
            Assertions.assertEquals("You pressed Cancel!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void confirmMessageBoxTest()
    {
        WebElement button = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        button.click();

        try {
            Alert alert = driver.switchTo().alert();
            String confirmBoxText = alert.getText();
            alert.dismiss();
            Assertions.assertEquals("Press a button!", confirmBoxText);
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    @AfterEach
    void cleanUp()
    {
        driver.quit();
    }
}
