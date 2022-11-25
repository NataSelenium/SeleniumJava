package task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import task40.helpes.Employee;
import task40.helpes.TableSortSearchPage;

import java.util.ArrayList;
import java.util.List;

public class TableSortSearchTest {
    private WebDriver driver;
    private final int ageOption = 25;
    private final int salaryOption = 150000;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
    }
    @Test
    void tableSortSearchTest() throws InterruptedException {
        List<Employee> employeeList = new ArrayList<Employee>();
        TableSortSearchPage page = new TableSortSearchPage(driver);
        Select select = page.getWebElementByName("example_length");
        select.selectByValue("10");

        page.collectTableDataList("table#example", employeeList);

        WebElement nextButton = page.getWebElementById("example_next");

        page.clickNextButton(nextButton, employeeList);
        page.printCustomDataTableList(employeeList, ageOption, salaryOption);

    }

    @AfterEach
    void cleanUp()
    {
        driver.quit();
    }
}
