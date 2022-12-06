package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import task40.helpes.BaseTest;
import task40.helpes.JavaScriptAlertPage;

import static task40.helpes.TestConstants.*;

public class JavaScriptAlertTest extends BaseTest {

    public JavaScriptAlertTest() {
        super(JAVA_SCRIPT_ALERT_URL);
    }

    @Test
    public void alertTextTest() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(super.driver);
        WebElement button = page.getButtonWebElement();
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
}
