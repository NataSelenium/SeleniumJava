package task40.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import task40.page.MultiSelectPage;

import java.util.List;

import static task40.util.TestConstants.*;

public class MultiSelectTest extends BaseTest {
    private final Integer selectedOptionsCount = 3;
    private List<WebElement> actualList;

    public MultiSelectTest() {
        super(MULTI_SELECT_PAGE_URL);
    }

    @Test
    void multiSelectTest() {
        MultiSelectPage page = new MultiSelectPage(super.driver);
        actualList = page.selectMultipleSelectOptions(selectedOptionsCount);
        Assertions.assertTrue(page.getSelectedOptionsList().containsAll(actualList));
    }
}