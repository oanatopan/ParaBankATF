package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AccountHistoryTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        String successMessageText = registerPage.getSuccessMessage();
        System.out.println("STEP 2: The registration success message is captured: " + successMessageText);

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 3: The Accounts Overview page is opened.");

        accountsOverviewPage.clickFirstAccount();
        System.out.println("STEP 4: The first account link is clicked.");

        String actualPageTitle = accountDetailsPage.getPageTitle();
        System.out.println("STEP 5: The Account Details page title is captured.");

        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
        System.out.println("STEP 6: The Account Details page is validated.");
    }
}