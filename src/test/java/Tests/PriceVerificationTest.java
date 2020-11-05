package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.homePage;
import PageObjects.productSearch;
import PageObjects.productDetails;

import DataProviders.productsPriceDataProvider;
import pojo.productPriceData;

import utilities.waits;

public class PriceVerificationTest extends baseTest{

    // Constructor
    PriceVerificationTest(){
        super("chrome");
    }

    @Test(groups = {"sanity"}, dataProvider = "getProductsPriceFromJson", dataProviderClass = productsPriceDataProvider.class, description = "Test Case #3 - Verify the price of a product in all 3 currencies.")
    public void doPriceVerification(productPriceData _productPriceData) throws InterruptedException {
        System.out.println("Test Case #3 - Verify the price of a product in all 3 currencies.");
        System.out.println("\nPrice Verification Test for: ");
        System.out.println("Product: " + _productPriceData.getName());
        System.out.println("With prices: ");
        System.out.println("\tUS DOllars: " + _productPriceData.getDollars());
        System.out.println("\tEuros: " + _productPriceData.getEuros());
        System.out.println("\tPounds: " + _productPriceData.getPounds());

        // Page Objects
        homePage home = new homePage(driver, getBaseURL());
        productSearch search = new productSearch(driver);
        productDetails details = new productDetails(driver);

        // Utilities
        waits wait = new waits(driver);

        // Navigates to 'Home Page' and search for the given product
        home.goToPage();
        home.doSearch(_productPriceData.getName());
        // Waits for Search Page to load
        wait.untilElementExists(search.setProductSearchContainer());
        // Clicks searched product
        search.searchedProduct(_productPriceData.getName()).click();
        wait.untilElementExists(details.setProductDetailsContainer());

        // Sets Dollars as currency
        details.setDollarAsCurrency();
        wait.explicitWait(1500);
        // Validates dollars amount on JSON matches product on details page
        Assert.assertEquals("$"+ _productPriceData.getDollars(), details.setProductPrice().getText());
        System.out.println("Validating Dollars:");
        System.out.println("\tProduct: $"+_productPriceData.getDollars());
        System.out.println("\tPage: "+details.setProductPrice().getText());

        // Sets Euros as currency
        details.setEurosAsCurrency();
        wait.explicitWait(1500);
        // Validates euros amount on JSON matches product on details page
        Assert.assertEquals(_productPriceData.getEuros()+"€", details.setProductPrice().getText());
        System.out.println("Validating Euros:");
        System.out.println("\tProduct: "+_productPriceData.getEuros()+"€");
        System.out.println("\tPage: "+details.setProductPrice().getText());

        // Sets Pounds as currency
        details.setPoundsAsCurrency();
        wait.explicitWait(1500);
        // Validates pounds amount on JSON matches product on details page
        Assert.assertEquals("£"+_productPriceData.getPounds(), details.setProductPrice().getText());
        System.out.println("Validating Pounds:");
        System.out.println("\tProduct: £"+_productPriceData.getPounds());
        System.out.println("\tPage: "+details.setProductPrice().getText());
    }
}