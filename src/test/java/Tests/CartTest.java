package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.productSearch;
import PageObjects.productDetails;
import PageObjects.checkoutCartPage;

import DataProviders.productsDataProvider;
import pojo.productData;

import utilities.waits;


public class CartTest extends baseTest{

    // Constructor
    CartTest(){
        super("chrome");
    }

    @Test(enabled=true, groups = {"sanity"}, dataProvider = "getProductsFromJson", dataProviderClass = productsDataProvider.class, description = "Test Case #2 - Add product to cart using search. Assert product can not be purchased.")
    //@Description("User is allowed to do login and go to account dashboard")
    public void doPriceVerification(productData _productData) throws InterruptedException {
        System.out.println("Test Case #2 - Add product to cart using search. Assert product can not be purchased.");

        // Page Objects
        homePage home = new homePage(driver, getBaseURL());
        productSearch search = new productSearch(driver);
        productDetails details = new productDetails(driver);
        checkoutCartPage checkoutCart = new checkoutCartPage(driver, getBaseURL());

        // Utilities
        waits wait = new waits(driver);

        System.out.println("Cart Verification Test for: ");
        System.out.println("\nProduct: " + _productData.getName());

        // Navigates to 'Home Page' and search for the given product
        home.goToPage();
        home.doSearch(_productData.getName());
        // Waits for Search Page to load
        wait.untilElementExists(search.setProductSearchContainer());
//Thread.sleep(3000);
        // Clicks searched product
        search.searchedProduct(_productData.getName()).click();
        wait.untilElementExists(details.setProductDetailsContainer());
        System.out.println("Opened product's details.");
        wait.explicitWait(1500);
        // Adds the product to the Cart
        details.addToCart();
        wait.explicitWait(1500);
        wait.untilElementExists(details.setAddToCartSuccess());
        // Confirms the green banner was displayed. Product was added to Cart
        Assert.assertEquals(details.setAddToCartSuccess().isDisplayed(), true);
        System.out.println("Product added to cart.");

        // Navigates to Checkout Cart to confirm the red banner is displayed
        checkoutCart.goToPage();
        wait.untilElementExists(checkoutCart.setCheckoutCartContainer());
        // Confirms the red banner was displayed. Product can not be purchased.
        checkoutCart.checkout();
        wait.untilElementExists(checkoutCart.setunableToCheckout());
        Assert.assertEquals(checkoutCart.setunableToCheckout().isDisplayed(), true);
        System.out.println("Product can not be purchased.");
    }
}
