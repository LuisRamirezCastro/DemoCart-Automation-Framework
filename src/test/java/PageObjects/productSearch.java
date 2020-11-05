package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productSearch extends basePage{
    // URL https://demo.opencart.com/index.php?route=product/search&search=Macbook
    // ID

    private By productSearchContainer = By.id("product-search");

    public productSearch(WebDriver driver){
        super(driver);
    }

    public WebElement setProductSearchContainer() {
        return driver.findElement(this.productSearchContainer);
    }

    public WebElement searchedProduct(String product){
        return driver.findElement(By.linkText(product));
        //return driver.findElement(By.xpath("//a[@text()='"+product+"']"));
    }
    // Link
    // <a href="https://demo.opencart.com/index.php?route=product/product&amp;product_id=43&amp;search=Macbook">MacBook</a>

    //*[@id="content"]/div[3]/div[1]/div/div[1]/a
}
//*[@id="content"]/div[3]/div[1]/div/div[2]/div[1]/h4/a


