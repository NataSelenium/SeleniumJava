package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TableSortSearchPage {
    private final WebDriver driver;
    private final String nextButtonId = "example_next";
    private final String selectName = "example_length";
    private final String tableCssSelector = "table#example tbody";
    private final String selectOption = "10";

    public TableSortSearchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectDropDownOption()
    {
        Select select =  new Select(driver.findElement(By.name(selectName)));
        select.selectByValue(selectOption);
    }

    public WebElement getWebElementById(String id)
    {
        return driver.findElement(By.id(id));
    }

    public void collectTableDataList(List<Employee> list)
    {
        WebElement next = getWebElementById(nextButtonId);
        boolean buttonEnabledState = true;
        while (buttonEnabledState) {
            WebElement table = driver.findElement(By.cssSelector(tableCssSelector));
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
