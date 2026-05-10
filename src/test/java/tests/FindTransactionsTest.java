package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.FindTransactionsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountActivityPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@FindTransactionsTest")
public class FindTransactionsTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        FindTransactionsModel findData = new FindTransactionsModel("FindTransactionsData.json");
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());
        AccountActivityPage accountActivityPage = new AccountActivityPage(getDriver());

        accountServicesPage.clickAccountsOverview();
        accountsOverviewPage.clickFirstAccount();
        accountActivityPage.filterProcess(findData);

        String actualTitle = accountActivityPage.getActivityTitle();
        Assert.assertEquals(actualTitle, findData.getExpectedTitle(), "Account Activity title is not correct.");

        boolean isRightPanelDisplayed = accountActivityPage.isRightPanelDisplayed();
        Assert.assertTrue(isRightPanelDisplayed, "Account Activity page did not load correctly.");
    }
}