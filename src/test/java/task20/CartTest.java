package task20;

import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import org.testng.annotations.Test;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class CartTest {

    Cart nataCart;
    RealItem toy;
    VirtualItem ticket;
    VirtualItem game;
    double expectedTotal;


    @BeforeClass
    static void setUp() {
        System.out.println("Start testing of Cart class...");
    }

    @AfterClass
    static void tearDown() {
        System.out.println("End testing of Cart class...");
    }

    @Test(groups = "total price")
    void cartAddRealItemTest() {
        nataCart = new Cart("nata-cart");
        toy = new RealItem();
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

    @Test(groups = "total price")
    void cartAddVirtualItemTest() {
        nataCart = new Cart("virtual-cart");
        ticket = new VirtualItem();
        ticket.setName("Jazz Concert");
        ticket.setPrice(35);
        ticket.setSizeOnDisk(120);
        game = new VirtualItem();
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
    @Test(groups = {"broken", "total price"})
    void cartDeleteRealItemTest() {
        nataCart = new Cart("toy-cart");
        toy = new RealItem();
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
    @Test(groups = {"broken", "total price"})
    void cartDeleteVirtualItemTest() {
        nataCart = new Cart("ticket-cart");
        ticket = new VirtualItem();
        ticket.setName("Jazz Concert");
        ticket.setPrice(35);
        ticket.setSizeOnDisk(120);
        game = new VirtualItem();
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
        assertEquals(nataCart.getTotalPrice(), expectedTotal);
    }
}
