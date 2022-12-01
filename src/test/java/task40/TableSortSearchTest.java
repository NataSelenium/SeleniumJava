package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import task40.helpes.BaseTest;
import task40.helpes.Employee;
import task40.helpes.TableSortSearchPage;

import java.util.ArrayList;
import java.util.List;

import static task40.helpes.TestConstants.*;

public class TableSortSearchTest extends BaseTest {
    private final int ageOption = 25;
    private final int salaryOption = 150000;
    private final String tableCssSelector = "table#example tbody";
    private List<Employee> customEmployeeList, expectedEmployeeList = new ArrayList<Employee>();

    public TableSortSearchTest() {
        super(TABLE_SORT_URL);
    }

    @Test
    void tableSortSearchTest() throws InterruptedException {
        List<Employee> actualEmployeeList = new ArrayList<Employee>();
        TableSortSearchPage page = new TableSortSearchPage(super.driver);
        Select select = page.getWebElementByName("example_length");
        select.selectByValue("10");

        page.collectTableDataList(tableCssSelector, actualEmployeeList);
        customEmployeeList = page.getCustomDataTableList(actualEmployeeList, ageOption, salaryOption);
        expectedEmployeeList = getExpectedEmployeeList();

        Assertions.assertEquals(expectedEmployeeList.size(),customEmployeeList.size());
        Assertions.assertTrue(expectedEmployeeList.containsAll(customEmployeeList));

    }

        public List<Employee> getExpectedEmployeeList()
        {
            List<Employee> expectedEmployeeList = new ArrayList<Employee>();
            expectedEmployeeList.add(new Employee("A. Cox", "Junior Technical Author", "San Francisco"));
            expectedEmployeeList.add(new Employee("B. Greer", "Software Engineer", "London"));
            expectedEmployeeList.add(new Employee("G. Joyce","Developer","Edinburgh"));
            expectedEmployeeList.add(new Employee("H. Chandler","Sales Assistant","San Francisco"));
            expectedEmployeeList.add(new Employee("J. Gaines","Office Manager","London"));
            expectedEmployeeList.add(new Employee("M. House","Integration Specialist","Sidney"));
            expectedEmployeeList.add(new Employee("S. Burks","Developer","London"));
            return expectedEmployeeList;
        }
}
