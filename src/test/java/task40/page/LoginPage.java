package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    private By loginButtonBy = By.xpath("//div[@class='PSHeader-Right']//button");
    private By loginInputBy = By.id("passp-field-login");
    private By sighInButtonBy = By.id("passp:sign-in");
    private By passInOutBy = By.id("passp-field-passwd");
    private final WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = wait;
    }

    public void logIn(String login, String password) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait
                .until(ExpectedConditions.elementToBeClickable(loginButtonBy));
        loginButton.click();

        WebElement loginInput = driver.findElement(loginInputBy);
        loginInput.sendKeys(login);
        WebElement signInButton = driver.findElement(sighInButtonBy);
        signInButton.click();
        //Explicit wait - WebDriver is waiting during for 10 seconds when password input appears on the page
        WebElement passwordInput = wait
                .until(ExpectedConditions.elementToBeClickable(passInOutBy));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        //Explicit wait - WebDriver is waiting during for 10 seconds when sign-in button appears on the page
        WebElement signInConfirmButton = wait
                .until(ExpectedConditions.elementToBeClickable(sighInButtonBy));
        signInConfirmButton.click();
        Thread.sleep(2000);
    }
}
