package task10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    VirtualItem game = new VirtualItem();

    @BeforeEach
    void setUp() {
        System.out.println("Start testing of VirtualItem class...");
    }

    @AfterEach
    void tearDown() {
        System.out.println(game);
        System.out.println("End testing of VirtualItem class...");
    }

    @Test
    void getVirtualItemPropertiesTest() {
        game.setName("Need for Speed");
        game.setPrice(18.9);
        game.setSizeOnDisk(1550.8);
        String actualName = game.getName();
        double actualPrice = game.getPrice();
        double actualSizeOnDisk = game.getSizeOnDisk();
        assertTrue(actualName.contains("Speed"));
        assertEquals(18.9, actualPrice);
        assertNotNull(actualSizeOnDisk);
    }
}