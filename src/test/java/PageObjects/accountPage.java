package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class accountPage extends basePage{

    private By accountContainer = By.id("account-account");

    // URL: https://demo.opencart.com/index.php?route=account/account
    public accountPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=account/account");
    }

    public accountPage(WebDriver driver){
        super(driver);
    }

    public WebElement setAccountContainer() {
        return driver.findElement(this.accountContainer);
    }
}
