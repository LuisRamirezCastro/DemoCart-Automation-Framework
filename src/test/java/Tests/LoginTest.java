package Tests;

//import io.qameta.allure.*;
//import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

        import PageObjects.loginPage;
import PageObjects.accountPage;

//import DataProviders.usersDataProvider;
//import pojo.loginData;

import utilities.waits;
import utilities.emailAddressUtilities;

/*
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
*/

public class LoginTest extends baseTest{

    // Constructor

    LoginTest(){
        super("chrome");
    }

    /*
    @Test(groups = {"sanity"}, dataProvider = "getUsersDataFromJson", dataProviderClass = usersDataProvider.class, description = "User is allowed to do login and go to account dashboard")
    @Description("User is allowed to do login and go to account dashboard")
    public void doLogin(loginData _loginData) throws InterruptedException {
    */

    //@Test
    public void doLogin() throws InterruptedException {

        loginPage login = new loginPage(driver, getBaseURL());
        waits wait = new waits(driver);
        emailAddressUtilities emailGenerator = new emailAddressUtilities();

        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));
        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));
        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));
        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));
        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));
        System.out.println(emailGenerator.gerRandomEmailAddress("Luis", "Ramirez"));

        accountPage dashboard = new accountPage(driver);

        login.goToPage();
        login.doLogin("luisram@mail.com", "Password.1");
        wait.untilElementExists(dashboard.setAccountContainer());
        Assert.assertEquals(dashboard.setAccountContainer().isDisplayed(), true);
        System.out.println("Completed Login Test");
    }
}
