package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class OpenAccountTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickOpenNewAccount();
        openAccountPage.openAccountProcess();

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");
    }
}