package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitNewUserPage {
    public final WebDriver driver;
    private String buttonId = "save";
    private String loadingTextId = "loading";

    public WaitNewUserPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getButtonWebElement()
    {
        return driver.findElement(By.id(buttonId));
    }

    public WebElement getLoadingTextWebElement()
    {
        return driver.findElement(By.id(loadingTextId));
    }
}
