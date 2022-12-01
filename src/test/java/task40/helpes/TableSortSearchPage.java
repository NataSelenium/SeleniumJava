package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TableSortSearchPage {
    WebDriver driver;
    private final String nextButtonId = "example_next";

    public TableSortSearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Select getWebElementByName(String name)
    {
        return  new Select(driver.findElement(By.name(name)));
    }
    public WebElement getWebElementById(String id)
    {
        return driver.findElement(By.id(id));
    }

    public void collectTableDataList(String tableSelector, List<Employee> list)
    {
        WebElement next = getWebElementById(nextButtonId);
        boolean buttonEnabledState = true;
        while (buttonEnabledState) {
            WebElement table = driver.findElement(By.cssSelector(tableSelector));
            List<WebElement> rows =
                    table.findElements(By.tagName("tr"));

            for (WebElement row : rows) {
                String employeeName = "";
                String employeePosition = "";
                String employeeOffice = "";
                int employeeAge = 0;
                int employeeSalary = 0;
                employeeName = row.findElement(By.xpath("./td[1]")).getText();
                employeePosition = row.findElement(By.xpath("./td[2]")).getText();
                employeeOffice = row.findElement(By.xpath("./td[3]")).getText();
                employeeAge = Integer.valueOf(row.findElement(By.xpath("./td[4]")).getText());
                employeeSalary = Integer.valueOf(row.findElement(By.xpath("./td[6]")).getText().replaceAll("[^0-9]", ""));

                if (employeeName.length() > 1) {
                    Employee emp = new Employee(employeeName, employeePosition, employeeOffice, employeeAge, employeeSalary);
                    list.add(emp);
                }
            }
            this.clickNextButton(next);
            next = getWebElementById(nextButtonId);
            buttonEnabledState = this.getNextButtonEnabledState(next);
        }
    }

        private boolean getNextButtonEnabledState(WebElement button)
        {
            boolean state = true;
            if (button.getAttribute("class").contains("disabled"))
            {
                state = false;
            }
            else
            {
                state = true;
            }
            return  state;
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
