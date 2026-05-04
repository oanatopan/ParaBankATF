package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class AccountHistoryTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickAccountsOverview();
        accountsOverviewPage.clickFirstAccount();

        String actualPageTitle = accountDetailsPage.getPageTitle();
        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
    }
}