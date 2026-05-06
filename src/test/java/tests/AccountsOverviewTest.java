package tests;

import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class AccountsOverviewTest extends SharedData {

    @Test(groups = {"RegressionSuite"})
    public void metodaTest() {

        RegisterModel testData = new RegisterModel("RegisterData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();        registerPage.registerProcess(usernameValue, testData);

        String registrationError = registerPage.getRegistrationError();
        if (!registrationError.isEmpty()) {
            Assert.fail("ERROR: Registration failed: " + registrationError);
        }

        accountServicesPage.clickAccountsOverview();

        String accountTableText = accountsOverviewPage.getAccountTableText();
        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
    }
}