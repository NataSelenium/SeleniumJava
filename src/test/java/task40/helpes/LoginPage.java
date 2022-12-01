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
    public void enterCredential(WebDriver driver, String login, String password) throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='PSHeader-Right']//button"));
        Assertions.assertTrue(loginButton.isDisplayed(), "The login button is displayed");
        loginButton.click();

        WebElement loginInput = driver.findElement(By.id("passp-field-login"));
        loginInput.sendKeys(login);
        WebElement signInButton = driver.findElement(By.id("passp:sign-in"));
        signInButton.click();
        //Explicit wait - WebDriver is waiting during for 10 seconds when password input appears on the page
        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("passp-field-passwd")));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        //Explicit wait - WebDriver is waiting during for 10 seconds when sign-in button appears on the page
        WebElement signInConfirmButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("passp:sign-in")));
        signInConfirmButton.click();
        Thread.sleep(2000);
    }
}
