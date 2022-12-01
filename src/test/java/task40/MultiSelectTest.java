package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import task40.helpes.BaseTest;

import java.util.List;

import static task40.helpes.TestConstants.*;

public class MultiSelectTest extends BaseTest {
    private final Integer selectedOptionsCount = 3;

    public MultiSelectTest() {
        super(MULTI_SELECT_PAGE_URL);
    }

    @Test
    void multiSelectTest()
    {
        Select select = new Select(driver.findElement(By.id("multi-select")));
        List<Integer> list = getUniqueList(selectedOptionsCount);

        for (int index:list)
        {      select.selectByIndex(index);     }

        Assertions.assertTrue(select.getAllSelectedOptions().size() > 0);
    }
}
