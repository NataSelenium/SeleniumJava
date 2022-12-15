package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task40.page.JavaScriptAlertPage;

import static task40.util.TestConstants.*;

public class JavaScriptAlertTest extends BaseTest {

    public JavaScriptAlertTest() {
        super(JAVA_SCRIPT_URL);
    }

    @Test
    public void alertTextTest() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(super.driver);
        page.clickButton();
        String actualOnAlertText = page.getTextAndCloseAlert();
        Assertions.assertEquals("I am an alert box!", actualOnAlertText);
    }
}
