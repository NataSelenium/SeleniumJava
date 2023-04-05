package taskFinal.test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import taskFinal.page.*;
import taskFinal.util.Product;


import java.util.List;

import static taskFinal.util.TestConfig.*;

public class MagentoStoreTest extends TestBase{

    public MagentoStoreTest() {super(HOME_MAGENTO_URL);}

    @Test
    @Order(1)
    @Tag("login")
    @DisplayName("Test AP-1")
    @Description("Verify the ability to create an account")
    void createAccountLumaStoreTest() {
        HomePage homePage = new HomePage(super.driver);
        CreateAccountPage createAccountPage = homePage.getCreateAccountPage();
        AccountPage accountPage = createAccountPage.addNewAccount();
        Assertions.assertTrue(accountPage.isAccountPageDisplayed());
    }

    @Test
    @Order(2)
    @Tag("login")
    @DisplayName("Test AP-2")
    @Description("Verify the ability to login in account")
    void loginLumaStoreTest() {
        HomePage homePage = new HomePage(super.driver);
        LoginPage logPage = homePage.getLoginPage();
        logPage.login(LOG_NAME, PASSWORD);
        Assertions.assertTrue(homePage.isHomePagePresent());
    }

    @Test
    @Order(3)
    @Tag("login")
    @DisplayName("Test AP-3")
    @Description("Verify the ability to add address")
    void addNewAddressToAccountTest() {
        HomePage homePage = new HomePage(super.driver);
        LoginPage logPage = homePage.getLoginPage();
        logPage.login(LOG_NAME, PASSWORD);
        AccountPage accountPage = homePage.getAccountPage();
        AddressBookPage addressBookPage = accountPage.getAddressBookPage();
        addressBookPage.addNewAddress();
        Assertions.assertTrue(addressBookPage.isNewAddressAdded());
    }

    @Test
    @Order(4)
    @Tag("login")
    @DisplayName("Test AP-4")
    @Description("Verify the ability to add to Wishlist")
    void addProductToWishlistTest() {
        HomePage homePage = new HomePage(super.driver);
        LoginPage logPage = homePage.getLoginPage();
        logPage.login(LOG_NAME, PASSWORD);
        WomenPage womenPage = homePage.getWomenPage();
        womenPage.getTopsCatalog();
        WishListPage wishListPage = womenPage.addToWishList();
        Assertions.assertTrue(wishListPage.verifyProductInWishList());
    }

    @Test
    @Order(5)
    @Tag("login")
    @DisplayName("Test AP-5")
    @Description("Verify the ability to add to cart")
    void addProductToCartTest() {
        HomePage homePage = new HomePage(super.driver);
        //LoginPage logPage = homePage.getLoginPage();
        //logPage.login(LOG_NAME, PASSWORD);
        WomenPage womenPage = homePage.getWomenPage();
        womenPage.getTopsCatalog();
        List<Product> expectedAddedItems = womenPage.addProductItems();
        ShoppingCartPage shoppingCartPage = womenPage.openShoppingCart();
        List<Product> actualShoppingList = shoppingCartPage.getShoppingCartItems();
        Assertions.assertEquals(expectedAddedItems,actualShoppingList);
        Assertions.assertEquals(shoppingCartPage.getShoppingCartTotal(), shoppingCartPage.getOrderTotal());
    }
}
