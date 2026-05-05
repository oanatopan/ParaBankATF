package tests;

import modelObject.OpenAccountModel;
import modelObject.RegisterModel;
import modelObject.TransferFundsModel;
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

        RegisterModel registerData = new RegisterModel("RegisterData.json");
        OpenAccountModel openAccountData = new OpenAccountModel("OpenAccountData.json");
        TransferFundsModel transferData = new TransferFundsModel("TransferFundsData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());
        TransferFundsPage transferFundsPage = new TransferFundsPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue, registerData);

        accountServicesPage.clickOpenNewAccount();

        String fromAccountOptionValue = openAccountPage.getFromAccountOptionText();
        Assert.assertFalse(fromAccountOptionValue.isEmpty(), "The From Account dropdown is not populated.");

        openAccountPage.openAccountProcess(openAccountData);

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");

        accountServicesPage.clickTransferFunds();
        transferFundsPage.transferProcess(transferData);

        String actualResult = transferFundsPage.getTransferResult();
        Assert.assertTrue(actualResult.contains(transferData.getSuccessMessage()),
                "The transfer confirmation message did not appear.");
    }
}