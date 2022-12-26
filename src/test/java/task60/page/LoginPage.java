package task60.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{
    private WebDriver driver;
    private By loginButtonBy = By.xpath("//div[@class='PSHeader-Right']//button");
    private By loginInputBy = By.id("passp-field-login");
    private By sighInButtonBy = By.id("passp:sign-in");
    private By passInOutBy = By.id("passp-field-passwd");
    private WebDriverWait wait;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage logIn(String log, String pass) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait
                .until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        loginButton.click();

        WebElement loginInput = driver.findElement(loginInputBy);
        loginInput.sendKeys(log);
        WebElement signInButton = driver.findElement(sighInButtonBy);
        signInButton.click();

        WebElement passwordInput = wait
                .until(ExpectedConditions.elementToBeClickable(passInOutBy));
        passwordInput.clear();
        passwordInput.sendKeys(pass);
        Thread.sleep(2000);

        WebElement signInConfirmButton = wait
                .until(ExpectedConditions.elementToBeClickable(sighInButtonBy));
        signInConfirmButton.click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }

    public boolean isLoginPagePresent() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        return loginButton.isDisplayed();
    }
}
