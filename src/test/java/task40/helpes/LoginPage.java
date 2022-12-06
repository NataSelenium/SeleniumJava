package task40.helpes;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    private String loginButtonXPath = "//div[@class='PSHeader-Right']//button";
    private String loginInputId = "passp-field-login";
    private String signInButtonId = "passp:sign-in";
    private String passInoutId = "passp-field-passwd";
    private final WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void enterCredential(String login, String password) throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXPath));
        Assertions.assertTrue(loginButton.isDisplayed(), "The login button is displayed");
        loginButton.click();

        WebElement loginInput = driver.findElement(By.id(loginInputId));
        loginInput.sendKeys(login);
        WebElement signInButton = driver.findElement(By.id(signInButtonId));
        signInButton.click();
        //Explicit wait - WebDriver is waiting during for 10 seconds when password input appears on the page
        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(passInoutId)));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        //Explicit wait - WebDriver is waiting during for 10 seconds when sign-in button appears on the page
        WebElement signInConfirmButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id(signInButtonId)));
        signInConfirmButton.click();
        Thread.sleep(2000);
    }
}
