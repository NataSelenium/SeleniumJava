package taskFinal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import taskFinal.util.Address;

public class AddressBookPage {

    private WebDriver driver;

    @FindBy(css="button[title='Add New Address']")
    WebElement addNewAddressButton;

    @FindBy(css = "input#telephone")
    WebElement phoneNumberInput;

    @FindBy(css = "input#street_1")
    WebElement streetInput;

    @FindBy(css = "input#city")
    WebElement cityInput;

    @FindBy(css = "select#region_id")
    WebElement stateSelect;

    @FindBy(css = "input#zip")
    WebElement zipInput;

    @FindBy(css = "button[title='Save Address']")
    WebElement saveButton;

    @FindBy(xpath = "//tbody/tr[1]")
    WebElement addressTable;

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Address addNewAddress(Address address)
    {
        driver.manage().window().fullscreen();
        addNewAddressButton.click();
        phoneNumberInput.sendKeys(address.getCell());
        streetInput.sendKeys(address.getStreet());
        cityInput.sendKeys(address.getCity());
        Select select = new Select(stateSelect);
        select.selectByVisibleText(address.getState());
        zipInput.sendKeys(address.getZip());
        saveButton.click();
        return address;
    }

    public Address getActualAddress()
    {
        Address actualAddress;
        actualAddress = new Address(
                addressTable.findElement(By.xpath("./td[8]")).getText(),
                addressTable.findElement(By.xpath("./td[3]")).getText(),
                addressTable.findElement(By.xpath("./td[4]")).getText(),
                addressTable.findElement(By.xpath("./td[6]")).getText(),
                addressTable.findElement(By.xpath("./td[7]")).getText()
        );
        return actualAddress;
    }
}
