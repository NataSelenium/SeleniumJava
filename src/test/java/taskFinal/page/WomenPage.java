package taskFinal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taskFinal.util.Product;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WomenPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Tops']")
    WebElement topsLink;

    @FindBy(css = "ol.products")
    WebElement productItems;

    @FindBy(xpath="//a[text()='shopping cart']")
    WebElement viewShoppingCartLink;

    @FindBy(xpath = "//a[text()='shopping cart']/..")
    WebElement addedProductLabel;

    @FindBy(css = "span.counter-number")
    WebElement counterNumberLabel;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTopsCatalog()
    {
        topsLink.click();
    }

    public List<Product> addProductItems()
    {
        driver.manage().window().fullscreen();
        Actions actions = new Actions(driver);
        List<Integer> items = getUniqueList(3);
        List<Product> collectedProducts = new ArrayList<>();
        for (Integer i: items) {
            String product = "li:nth-child(" + i + ")";
            WebElement productItem = productItems.findElement(By.cssSelector(product));
            actions.moveToElement(productItem).perform();
            String productName = productItem.findElement(By.cssSelector("a.product-item-link")).getText();
            productItem.findElement(By.cssSelector("div[option-label='M']")).click();
            WebElement productColor = productItem.findElement(By.cssSelector("div.swatch-option.color[index='1']"));
            productColor.click();
            WebElement productPrice = productItem.findElement((By.cssSelector("span.price")));
            Double price = Double.valueOf(productPrice.getText().replace("$", ""));
            productItem.findElement(By.cssSelector("button[title='Add to Cart']")).click();
            collectedProducts.add(new Product(productName, "M", productColor.getAttribute("option-label"), price));
            //System.out.println(productName);
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(viewShoppingCartLink));
            new WebDriverWait(driver, Duration.ofSeconds(12)).until(ExpectedConditions.textToBePresentInElement(addedProductLabel, productName));
        }
        //for (Product p: collectedProducts)        {            System.out.println(p.getName() + " " + p.getSize() + ", " + p.getColor() + ", " + p.getPrice());        }
        return collectedProducts;
    }

    public WishListPage addToWishList()
    {
        driver.manage().window().fullscreen();
        Actions actions = new Actions(driver);
        int randomInteger = 1+ (int)(Math.random()*12);
        String randomProduct = "li:nth-child(" + randomInteger + ")";
        WebElement wishProductItem = productItems.findElement(By.cssSelector(randomProduct));
        actions.moveToElement(wishProductItem).perform();
        String wishProductName = wishProductItem.findElement(By.cssSelector("a.product-item-link")).getText();
        wishProductItem.findElement(By.cssSelector("a[title='Add to Wish List']")).click();
        return new WishListPage(driver,wishProductName);
    }

    public ShoppingCartPage openShoppingCart()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(counterNumberLabel));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(viewShoppingCartLink));
        viewShoppingCartLink.click();
        return new ShoppingCartPage(driver);
    }

    public List<Integer> getUniqueList(int size)
    {
        List<Integer> uniqueList = new ArrayList<Integer>();
        while (uniqueList.size() !=size)
        {
            int randomInteger = 1+ (int)(Math.random()*12);
            if (!uniqueList.contains(randomInteger))
            {
                uniqueList.add(randomInteger);
            }
        }
        return  uniqueList;
    }
}
