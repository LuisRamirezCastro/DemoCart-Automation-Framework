package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage extends basePage {

    // URL https://demo.opencart.com/

    private By homeContainer = By.id("common-home");
    private By searchTexBox = By.xpath("//input[@name='search']");
    private By searchButton = By.xpath("//*[@id='search']/span/button");
    // Search box: <input type="text" name="search" value="" placeholder="Search" class="form-control input-lg">
    // Search button: <button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>

    public homePage(WebDriver driver){
        super(driver);
    }
    public homePage(WebDriver driver, String url){
        super(driver, url);
    }

    public WebElement setHomeContainer() { return driver.findElement(this.homeContainer); }
    public WebElement setSearchTextBox() {
        return driver.findElement(this.searchTexBox);
    }
    public WebElement setSearchButton() {
        return driver.findElement(this.searchButton);
    }

    public void doSearch(String product) {
        this.setSearchTextBox().sendKeys(product);
        this.setSearchButton().click();
    }
}
