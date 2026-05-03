package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class LoginInvalidTest extends SharedData {

    @Test
    public void metodaTest() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println("STEP 1: The Login page is opened.");
        System.out.println("STEP 1: The Login page is opened.");

        loginPage.loginInvalidProcess();
        System.out.println("STEP 2: The invalid login form is completed and submitted.");

        String actualErrorTitle = loginPage.getErrorTitle();
        System.out.println("STEP 3: The error title is captured.");

        Assert.assertFalse(actualErrorTitle.isEmpty(), "Error page was not displayed.");
        System.out.println("STEP 4: The invalid login error is validated.");
    }
}