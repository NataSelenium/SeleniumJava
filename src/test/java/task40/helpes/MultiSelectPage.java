package task40.helpes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MultiSelectPage {
    private final WebDriver driver;
    private String selectId = "multi-select";

    public MultiSelectPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public Select getSelectWelElement() {
    return new Select(driver.findElement(By.id(selectId)));
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
