package taskFinal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath="//tbody/tr[1]/td[4]")
    WebElement addedCity;

    private String phoneNumberTest = "+1122223344";

    private String streetAddressTest = "White str 123";

    private String cityTest = "Test City";

    private String stateTest = "Alaska";

    private String zipTest = "12345";

    public AddressBookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress()
    {
        driver.manage().window().fullscreen();
        addNewAddressButton.click();
        phoneNumberInput.sendKeys(phoneNumberTest);
        streetInput.sendKeys(streetAddressTest);
        cityInput.sendKeys(cityTest);
        Select select = new Select(stateSelect);
        select.selectByVisibleText(stateTest);
        zipInput.sendKeys(zipTest);
        saveButton.click();
    }

    public boolean isNewAddressAdded()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addedCity));
        return  (
                addressTable.findElement(By.xpath("./td[3]")).getText().contains(streetAddressTest) &&
                addressTable.findElement(By.xpath("./td[4]")).getText().contains(cityTest) &&
                addressTable.findElement(By.xpath("./td[6]")).getText().contains(stateTest) &&
                addressTable.findElement(By.xpath("./td[7]")).getText().contains(zipTest)
                );
    }
}
