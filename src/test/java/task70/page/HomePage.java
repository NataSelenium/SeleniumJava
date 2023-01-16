package task70.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static task70.util.TestConfig.*;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "a[href=\"#compose\"]")
    WebElement composeLink;

    @FindBy(xpath = "//a/span[text()='Log out']")
    WebElement logOutLink;

    public HomePage(WebDriver driver){
    this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePagePresent() {
        driver.manage().window().fullscreen();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(composeLink));
        return composeLink.isDisplayed();
    }

    public WebElement getLoginNameLabel(String name)
    {
        String xPathSelector = "//a/span[text()='" + name + "']";

        WebElement logNameWebElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPathSelector)));
        return logNameWebElement;
    }

    public LoginPage logOut(String log)
    {
        if (isHomePagePresent())
        {
            driver.manage().window().fullscreen();
        }
        getLoginNameLabel(log).click();
        logOutLink.click();
        driver.manage().window().fullscreen();
        return new LoginPage(driver);
    }

    public void takeHomePageScreenShot(WebDriver driver)
    {
        if (isHomePagePresent()) {
            driver.manage().window().fullscreen();
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(SCREEN_SHORT_FILE));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isScreenShotFileExist()
    {
        File screenshot = new File(SCREEN_SHORT_FILE);
        return screenshot.exists();
    }
}
