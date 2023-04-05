package taskFinal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taskFinal.util.Product;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {

    private WebDriver driver;

    @FindBy(css = "table#shopping-cart-table")
    WebElement productTable;

    @FindBy(css = "table.data.table.totals strong span.price")
    WebElement orderTotal;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Product> getShoppingCartItems()
    {
        List<Product> shoppingCartProducts = new ArrayList<>(3);
        List<WebElement> prodItems = productTable.findElements(By.cssSelector("tbody.cart.item"));
            for (WebElement item: prodItems) {
                WebElement prodName = item.findElement(By.cssSelector("td.col.item strong a"));
                WebElement prodSize = item.findElement(By.cssSelector("td.col.item dl > dd:nth-child(2)"));
                WebElement prodColor = item.findElement(By.cssSelector("td.col.item dl > dd:nth-child(4)"));
                WebElement prodPrice = item.findElement(By.cssSelector("td.col.price span.price"));
                Double price = Double.valueOf(prodPrice.getText().replace("$", ""));
                shoppingCartProducts.add(new Product(prodName.getText(), prodSize.getText(), prodColor.getText(), price));
                }
        return shoppingCartProducts;
    }

    public double getShoppingCartTotal()
    {
        double total = 0.00;
        List<WebElement> prodItems = productTable.findElements(By.cssSelector("tbody.cart.item"));
        for (WebElement item: prodItems) {
            WebElement prodPrice = item.findElement(By.cssSelector("td.col.price span.price"));
            Double price = Double.valueOf(prodPrice.getText().replace("$", ""));
        total=total+price;
        }
        return total;
    }

    public double getOrderTotal()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderTotal));
        return Double.valueOf(orderTotal.getText().replace("$", ""));
    }
}
