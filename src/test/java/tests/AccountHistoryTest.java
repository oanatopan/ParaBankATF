package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import sharedData.SharedData;

@Feature("@Account Management ")
@Story("@AccountHistoryTest")
public class AccountHistoryTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(getDriver());

        accountServicesPage.clickAccountsOverview();
        accountsOverviewPage.clickFirstAccount();

        String actualPageTitle = accountDetailsPage.getPageTitle();
        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
    }
}