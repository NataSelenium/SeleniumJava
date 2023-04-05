package taskFinal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class WishListPage {

    private WebDriver driver;

    private String productName;

    @FindBy(css = "ol.product-items")
    WebElement productItems;

    public WishListPage(WebDriver driver, String name) {
        this.driver = driver;
        this.productName = name;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductInWishList()
    {
        List<WebElement> list = productItems.findElements(By.cssSelector("a.product-item-link"));
        List<String> productList = new ArrayList<>();
        for (WebElement item: list)
        {
            productList.add(item.getText());
        }
        return productList.contains(productName);
    }
}
