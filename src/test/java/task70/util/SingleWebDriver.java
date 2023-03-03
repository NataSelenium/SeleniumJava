package task70.util;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

    public WebDriver getRemoteWebDriver() throws MalformedURLException {
        if (driver == null)
        {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", OS_LINUX);
            driver = new RemoteWebDriver(new URL(
                    URL_HUB), chromeOptions);
        }
        return driver;
    }

    public RemoteWebDriver getSauceLabsWebDriver() throws MalformedURLException {
        MutableCapabilities multcaps = null;
        switch (TEST_CONFIGURATION)
        {
            case "WIN10":
            {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", BUILD_ID);
                sauceOptions.put("name", TEST_NAME);
                browserOptions.setCapability("sauce:options", sauceOptions);
                multcaps = browserOptions;
                break;
            }
            case "WIN8.1":
            {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "firefox");
                caps.setCapability("platform", "Windows 8.1");
                caps.setCapability("version", "39");
                caps.setCapability("build", BUILD_ID);
                caps.setCapability("name", TEST_NAME);
                multcaps = caps;
                break;
            }
            case "LINUX":
            {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "chrome");
                caps.setCapability("platform", "Linux");
                caps.setCapability("version", "40");
                caps.setCapability("build", BUILD_ID);
                caps.setCapability("name", TEST_NAME);
                multcaps = caps;
                break;
            }
            default:{
                System.out.println("Something is going wrong...");
                break;
            }
        }

        URL url = new URL(SAUCE_URL);
        return new RemoteWebDriver(url, multcaps);
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
