package task20;

import org.testng.annotations.*;
import shop.RealItem;
import static org.testng.Assert.*;

public class RealItemTest {
    RealItem gift = new RealItem();

    @BeforeClass
    public void setUp() {
        System.out.println("Start testing of RealItem class");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("End testing of RealItem class");
    }

    @Test(groups = "cart items")
    public void getNameTest() {
        gift.setName("Bouquet");
        final String actualName = gift.getName();
        assertTrue(actualName.startsWith("B"));
        assertTrue(actualName.endsWith("t"));
        assertEquals(actualName.length(), 7);
        System.out.println(gift);
    }
}