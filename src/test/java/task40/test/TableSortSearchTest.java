package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task40.util.Employee;
import task40.page.TableSortSearchPage;

import java.util.ArrayList;
import java.util.List;

import static task40.util.TestConstants.*;

public class TableSortSearchTest extends BaseTest {
    private final int ageOption = 25;
    private final int salaryOption = 150000;

    private List<Employee> customEmployeeList = new ArrayList<Employee>();

    public TableSortSearchTest() {
        super(TABLE_SORT_URL);
    }

    @Test
    void tableSortSearchTest() throws InterruptedException {
        List<Employee> actualEmployeeList = new ArrayList<Employee>();
        TableSortSearchPage page = new TableSortSearchPage(super.driver);
        page.selectDropDownOption();
        page.collectTableDataList(actualEmployeeList);
        customEmployeeList = page.getCustomDataTableList(actualEmployeeList, ageOption, salaryOption);
        Assertions.assertEquals(getExpectedEmployeeList().size(),customEmployeeList.size());
        Assertions.assertTrue(getExpectedEmployeeList().containsAll(customEmployeeList));
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
