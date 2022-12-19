package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task40.page.DownloadPercentagePage;

import static task40.util.TestConstants.*;

public class DownloadPercentageTest extends BaseTest {

    public DownloadPercentageTest() {
        super(DOWNLOAD_PERCENTAGE_URL);
    }

    @Test
    public void downloadPercentageTest() throws InterruptedException {
        DownloadPercentagePage page = new DownloadPercentagePage(super.driver);
        page.clickButton();
        page.waitFiftyPercentsDownloading();
        driver.navigate().refresh();
        Assertions.assertTrue(page.verifyZeroPercentCondition());
    }
}
