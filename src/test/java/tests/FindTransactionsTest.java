package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountActivityPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class FindTransactionsTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());
        AccountActivityPage accountActivityPage = new AccountActivityPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickAccountsOverview();
        accountsOverviewPage.clickFirstAccount();
        accountActivityPage.filterProcess();

        String actualTitle = accountActivityPage.getActivityTitle();
        Assert.assertEquals(actualTitle, "Account Activity", "Account Activity title is not correct.");

        boolean isRightPanelDisplayed = accountActivityPage.isRightPanelDisplayed();
        Assert.assertTrue(isRightPanelDisplayed, "Account Activity page did not load correctly.");
    }
}