package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

@Feature("@Authentication ")
@Story("@LoginValidTest")
public class LoginValidTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        String logOutAfterLoginText = loginPage.getLogOutText();
        Assert.assertEquals(logOutAfterLoginText, "Log Out", "Login was not successful.");
    }
}