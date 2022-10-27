package task20;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.VirtualItem;

import static org.testng.Assert.*;

public class VirtualItemTest {

    VirtualItem game = new VirtualItem();

    @BeforeMethod
    public void setUp() {
        System.out.println("Start testing of VirtualItem class...");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("End testing of VirtualItem class...");
    }

    @Test(groups = "cart items")
    public void getVirtualItemPropertiesTest() {
        game.setName("Need for Speed");
        game.setPrice(18.9);
        game.setSizeOnDisk(1550.8);
        String actualName = game.getName();
        double actualPrice = game.getPrice();
        double actualSizeOnDisk = game.getSizeOnDisk();
        assertTrue(actualName.contains("Speed"));
        assertEquals(18.9, actualPrice);
        assertNotNull(actualSizeOnDisk);
        System.out.println(game);
    }
    @Parameters({"game-name", "game-price", "game-size"})
    @Test(groups = {"cart parameters", "cart items"})
    public void getVirtualItemPropertiesWithParametersTest(String gameName, double gamePrice, double gameSize)
    {
        game.setName("Tetris");
        game.setPrice(15.7);
        game.setSizeOnDisk(260.0);
        String actualName = game.getName();
        double actualPrice = game.getPrice();
        double actualSizeOnDisk = game.getSizeOnDisk();
        assertEquals(gameName,actualName);
        assertEquals(gamePrice, actualPrice);
        assertEquals(gameSize, actualSizeOnDisk);
        System.out.println(game);
    }
}