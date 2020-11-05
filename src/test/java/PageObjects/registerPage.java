package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class registerPage extends basePage{

    // Register Page Locators
    private By registerContainer = By.id("account-register");

    private By firstNameTextBox = By.id("input-firstname");
    private By lastNameTextBox = By.id("input-lastname");
    private By emailTextBox = By.id("input-email");
    private By telephoneTextBox = By.id("input-telephone");
    private By passwordTextBox = By.id("input-password");
    private By passwordConfirmTextBox = By.id("input-confirm");

    private By privacyPolicyCheckBox = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");

    // Constructors
    public registerPage(WebDriver driver) {
        super(driver);
    }
    public registerPage(WebDriver driver, String url){
        super(driver, url + "index.php?route=account/register");
    }

    // Methods
    public WebElement setFirstNameTextBox() {
        return driver.findElement(this.firstNameTextBox);
    }
    public WebElement setLastNameTextBox() {
        return driver.findElement(this.lastNameTextBox);
    }
    public WebElement setEmailTextBox() {
        return driver.findElement(this.emailTextBox);
    }
    public WebElement setTelephoneTextBox() {
        return driver.findElement(this.telephoneTextBox);
    }
    public WebElement setPasswordTextBox() {
        return driver.findElement(this.passwordTextBox);
    }
    public WebElement setPasswordConfirmTextBox() {
        return driver.findElement(this.passwordConfirmTextBox);
    }
    public WebElement setPrivacyPolicyCheckBox() {
        return driver.findElement(this.privacyPolicyCheckBox);
    }
    public WebElement setContinueButton() {
        return driver.findElement(this.continueButton);
    }

    public void doRegister(String firstName, String lastName, String email, String telephone, String password) {
        this.setFirstNameTextBox().sendKeys(firstName);
        this.setLastNameTextBox().sendKeys(lastName);
        this.setEmailTextBox().sendKeys(email);
        this.setTelephoneTextBox().sendKeys(telephone);
        this.setPasswordTextBox().sendKeys(password);
        this.setPasswordConfirmTextBox().sendKeys(password);
        // Accept Privacy Policy
        this.setPrivacyPolicyCheckBox().click();
        this.setContinueButton().click();

    }
}
