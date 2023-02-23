package task70.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import task70.util.SingleWebDriver;

import java.net.MalformedURLException;

public abstract class TestBase {
    protected WebDriver driver;
    private String url;

    public TestBase(String url) {
        this.url = url;
    }

    @BeforeEach
    protected void setUp() throws MalformedURLException {
        driver = SingleWebDriver.getWebDriverInstance().getRemoveWebDriver();
        driver.get(this.url);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    protected void cleanUp() {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }
}
