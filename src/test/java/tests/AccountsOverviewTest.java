package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AccountsOverviewTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        String registrationError = registerPage.getRegistrationError();
        if (!registrationError.isEmpty()) {
            Assert.fail("ERROR: Registration failed: " + registrationError);
        }
        System.out.println("STEP 2: The registration is verified to have no errors.");

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 3: The Accounts Overview page is opened.");

        String accountTableText = accountsOverviewPage.getAccountTableText();
        System.out.println("STEP 4: The account table content is captured.");

        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
        System.out.println("STEP 5: The account table is validated.");
    }
}