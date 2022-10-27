package task20;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import task10.TestHelper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class JsonParserTest {

    TestHelper testHelper = new TestHelper();

    double expectedTotal;
    @BeforeClass
    static void setUp() {
        System.out.println("Start to testing of JsonParser class...");
    }

    @AfterClass
    static void tearDown() {
        System.out.println("End to testing of JsonParser class...");
    }

    @Test(groups = {"custom method", "files"})
    void writeToFileTest() {
        Cart fruitCart = new Cart("fruitCart");
        RealItem fruit = new RealItem();
        fruit.setName("Mandarin");
        fruit.setPrice(2.5);
        fruit.setWeight(1.2);
        fruitCart.addRealItem(fruit);
        String path = "src/main/resources/" + fruitCart.getCartName() + ".json";
        Parser parser = new JsonParser();
        parser.writeToFile(fruitCart);
        Cart fruityCart =  testHelper.myReadFromFileTestMethod(new File(path));
        expectedTotal = fruit.getPrice() + fruit.getPrice()*0.2;
        assertEquals(expectedTotal,fruityCart.getTotalPrice());
    }

    @Test(groups = {"custom method", "files"})
    void readFromFileTest() {
        Cart goods = new Cart("nataCart");
        RealItem car = new RealItem();
        car.setName("Reno");
        car.setPrice(25023.5);
        car.setWeight(1230);
        VirtualItem movie = new VirtualItem();
        movie.setName("Comedy");
        movie.setPrice(16);
        movie.setSizeOnDisk(150000);
        goods.addRealItem(car);
        goods.addVirtualItem(movie);
        goods.showItems();
        String path = "src/main/resources/" + goods.getCartName() + ".json";
        testHelper.myWriteCartTestMethod(goods, path);
        Parser parser = new JsonParser();
        Cart nataCart = parser.readFromFile(new File(path.toString()));
        expectedTotal = car.getPrice() + car.getPrice()*0.2 + movie.getPrice() + movie.getPrice()*0.2;
        assertEquals(expectedTotal,nataCart.getTotalPrice());
    }

    @Test(groups = "files")
    void readFromFileExceptionTest() {
        Path path = Paths.get( "src/main/resources/xxxx-cart.json");
        Parser parser = new JsonParser();
        Throwable exception =
          expectThrows(NoSuchFileException.class, () -> {
            parser.readFromFile(new File(path.toString()));
        });
        String expectedMessage = "json not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("The actual exception message: " + actualMessage);
    }

    @DataProvider(name = "Array Symbols")
    public Object[] customDataProvider() throws Exception {
        Object data[] = new Object[]{"#", "$", "@", "*", "&"};

        return data;
    }
    @Test(dataProvider = "Array Symbols", groups = {"files", "data test"})
    void readFromFileWithValueSourceTest(String a) {
        Path path = Paths.get( "src/main/resources/eugen-cart.json");
        Parser parser = new JsonParser();
        Cart eugenCart = parser.readFromFile(new File(path.toString()));
        assertNotNull(a);
        assertFalse(eugenCart.getCartName().contains(a));
        System.out.println("The cart name does not contain symbol: " + a);
    }

    @Test(enabled = false)
    void disabledTest()
    {
        System.out.println("Error! The test was run :(");
    }
}

