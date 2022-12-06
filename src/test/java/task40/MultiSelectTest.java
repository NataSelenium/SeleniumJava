package task40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import task40.helpes.BaseTest;
import task40.helpes.MultiSelectPage;

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
        MultiSelectPage page = new MultiSelectPage(super.driver);
        Select select = page.getSelectWelElement();
        List<Integer> list = page.getUniqueList(selectedOptionsCount);

        for (int index:list)
        {      select.selectByIndex(index);     }

        Assertions.assertTrue(select.getAllSelectedOptions().size() > 0);
    }
}
