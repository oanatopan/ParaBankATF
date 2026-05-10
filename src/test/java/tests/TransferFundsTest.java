package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.OpenAccountModel;
import modelObject.TransferFundsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import pages.TransferFundsPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@TransferFundsTest")
public class TransferFundsTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        OpenAccountModel openAccountData = new OpenAccountModel("OpenAccountData.json");
        TransferFundsModel transferData = new TransferFundsModel("TransferFundsData.json");
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        OpenAccountPage openAccountPage = new OpenAccountPage(getDriver());
        TransferFundsPage transferFundsPage = new TransferFundsPage(getDriver());

        accountServicesPage.clickOpenNewAccount();

        String fromAccountOptionValue = openAccountPage.getFromAccountOptionText();
        Assert.assertFalse(fromAccountOptionValue.isEmpty(), "The From Account dropdown is not populated.");

        openAccountPage.openAccountProcess(openAccountData);

        String actualNewAccountId = openAccountPage.getNewAccountId();
        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");

        accountServicesPage.clickTransferFunds();
        transferFundsPage.transferProcess(transferData);

        String actualResult = transferFundsPage.getTransferResult();
        Assert.assertTrue(actualResult.contains(transferData.getSuccessMessage()), "The transfer confirmation message did not appear.");
    }
}