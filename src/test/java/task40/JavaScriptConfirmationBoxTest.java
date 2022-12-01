package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import task40.helpes.BaseTest;

import static task40.helpes.TestConstants.*;

public class JavaScriptConfirmationBoxTest extends BaseTest {

    public JavaScriptConfirmationBoxTest() {
        super(JAVA_SCRIPT_CONFIRMATION_BOX_URL);
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
}
