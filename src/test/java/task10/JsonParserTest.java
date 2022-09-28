package task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    Cart fruitCart = new Cart("fruit-cart");
    RealItem fruit = new RealItem();
    @BeforeAll
    static void setUp() {
        System.out.println("Start to testing of JsonParser class...");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("End to testing of JsonParser class...");
    }

    @ParameterizedTest
    @CsvSource({
            "apple,         1.5,     1",
            "banana,        2.1,     1.5",
            "lemon,         3,       0.8",
            "strawberry,    10.5,    1.2",
            "orange,        2.5,     2.3"
    })
    void writeToFileWithCsvSourceTest(String fruitName, double price, double weight) {
        fruit.setName(fruitName);
        fruit.setPrice(price);
        fruit.setWeight(weight);
        assertAll("fruit",
                () -> assertNotNull(fruit.getName()),
                () -> assertNotNull(fruit.getPrice()),
                () -> assertNotNull(fruit.getWeight())
        );
        fruitCart.addRealItem(fruit);
        System.out.println("total is: " + fruitCart.getTotalPrice());
        Parser parser = new JsonParser();
    if (fruit.getName() == "strawberry") {
    parser.writeToFile(fruitCart);
    System.out.println("Fruit cart with strawberry is ready!");
        }
    }


    @Test
    void readFromFileTest() {
        Path path = Paths.get( "src/main/resources/eugen-cart.json");
        assertTrue(Files.exists(path), "File exists");
        Parser parser = new JsonParser();
        Cart eugenCart = parser.readFromFile(new File(path.toString()));
        assertTrue(eugenCart.getTotalPrice() < 26700, "Total price is not greater 26700");
    }

    @ParameterizedTest
    @ValueSource(strings = { "e", "g", "-", "a", "t" })
    void readFromFileWithValueSourceTest(String argument) {
        Path path = Paths.get( "src/main/resources/eugen-cart.json");
        Parser parser = new JsonParser();
        Cart eugenCart = parser.readFromFile(new File(path.toString()));
        assertNotNull(argument);
        assertTrue(eugenCart.getCartName().contains(argument));
        System.out.println("The cart name contain letter: " + argument);
    }

    @Disabled("This test will not be run")
    @Test
    void disabledTest()
    {
        System.out.println("Error! The test was run :(");
    }
}