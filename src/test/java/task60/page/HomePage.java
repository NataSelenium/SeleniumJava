package task60.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By composeLinkBy = By.cssSelector("a[href=\"#compose\"]");
    private By logOutLinkBy = By.xpath("//a/span[text()='Log out']");

    public HomePage(WebDriver driver){
    this.driver = driver;
    }

    public boolean isHomePagePresent() {
        driver.manage().window().fullscreen();
        WebElement composeLink = new  WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(composeLinkBy));
        return composeLink.isDisplayed();
    }

    public WebElement getLoginNameLabel(String name)
    {
        String xPathSelector = "//a/span[text()='" + name + "']";

        WebElement logNameWebElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xPathSelector)));
        return logNameWebElement;
    }

    public LoginPage logOut(String log)
    {
        driver.manage().window().fullscreen();
        getLoginNameLabel(log).click();
        driver.findElement(logOutLinkBy).click();
        driver.manage().window().fullscreen();
        return new LoginPage(driver);
    }
}
