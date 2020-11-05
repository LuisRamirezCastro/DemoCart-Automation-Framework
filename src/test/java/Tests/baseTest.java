package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

    public WebDriver driver;
    public ChromeOptions chromeOptions;
    private String browser;

    // Constructor
    public baseTest(String browser){
        this.browser = browser;
    }

    // Methods
    public String getBaseURL() {
        return "https://demo.opencart.com/";
    }

    // Test Configurations
    @BeforeMethod(alwaysRun = true)
    public void setUpTest(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1440,900");
        this.setWebDriverConfiguration(browser, chromeOptions);
        System.out.println("\n--- Test Setup --------------------------------");
    }

    // Driver Closing
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        System.out.println("--- Teardown ---------------------------------\n\n");
    }

    // Sets the corresponding driver binary according to settings
    private void setWebDriverConfiguration(String browser, ChromeOptions options) {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }
}
