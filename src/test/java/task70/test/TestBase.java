package task70.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import task70.util.SingleWebDriver;

public abstract class TestBase {
    protected WebDriver driver;
    private String url;

    public TestBase(String url) {
        this.url = url;
    }

    @BeforeEach
    protected void setUp() {
        driver = SingleWebDriver.getWebDriverInstance().getDriver();
        driver.get(this.url);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    protected void cleanUp() {
        SingleWebDriver.getWebDriverInstance().closeDriver();
    }
}
