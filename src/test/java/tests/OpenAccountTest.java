package tests;

import modelObject.OpenAccountModel;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class OpenAccountTest extends SharedData {

    @Test(groups = {"SmokeSuite", "RegressionSuite"})
    public void metodaTest() {

        RegisterModel registerData = new RegisterModel("RegisterData.json");
        OpenAccountModel openAccountData = new OpenAccountModel("OpenAccountData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, registerData);

        accountServicesPage.clickOpenNewAccount();
        openAccountPage.openAccountProcess(openAccountData);

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");
    }
}