package task70.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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