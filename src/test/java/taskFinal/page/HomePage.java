package taskFinal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signInLink;

    @FindBy(xpath = "//div[@class='panel header']//span[contains(text(), 'Welcome')]")
    WebElement welcomeInfo;

    @FindBy(xpath = "(//button[@class='action switch'])[position()=1]")
    WebElement changeButton;

    @FindBy(xpath = "(//a[text()='My Account'])[position()=1]")
    WebElement myAccountLink;

    @FindBy(xpath = "//a/span[text()='Women']")
    WebElement womenLink;

    @FindBy(xpath = "//header//a[text()='Create an Account']")
    WebElement createAccountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }

        public LoginPage getLoginPage()
        {
            signInLink.click();
            return new LoginPage(driver);
        }

        public boolean isHomePagePresent()
        {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(welcomeInfo));
            return welcomeInfo.isDisplayed();
        }

        public AccountPage getAccountPage()
        {
            changeButton.click();
            myAccountLink.click();
            return new AccountPage(driver);
        }

        public WomenPage getWomenPage()
        {
            womenLink.click();
            return new WomenPage(driver);
        }

        public CreateAccountPage getCreateAccountPage()
        {
            createAccountLink.click();
            return new CreateAccountPage(driver);
        }
    }

