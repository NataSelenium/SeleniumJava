package taskFinal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static taskFinal.util.TestConfig.*;

public class CreateAccountPage {

    private WebDriver driver;

    @FindBy(css = "input#firstname")
    WebElement firstNameInput;

    @FindBy(css = "input#lastname")
    WebElement lastNameInput;

    @FindBy(css = "input#email_address")
    WebElement emailAddressInput;

    @FindBy(css = "input#password")
    WebElement passwordInput;

    @FindBy(css = "input#password-confirmation")
    WebElement passwordConfirmationInput;

    @FindBy(css = "button[title='Create an Account']")
    WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage addNewAccount()
    {
        int randomInteger = 1+ (int)(Math.random()*120);
        firstNameInput.sendKeys(FIRST_NAME_TEST);
        lastNameInput.sendKeys(LAST_NAME_TEST);
        emailAddressInput.sendKeys(randomInteger + EMAIL_TEST);
        passwordInput.sendKeys(PASS_TEST);
        passwordConfirmationInput.sendKeys(PASS_TEST);
        createAccountButton.click();
        return new AccountPage(driver);
    }
}
