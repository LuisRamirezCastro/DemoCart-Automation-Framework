package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkoutCartPage extends basePage{

    // URL https://demo.opencart.com/index.php?route=checkout/cart
    // ID checkout-cart
    public checkoutCartPage(WebDriver driver){
        super(driver);
    }
    public checkoutCartPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=checkout/cart");
    }

    private By checkoutCartContainer = By.id("checkout-cart");
    private By checkoutButton = By.linkText("Checkout");;
    // Red Alert
    /*
    <div class="alert alert-danger alert-dismissible">
        <i class="fa fa-exclamation-circle"></i> Products marked with *** are not available in the desired quantity or not in stock!
        <button type="button" class="close" data-dismiss="alert">×</button>
    </div>
     */
    private By unableToCheckout = By.className("alert-danger");

    public WebElement setCheckoutCartContainer() {
        return driver.findElement(this.checkoutCartContainer);
    }
    public WebElement setunableToCheckout() {
        return driver.findElement(this.unableToCheckout);
    }

    public void checkout(){
        driver.findElement(checkoutButton).click();
    }

}
