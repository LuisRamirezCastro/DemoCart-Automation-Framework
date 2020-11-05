package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.registerPage;
import PageObjects.registerPageSuccess;
import PageObjects.accountPage;

import DataProviders.registrationUsersDataProvider;
import pojo.registrationUserData;

import utilities.waits;
import utilities.emailAddressUtilities;

public class RegisterTest extends baseTest{

    // Constructor
    RegisterTest(){
        super("chrome");
    }


    @Test(enabled=true, groups = {"sanity"}, dataProvider = "getRegistrationUsersDataFromJson", dataProviderClass = registrationUsersDataProvider.class, description = "Test Case #1 - Web site allows new user registration.")
    public void doRegister(registrationUserData _registrationUserData) throws InterruptedException {
        System.out.println("Test Case #1 - Web site allows new user registration.");

        // Page Objects
        registerPage register = new registerPage(driver, getBaseURL());
        registerPageSuccess registerSuccess = new registerPageSuccess(driver);
        accountPage account = new accountPage(driver, getBaseURL());
        // Utilities
        waits wait = new waits(driver);
        emailAddressUtilities emailAddressUtility = new emailAddressUtilities();

        register.goToPage();
        // Retrieves current new user from list and generates a random email address
        register.doRegister(
                _registrationUserData.getFirstName(),
                _registrationUserData.getLastName(),
                emailAddressUtility.gerRandomEmailAddress(_registrationUserData.getFirstName(), _registrationUserData.getLastName()),
                _registrationUserData.getTelephone(),
                _registrationUserData.getPassword());

        // Assert new user was registered correctly
        wait.untilElementExists(registerSuccess.setAccountSuccess());
        // Validates the registration process is successful
        Assert.assertEquals(registerSuccess.setAccountSuccess().isDisplayed(), true);
        System.out.println("New user registration was successful.");

        // Assert new user is logged in
        account.goToPage();
        wait.untilElementExists(account.setAccountContainer());
        // Validates new user can access Account page
        Assert.assertEquals(account.setAccountContainer().isDisplayed(), true);
        System.out.println("New user can access 'Acount' page. User is logged in.");
    }
}
