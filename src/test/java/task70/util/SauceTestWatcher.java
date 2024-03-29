package task70.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceTestWatcher implements TestWatcher {
    RemoteWebDriver driver;

    public SauceTestWatcher(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    @Override
    public void testSuccessful(ExtensionContext context)
    {
        driver.executeScript("sauce:job-result=passed");
        driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        driver.executeScript("sauce:job-result=failed");
        driver.quit();
    }
}
