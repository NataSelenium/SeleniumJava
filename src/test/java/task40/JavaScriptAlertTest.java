package task40;

import org.openqa.selenium.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertTest {
    private WebDriver driver;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
    }
    @Test
    public void alertTextTest()
    {
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().window().fullscreen();

        WebElement button = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        button.click();

        try {

            Alert alert = driver.switchTo().alert();

            String textOnAlert = alert.getText();

            alert.accept();

            Assertions.assertEquals("I am an alert box!", textOnAlert);

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
