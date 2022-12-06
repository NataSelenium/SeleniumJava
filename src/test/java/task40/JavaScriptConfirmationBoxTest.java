package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import task40.helpes.BaseTest;
import task40.helpes.JavaScriptConfirmationBoxPage;

import static task40.helpes.TestConstants.*;

public class JavaScriptConfirmationBoxTest extends BaseTest {

    public JavaScriptConfirmationBoxTest() {
        super(JAVA_SCRIPT_CONFIRMATION_BOX_URL);
    }

    @Test
    public void confirmAcceptBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        WebElement button = page.getButtonWebElement();
        button.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            WebElement message = page.getAlertMessageText();
            Assertions.assertEquals("You pressed OK!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmCancelBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        WebElement button = page.getButtonWebElement();
        button.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            WebElement message = page.getAlertMessageText();
            Assertions.assertEquals("You pressed Cancel!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmMessageBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        WebElement button = page.getButtonWebElement();
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
