package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task40.page.JavaScriptConfirmationBoxPage;

import static task40.util.TestConstants.*;

public class JavaScriptConfirmationBoxTest extends BaseTest {

    public JavaScriptConfirmationBoxTest() {
        super(JAVA_SCRIPT_URL);
    }

    @Test
    public void confirmAcceptBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        page.clickButton();
        String actualText = page.getMessageTextAndAcceptConfirmationBox();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void confirmCancelBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        page.clickButton();
        String actualText = page.getMessageTextAndDismissConfirmationBox();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }

    @Test
    public void confirmMessageBoxTest()
    {
        JavaScriptConfirmationBoxPage page = new JavaScriptConfirmationBoxPage(super.driver);
        page.clickButton();
        String actualAlertText = page.getAlertTextAndDismissConfirmationBox();
        Assertions.assertEquals("Press a button!", actualAlertText);
    }
}
