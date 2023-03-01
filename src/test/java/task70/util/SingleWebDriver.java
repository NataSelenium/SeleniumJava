package task70.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static task70.util.TestConfig.*;

public final class SingleWebDriver {
    private static SingleWebDriver instance;
    private WebDriver driver;

    private SingleWebDriver() {}

    public static SingleWebDriver getWebDriverInstance()
    {
        if (instance == null) {
            instance = new SingleWebDriver();
        }
        return instance;
    }

    public WebDriver getDriver()
    {
        if (driver == null)
        {driver = new ChromeDriver();}
        return driver;
    }

    public WebDriver getRemoveWebDriver() throws MalformedURLException {
        if (driver == null)
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", OS_LINUX);
            driver = new RemoteWebDriver(new URL(
                    URL_HUB), chromeOptions);
        }
        return driver;
    }

    public void closeDriver()
    {
        driver.close();
        driver = null;
    }

    public String getBrowserName()
    {
        return ((ChromeDriver)driver).getCapabilities().getBrowserName();
    }

    public String getBrowserVersion()
    {
        return ((ChromeDriver)driver).getCapabilities().getBrowserVersion();
    }
}
