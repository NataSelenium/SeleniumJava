package task10;

import org.junit.jupiter.api.*;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart nataCart = new Cart("nata-cart");
    RealItem toy = new RealItem();
    VirtualItem ticket = new VirtualItem();
    VirtualItem game = new VirtualItem();
    double expectedTotal;


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
    void cartAddRealItemTest() {
        toy.setName("Teddy Bear");
        toy.setPrice(17.5);
        toy.setWeight(0.8);
        nataCart.addRealItem(toy);
        expectedTotal = toy.getPrice() + toy.getPrice()*0.2;
        assertEquals(nataCart.getTotalPrice(), expectedTotal);
        nataCart.showItems();
        nataCart.addRealItem(toy);
        expectedTotal = expectedTotal*2;
        assertEquals(nataCart.getTotalPrice(), expectedTotal);
        nataCart.showItems();
    }

    @Test
    @Order(2)
    void cartAddVirtualItemTest() {
        ticket.setName("Jazz Concert");
        ticket.setPrice(35);
        ticket.setSizeOnDisk(120);
        game.setName("Need for Speed");
        game.setPrice(18);
        game.setSizeOnDisk(1550.8);
        nataCart.addVirtualItem(ticket);
        expectedTotal = ticket.getPrice() + ticket.getPrice()*0.2;
        assertEquals(expectedTotal, nataCart.getTotalPrice());
        nataCart.addVirtualItem(game);
        expectedTotal = expectedTotal + game.getPrice() + game.getPrice()*0.2;
        assertEquals(expectedTotal, nataCart.getTotalPrice());
        nataCart.showItems();
    }
    //This test will fail, because deleteRealItem method ignores recalculation of cart total amount
    @Test
    @Order(3)
    void cartDeleteRealItemTest() {
        toy.setName("Kangaroo");
        toy.setPrice(16);
        toy.setWeight(0.5);
        nataCart.addRealItem(toy);
        nataCart.addRealItem(toy);
        expectedTotal = (toy.getPrice() + toy.getPrice()*0.2)*2;
        assertEquals(nataCart.getTotalPrice(), expectedTotal);
        nataCart.showItems();
        nataCart.deleteRealItem(toy);
        expectedTotal = expectedTotal - (toy.getPrice() + toy.getPrice()*0.2);
        assertEquals(nataCart.getTotalPrice(), expectedTotal);
    }
    //This test will fail, because deleteVirtualItem method ignores recalculation of cart total amount
    @Test
    @Order(4)
    void cartDeleteVirtualItemTest() {
        ticket.setName("Jazz Concert");
        ticket.setPrice(35);
        ticket.setSizeOnDisk(120);
        game.setName("Need for Speed");
        game.setPrice(18);
        game.setSizeOnDisk(1550.8);
        nataCart.addVirtualItem(ticket);
        expectedTotal = ticket.getPrice() + ticket.getPrice()*0.2;
        assertEquals(expectedTotal, nataCart.getTotalPrice());
        nataCart.addVirtualItem(game);
        expectedTotal = expectedTotal + game.getPrice() + game.getPrice()*0.2;
        assertEquals(expectedTotal, nataCart.getTotalPrice());
        nataCart.showItems();
        nataCart.deleteVirtualItem(game);
        expectedTotal = expectedTotal - (game.getPrice() + game.getPrice()*0.2);
        assertEquals(expectedTotal, nataCart.getTotalPrice());
    }
}