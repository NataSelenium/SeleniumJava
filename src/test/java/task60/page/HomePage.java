package task60.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
