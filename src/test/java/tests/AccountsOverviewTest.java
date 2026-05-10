package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import sharedData.SharedData;

@Feature("@Account Management ")
@Story("@AccountsOverviewTest")
public class AccountsOverviewTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());

        accountServicesPage.clickAccountsOverview();

        String accountTableText = accountsOverviewPage.getAccountTableText();
        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
    }
}