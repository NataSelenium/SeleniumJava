package task40;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import task40.helpes.SeleniumEasyMultiSelectPage;

import java.util.List;

public class MultiSelectTest {
    private WebDriver driver;
    private final Integer selectedOptionsCount = 3;

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
    }
    @Test
    void multiSelectTest()
    {
        SeleniumEasyMultiSelectPage page = new SeleniumEasyMultiSelectPage(driver);
        Select select = page.getMultiSelectWebElement("multi-select");
        List<Integer> list = page.getUniqueList(selectedOptionsCount);

        for (int index:list)
        {
            select.selectByIndex(index);
        }

        Assertions.assertTrue(select.getAllSelectedOptions().size() > 0);
    }
    @AfterEach
    void cleanUp()
    {
        driver.quit();
    }
}
