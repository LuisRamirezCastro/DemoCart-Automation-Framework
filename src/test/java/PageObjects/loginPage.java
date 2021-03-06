package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPage extends basePage{

    // Login Page Locators
    private By emailTextBox = By.id("input-email");
    private By passwordTextBox = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");

    // Constructors
    public loginPage(WebDriver driver) {
        super(driver);
    }
    public loginPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=account/login");
    }

    // Methods
    public WebElement setEmailTextBox() {
        return driver.findElement(this.emailTextBox);
    }

    public WebElement setPasswordTextBox() {
        return driver.findElement(this.passwordTextBox);
    }

    public WebElement setLoginButton() {
        return driver.findElement(this.loginButton);
    }

    public void doLogin(String email, String password) {
        this.setEmailTextBox().sendKeys(email);
        this.setPasswordTextBox().sendKeys(password);
        this.setLoginButton().click();
    }
}
