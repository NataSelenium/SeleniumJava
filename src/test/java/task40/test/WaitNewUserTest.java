package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task40.page.WaitNewUserPage;

import static task40.util.TestConstants.*;

public class WaitNewUserTest extends BaseTest {

    public WaitNewUserTest() {
        super(WAIT_NEW_USER_URL);
    }

    @Test
    public void waitNewUserTest() throws InterruptedException {
        WaitNewUserPage page = new WaitNewUserPage(super.driver);
        page.clickButton();
        boolean loadingState = page.getLoadingTextState();
        Assertions.assertTrue(loadingState);
    }
}
