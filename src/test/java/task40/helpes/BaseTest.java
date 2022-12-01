package task40.helpes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected WebDriver driver;
    private String url;

    public BaseTest(String url) {
        this.url = url;
    }

    @BeforeEach
    protected void setUp() {
        driver = new ChromeDriver();
        driver.get(this.url);
        driver.manage().window().fullscreen();
    }

    @AfterEach
    protected void cleanUp() {
        driver.quit();
    }

    protected List<Integer> getUniqueList(int size)
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
