package task10;

import org.junit.jupiter.api.*;
import shop.RealItem;
import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    RealItem gift = new RealItem();

    @BeforeAll
    static void setUp() {
        System.out.println("Start testing of RealItem class...");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("End testing of RealItem class...");
    }

    @Test
    void getNameTest()
    {
        gift.setName("Bouquet");
        final String actualName = gift.getName();
        assertAll("gift",
                () -> assertTrue(actualName.startsWith("B")),
                () -> assertTrue(actualName.endsWith("t"))
        );
    }

    @Test
    void getPriceTest()
    {
        gift.setPrice(25.5);
        double actualPrice = gift.getPrice();
        assertTrue(actualPrice < 100, "Actual price is valid");
    }

    @Test
    void getWeightTest() {
        gift.setWeight(4.5);
        double expectedWeight = 4.5;
        double actualWeight = gift.getWeight();
        assertEquals(expectedWeight,actualWeight);
    }
}