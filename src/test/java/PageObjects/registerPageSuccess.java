package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPageSuccess extends basePage{

    // URL https://demo.opencart.com/index.php?route=account/success
    // ID "common-success"
    // Your Account Has Been Created!

    private By accountSuccess = By.id("common-success");

    public registerPageSuccess(WebDriver driver){
        super(driver);
    }

    public WebElement setAccountSuccess() {
        return driver.findElement(this.accountSuccess);
    }
}