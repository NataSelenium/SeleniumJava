package taskFinal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    @FindBy(css="input[name='login[username]']")
    WebElement loginInput;

    @FindBy(css = "input[name='login[password]']")
    WebElement passwordInput;

    @FindBy(xpath = "(//div[@class='primary']//button)[position()=1]")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String log, String pass)
    {
        loginInput.sendKeys(log);
        passwordInput.sendKeys(pass);
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().fullscreen();
        return new HomePage(driver);
    }
}
