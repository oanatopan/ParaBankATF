package tests;

import modelObject.RegisterModel;
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

        RegisterModel testData = new RegisterModel("RegisterData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue, testData);

        String successMessageText = registerPage.getSuccessMessage();
        Assert.assertFalse(successMessageText.isEmpty(), "Registration success message was not displayed.");

        accountServicesPage.clickAccountsOverview();
        accountsOverviewPage.clickFirstAccount();

        String actualPageTitle = accountDetailsPage.getPageTitle();
        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
    }
}