package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waits {

    public WebDriver driver;

    public waits(WebDriver driver) {
        this.driver = driver;
    }

    public void untilElementExists(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicitWait(int millis) throws InterruptedException{
        Thread.sleep(millis);
    }
}
