package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.OpenAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import sharedData.SharedData;

@Feature("@Account Management ")
@Story("@OpenAccountTest")
public class OpenAccountTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        OpenAccountModel openAccountData = new OpenAccountModel("OpenAccountData.json");
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());

        accountServicesPage.clickOpenNewAccount();
        openAccountPage.openAccountProcess(openAccountData);

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");
    }
}