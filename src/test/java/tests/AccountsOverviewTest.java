package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;
import sharedData.SharedData;

@Feature("@Account Management ")
@Story("@AccountsOverviewTest")
public class AccountsOverviewTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        RegisterModel testData = new RegisterModel("RegisterData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, testData);

        String registrationError = registerPage.getRegistrationError();
        if (!registrationError.isEmpty()) {
            Assert.fail("ERROR: Registration failed: " + registrationError);
        }

        accountServicesPage.clickAccountsOverview();

        String accountTableText = accountsOverviewPage.getAccountTableText();
        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
    }
}