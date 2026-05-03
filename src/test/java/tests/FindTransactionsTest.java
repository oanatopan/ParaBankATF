package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FindTransactionsTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 2: The Accounts Overview page is opened.");

        accountsOverviewPage.clickFirstAccount();
        System.out.println("STEP 3: The first account link is clicked.");

        accountActivityPage.filterProcess();
        System.out.println("STEP 4: The Account Activity filters are applied.");

        String actualTitle = accountActivityPage.getActivityTitle();
        System.out.println("STEP 5: The Account Activity page title is captured.");

        Assert.assertEquals(actualTitle, "Account Activity", "Account Activity title is not correct.");
        System.out.println("STEP 6: The Account Activity title is validated.");

        boolean isRightPanelDisplayed = accountActivityPage.isRightPanelDisplayed();
        System.out.println("STEP 7: The Account Activity right panel visibility is checked.");

        Assert.assertTrue(isRightPanelDisplayed, "Account Activity page did not load correctly.");
        System.out.println("STEP 8: The Account Activity page content is validated.");
    }
}