package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

public class LoginInvalidTest extends SharedData {

    @Test
    public void metodaTest() {

        getDriver().get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginInvalidProcess();

        String actualErrorTitle = loginPage.getErrorTitle();
        Assert.assertFalse(actualErrorTitle.isEmpty(), "Error page was not displayed.");
    }
}