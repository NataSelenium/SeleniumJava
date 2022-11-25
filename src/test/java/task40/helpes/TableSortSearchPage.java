package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableSortSearchPage {
    private final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    WebDriver driver;

    public TableSortSearchPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get(URL);
        this.driver.manage().window().fullscreen();
    }

    public Select getWebElementByName(String name)
    {
        return  new Select(driver.findElement(By.name(name)));
    }
    public WebElement getWebElementById(String id)
    {
        return driver.findElement(By.id(id));
    }

    public void collectTableDataList(String tableCssSelector, List<Employee> list)
    {
        WebElement table = driver.findElement(By.cssSelector(tableCssSelector));
        List<WebElement> rows =
                table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            String employeeName = "";     String employeePosition = "";   String employeeOffice = "";    int employeeAge = 0;     int employeeSalary = 0;
            for (WebElement col : cols)
            {
                if (cols.indexOf(col)==0)
                {
                    employeeName = col.getText();
                }
                else  if (cols.indexOf(col)==1)
                {employeePosition = col.getText();}
                else  if (cols.indexOf(col)==2)
                {employeeOffice = col.getText();}
                else if (cols.indexOf(col)==3)
                {
                    employeeAge = Integer.valueOf(col.getText());
                }
                else if (cols.indexOf(col)==5){
                    employeeSalary = Integer.valueOf(col.getText().replaceAll("[^0-9]",""));
                }

            }
            if (employeeName.length()>1)
            {
                Employee emp = new Employee(employeeName, employeePosition, employeeOffice, employeeAge, employeeSalary);
                list.add(emp);
            }
        }
    }

    public void clickNextButton(WebElement nextButton, List<Employee> list)
    {
        boolean buttonState = true;

        while (buttonState)
        {
            nextButton = this.getWebElementById("example_next");
            nextButton.click();
            this.collectTableDataList("table#example", list);
            nextButton = this.getWebElementById("example_next");
            if (nextButton.getAttribute("class").contains("disabled"))
            {
                buttonState = false;
            }
        }
    }

    public void printCustomDataTableList(List<Employee> empList, int ageOption, int salaryOption)
    {
        for (Employee emp: empList)
        {
            if (emp.getAge() > ageOption && emp.getSalary() < salaryOption)
            {
                System.out.println(
                        emp.getName() + ", "
                        + emp.getPosition() + ", "
                        + emp.getOffice()
                );
            }
        }
    }
}
