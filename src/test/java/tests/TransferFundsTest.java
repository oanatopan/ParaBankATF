package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class TransferFundsTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickOpenNewAccount();
        System.out.println("STEP 2: The Open New Account page is opened.");

        String fromAccountOptionValue = openAccountPage.getFromAccountOptionText();
        System.out.println("STEP 3: The From Account dropdown is loaded with: " + fromAccountOptionValue);

        openAccountPage.openAccountProcess();
        System.out.println("STEP 4: The second account is created.");

        String actualNewAccountId = openAccountPage.getNewAccountId();
        System.out.println("STEP 5: The new account ID is confirmed: " + actualNewAccountId);

        accountServicesPage.clickTransferFunds();
        System.out.println("STEP 6: The Transfer Funds page is opened.");

        transferFundsPage.transferProcess();
        System.out.println("STEP 7: The Transfer form is completed and submitted.");

        String actualResult = transferFundsPage.getTransferResult();
        System.out.println("STEP 8: The transfer result is captured.");

        Assert.assertTrue(actualResult.contains("Transfer Complete"),
                "The transfer confirmation message did not appear.");
        System.out.println("STEP 9: The transfer result is validated.");
    }
}