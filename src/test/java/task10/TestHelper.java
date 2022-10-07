package task10;

import com.google.gson.Gson;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.*;

public class TestHelper{

    private final Gson gsonTest;

    public TestHelper() {
        gsonTest = new Gson();
    }

    public void myWriteCartTestMethod(Cart cart, String path)
    {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(gsonTest.toJson(cart));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cart myReadFromFileTestMethod(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return gsonTest.fromJson(reader.readLine(), Cart.class);
        } catch (FileNotFoundException ex) {
            throw new NoSuchFileException(String.format("File %s.json not found!", file), ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
