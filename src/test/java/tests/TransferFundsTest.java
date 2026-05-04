package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import pages.RegisterPage;
import pages.TransferFundsPage;
import sharedData.SharedData;

public class TransferFundsTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());
        TransferFundsPage transferFundsPage = new TransferFundsPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickOpenNewAccount();

        String fromAccountOptionValue = openAccountPage.getFromAccountOptionText();
        Assert.assertFalse(fromAccountOptionValue.isEmpty(), "The From Account dropdown is not populated.");

        openAccountPage.openAccountProcess();

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");

        accountServicesPage.clickTransferFunds();
        transferFundsPage.transferProcess();

        String actualResult = transferFundsPage.getTransferResult();
        Assert.assertTrue(actualResult.contains("Transfer Complete"),
                "The transfer confirmation message did not appear.");
    }
}