package taskFinal.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import taskFinal.util.SingleWebDriver;

import static taskFinal.util.TestConfig.*;


public abstract class TestBase {
    protected WebDriver driver;
    private String url;

    public TestBase(String url) {
        this.url = url;
    }

    @BeforeEach
    protected void setUp() {
        driver = SingleWebDriver.getWebDriverInstance().getBrowserDriver(BROWSER_TYPE);
        driver.get(this.url);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    protected void cleanUp() {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }
}
