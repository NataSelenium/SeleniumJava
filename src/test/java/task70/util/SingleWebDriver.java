package task70.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class SingleWebDriver {
    private static SingleWebDriver instance;
    public WebDriver driver;

    public SingleWebDriver(WebDriver driver){
        this.driver = driver;
    }

    public static WebDriver getInstance(WebDriver driver)
    {
        if (instance == null) {
            driver = new ChromeDriver();
            instance = new SingleWebDriver(driver);
        }
        return driver;
    }
}
