package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SeleniumEasyMultiSelectPage {
    private final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private final WebDriver driver;

    public SeleniumEasyMultiSelectPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get(URL);
    }
    public Select getMultiSelectWebElement(String Id)
    {
        return  new Select(driver.findElement(By.id(Id)));
    }
    public List<Integer> getUniqueList(int size)
    {
        List<Integer> uniqueList = new ArrayList<Integer>();
        while (uniqueList.size() !=size)
        {
            int randomInteger = (int)(Math.random()*8);
            if (!uniqueList.contains(randomInteger))
            {
                uniqueList.add(randomInteger);
            }
        }
        return  uniqueList;
    }
}
