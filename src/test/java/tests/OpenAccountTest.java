package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class OpenAccountTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickOpenNewAccount();
        System.out.println("STEP 2: The Open New Account page is opened.");

        openAccountPage.openAccountProcess();
        System.out.println("STEP 3: The Open New Account form is completed and submitted.");

        String actualNewAccountId = openAccountPage.getNewAccountId();
        System.out.println("STEP 4: The new account ID is captured.");

        Assert.assertFalse(actualNewAccountId.isEmpty(), "The new account ID was not generated.");
        System.out.println("STEP 5: The new account creation is validated.");
    }
}