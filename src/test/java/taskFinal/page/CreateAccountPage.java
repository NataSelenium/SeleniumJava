package taskFinal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    private String firstNameTest = "Natalia";

    private String lastNameTest = "Damorad";

    private String emailTest = "WhiteDecember12@yandex.com";

    private String passTest = "TestPass3$";

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage addNewAccount()
    {
        int randomInteger = 1+ (int)(Math.random()*120);
        firstNameInput.sendKeys(firstNameTest);
        lastNameInput.sendKeys(lastNameTest);
        emailAddressInput.sendKeys(randomInteger + emailTest);
        passwordInput.sendKeys(passTest);
        passwordConfirmationInput.sendKeys(passTest);
        createAccountButton.click();
        return new AccountPage(driver);
    }
}
