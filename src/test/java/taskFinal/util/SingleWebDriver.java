package taskFinal.util;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static taskFinal.util.TestConfig.*;

public final class SingleWebDriver {
    private static SingleWebDriver instance;
    private WebDriver driver;
    private SingleWebDriver() {}

    public WebDriver getBrowserDriver(BrowserType browser)
    {
        switch (browser)
        {
            case Chrome:
                driver = getChromeDriver();
                break;
            case Firefox:
                    driver = getFirefoxDriver();
                    break;
            default:
                System.out.println("Error - browser is not supported");

        }
        return driver;
    }

    public static SingleWebDriver getWebDriverInstance()
    {
        if (instance == null) {
            instance = new SingleWebDriver();
        }
        return instance;
    }

    public WebDriver getChromeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (driver == null)
        {driver = new ChromeDriver(options);}
        return driver;
    }

    public WebDriver getFirefoxDriver()
    {
        if (driver == null)
        {driver = new FirefoxDriver();}
        return driver;
    }

    public RemoteWebDriver getSauceLabsWebDriver() throws MalformedURLException {
        MutableCapabilities multcaps = null;
        switch (BROWSER_TYPE)
        {
            case Chrome:
            {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("111");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", BUILD_ID);
                sauceOptions.put("name", TEST_NAME);
                browserOptions.setCapability("sauce:options", sauceOptions);
                multcaps = browserOptions;
                break;
            }
            case Firefox:
            {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("111");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", BUILD_ID);
                sauceOptions.put("name", TEST_NAME);
                browserOptions.setCapability("sauce:options", sauceOptions);
                multcaps = browserOptions;
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
