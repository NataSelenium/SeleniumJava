package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import task40.util.Employee;

import java.util.ArrayList;
import java.util.List;

public class TableSortSearchPage {
    private final WebDriver driver;
    private By nextButtonBy = By.id("example_next");
    private By selectBy = By.name("example_length");
    private By tableBy = By.cssSelector("table#example tbody");
    private final String selectOption = "10";

    public TableSortSearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectDropDownOption()
    {
        Select select =  new Select(driver.findElement(selectBy));
        select.selectByValue(selectOption);
    }

    public void collectTableDataList(List<Employee> list)
    {
        WebElement next = driver.findElement(nextButtonBy);
        boolean buttonEnabledState = true;
        while (buttonEnabledState) {
            WebElement table = driver.findElement(tableBy);
            List<WebElement> rows =
                    table.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                String  employeeName = row.findElement(By.xpath("./td[1]")).getText();
                String  employeePosition = row.findElement(By.xpath("./td[2]")).getText();
                String employeeOffice = row.findElement(By.xpath("./td[3]")).getText();
                int employeeAge = Integer.valueOf(row.findElement(By.xpath("./td[4]")).getText());
                int employeeSalary = Integer.valueOf(row.findElement(By.xpath("./td[6]")).getText().replaceAll("[^0-9]", ""));

                if (employeeName.length() > 1) {
                    Employee emp = new Employee(employeeName, employeePosition, employeeOffice, employeeAge, employeeSalary);
                    list.add(emp);
                }
            }
            clickNextButton(next);
            next = driver.findElement(nextButtonBy);
            buttonEnabledState = getNextButtonEnabledState(next);
        }
    }

        private boolean getNextButtonEnabledState(WebElement button)
        {
            return !button.getAttribute("class").contains("disabled");
        }

        private void clickNextButton(WebElement nextButton)
        {
                nextButton.click();
        }

        public List<Employee> getCustomDataTableList(List<Employee> empList, int ageOption, int salaryOption)
        {
            List<Employee> empNewList = new ArrayList<Employee>();
            for (Employee emp: empList)
            {
                if (emp.getAge() > ageOption && emp.getSalary() < salaryOption)
                {
                    empNewList.add(new Employee(emp.getName(), emp.getPosition(), emp.getOffice()));
                }
            }
            return empNewList;
        }
}
