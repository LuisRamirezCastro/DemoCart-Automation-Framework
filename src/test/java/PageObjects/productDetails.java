package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productDetails extends basePage{

    public productDetails(WebDriver driver){
        super(driver);
    }

    // URL https://demo.opencart.com/index.php?route=product/product&product_id=43&search=Macbook
    // ID product-product

    private By productDetailsContainer = By.id("product-product");

    private By productPrice = By.xpath("//div[@class='col-sm-4']//ul[2]/li/h2");

    // Added to Cart
    private By addToCartButton = By.id("button-cart");
    /*
    <div class="alert alert-success alert-dismissible">
        Success: You have added
        <a href="https://demo.opencart.com/index.php?route=product/product&amp;product_id=43">
        MacBook</a> to your <a href="https://demo.opencart.com/index.php?route=checkout/cart">
        shopping cart</a>!<button type="button" class="close" data-dismiss="alert">×</button>
     </div>
     */
    private By addToCartSuccess = By.className("alert-success");

    // <button class="currency-select btn btn-link btn-block" type="button" name="USD">$ US Dollar</button>
    // Euro switch: <button class="currency-select btn btn-link btn-block" type="button" name="EUR">€ Euro</button>
    // Pounds switch: <button class="currency-select btn btn-link btn-block" type="button" name="GBP">£ Pound Sterling</button>
    private By currencyEnabler = By.className("btn-group");
    private By dollarsButton = By.name("USD");
    private By eurosButton = By.name("EUR");
    private By poundsButton = By.name("GBP");


    public WebElement setProductDetailsContainer() {
        return driver.findElement(this.productDetailsContainer);
    }
    public WebElement setAddToCartSuccess() {
        return driver.findElement(this.addToCartSuccess);
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void setDollarAsCurrency() {
        driver.findElement(this.currencyEnabler).click();
        driver.findElement(this.dollarsButton).click();
    }
    public void setEurosAsCurrency() {
        driver.findElement(this.currencyEnabler).click();
        driver.findElement(this.eurosButton).click();
    }
    public void setPoundsAsCurrency() {
        driver.findElement(this.currencyEnabler).click();
        driver.findElement(this.poundsButton).click();
    }

    public WebElement setProductPrice() {
        return driver.findElement(this.productPrice);
    }

    // Add to Cart: ID button-cart

    // Prices

    // Dollars: <h2>$602.00</h2>
    //*[@id="content"]/div/div[2]/ul[2]/li[1]/h2
    // Euro: <h2>518.16€</h2>
    // Pounds: <h2>£454.10</h2>
}
