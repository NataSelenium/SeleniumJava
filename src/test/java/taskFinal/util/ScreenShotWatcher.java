package taskFinal.util;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.net.MalformedURLException;
import java.util.Optional;

public class ScreenShotWatcher implements TestWatcher {
    WebDriver driver;
    String path;

    public ScreenShotWatcher(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable throwable) {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> optional) {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {

        try {
            driver = SingleWebDriver.getWebDriverInstance().getTargetWebDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/jpg",
                "jpg",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        Allure.addAttachment("Browser information", "text/plain", SingleWebDriver.getWebDriverInstance().getBrowserName());
        Allure.addAttachment("Browser version", "text/plain", SingleWebDriver.getWebDriverInstance().getBrowserVersion());
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }
}
