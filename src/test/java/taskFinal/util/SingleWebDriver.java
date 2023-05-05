package taskFinal.util;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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

    public WebDriver getTargetWebDriver() throws MalformedURLException {
        switch (TARGET)
        {
            case "Local":
                driver = getLocalDriver();
                break;
            case "Remote":
                driver = getSauceLabsWebDriver();
                break;
            default:
                System.out.println("Error - target is not defined");
        }
        driver.manage().window().fullscreen();
        return driver;
    }

    public WebDriver getLocalDriver()
    {
        switch (BROWSER_TYPE)
        {
            case Chrome:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                if (driver == null)
                {driver = new ChromeDriver(options);}
                break;
            case Firefox:
                if (driver == null)
                {driver = new FirefoxDriver();}
                break;
            case Edge:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                if (driver == null)
                {driver = new EdgeDriver(edgeOptions);
                }
                break;
            default:
                System.out.println("Error - browser is not supported");

        }
        driver.manage().window().fullscreen();
        return driver;
    }

    public static SingleWebDriver getWebDriverInstance()
    {
        if (instance == null) {
            instance = new SingleWebDriver();
        }
        return instance;
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
            case Edge:
            {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
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
        String browserName = "";
        switch (BROWSER_TYPE)
        {
            case Chrome:
                browserName = ((ChromeDriver)driver).getCapabilities().getBrowserName();
                break;
            case Firefox:
                browserName = ((FirefoxDriver)driver).getCapabilities().getBrowserName();
                break;
            case Edge:
                browserName = ((EdgeDriver)driver).getCapabilities().getBrowserName();
                break;
            default:
                System.out.println("Error - browser is not supported");
        }
        return browserName;
    }

    public String getBrowserVersion()
    {
        String browserVersion = "";
        switch (BROWSER_TYPE)
        {
            case Chrome:
                browserVersion = ((ChromeDriver)driver).getCapabilities().getBrowserVersion();
                break;
            case Firefox:
                browserVersion = ((FirefoxDriver)driver).getCapabilities().getBrowserVersion();
                break;
            case Edge:
                browserVersion = ((EdgeDriver)driver).getCapabilities().getBrowserVersion();
                break;
            default:
                System.out.println("Error - browser is not supported");
        }
        return browserVersion;
    }
}
