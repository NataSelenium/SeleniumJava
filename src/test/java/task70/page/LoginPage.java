package task70.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@href,'auth')]")
    WebElement loginButton;

    @FindBy(id = "passp-field-login")
    WebElement loginInput;

    @FindBy(id = "passp:sign-in")
    WebElement signInButton;

    @FindBy(id = "passp-field-passwd")
    WebElement passInOut;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Login method")
    public HomePage logIn(String log, String pass) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        loginInput.sendKeys(log);
        loginInput.click();

        signInButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(passInOut)).clear();
              passInOut.sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        return new HomePage(driver);
    }

    @Step("Verify if Login Page is displayed")
    public boolean isLoginPagePresent() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loginButton));
        return loginButton.isDisplayed();
    }
}
