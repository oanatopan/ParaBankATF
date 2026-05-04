package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class AccountsOverviewTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        String registrationError = registerPage.getRegistrationError();
        if (!registrationError.isEmpty()) {
            Assert.fail("ERROR: Registration failed: " + registrationError);
        }

        accountServicesPage.clickAccountsOverview();

        String accountTableText = accountsOverviewPage.getAccountTableText();
        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
    }
}