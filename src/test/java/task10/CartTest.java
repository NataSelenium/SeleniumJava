package task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart nataCart = new Cart("nata-cart");
    RealItem toy = new RealItem();
    VirtualItem ticket = new VirtualItem();
    VirtualItem game = new VirtualItem();


    @BeforeAll
    static void setUp() {
        System.out.println("Start testing of Cart class...");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("End testing of Cart class...");
    }

    @Test
    @Order(1)
    void cartRealItemTest() {
        toy.setName("Teddy Bear");
        toy.setPrice(17.5);
        toy.setWeight(0.8);
        nataCart.addRealItem(toy);
        assertNotNull(toy);
        assertEquals("Teddy Bear", toy.getName());
        assertTrue(toy.getWeight() < 1);
        assertTrue(toy.getName().length() < 16);
        nataCart.showItems();
    }

    @Test
    @Order(2)
    void cartVirtualItemTest() {
        ticket.setName("Jazz Concert");
        ticket.setPrice(35.8);
        ticket.setSizeOnDisk(120);
        game.setName("Need for Speed");
        game.setPrice(18.9);
        game.setSizeOnDisk(1550.8);
        nataCart.addVirtualItem(ticket);
        nataCart.addVirtualItem(game);
        assertNotNull(ticket);
        assertAll("gift",
                () -> assertTrue(ticket.getName().startsWith("J")),
                () -> assertTrue(game.getName().endsWith("d"))
        );
        assertTrue(nataCart.getTotalPrice() < 100);
        nataCart.showItems();
    }
}