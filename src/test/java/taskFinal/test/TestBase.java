package taskFinal.test;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import taskFinal.util.SingleWebDriver;

import java.net.MalformedURLException;

public abstract class TestBase {
    protected WebDriver driver;
    private String url;

    public TestBase(String url) {
        this.url = url;
    }

    @BeforeEach
    protected void setUp() throws MalformedURLException {
        driver = SingleWebDriver.getWebDriverInstance().getTargetWebDriver();
        driver.get(this.url);
        driver.manage().window().fullscreen();
    }
}
