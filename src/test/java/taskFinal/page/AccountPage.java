package taskFinal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Address Book']")

    WebElement addressBookLink;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddressBookPage getAddressBookPage()
    {
        addressBookLink.click();
        return new AddressBookPage(driver);
    }

    public boolean isAccountPageDisplayed()
    {
        return addressBookLink.isDisplayed();
    }
}
