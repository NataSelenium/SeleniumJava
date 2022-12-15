package task40.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MultiSelectPage {
        private final WebDriver driver;
        private By selectBy = By.id("multi-select");
        private Select mySelect;

        public MultiSelectPage(WebDriver driver)
    {
        this.driver = driver;
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

        public List<WebElement> selectMultipleSelectOptions(int count)
        {
            mySelect = new Select(driver.findElement(selectBy));
            List<Integer> list = getUniqueList(count);
            List<WebElement> optionsList = new ArrayList<>();
            for (int index : list) {
                mySelect.selectByIndex(index);
                optionsList.add(mySelect.getOptions().get(index));
            }
            return optionsList;
        }

        public List<WebElement> getSelectedOptionsList()
        {
            mySelect = new Select(driver.findElement(selectBy));
            return  mySelect.getAllSelectedOptions();
        }
}
