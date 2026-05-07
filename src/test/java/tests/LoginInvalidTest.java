package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.SharedData;

@Feature("@Authentication ")
@Story("@LoginInvalidTest")
public class LoginInvalidTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        LoginModel testData = new LoginModel("LoginData.json");

        getDriver().get("https://parabank.parasoft.com/parabank/index.htm");

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.loginInvalidProcess(testData);

        String actualErrorTitle = loginPage.getErrorTitle();
        Assert.assertFalse(actualErrorTitle.isEmpty(), "Error page was not displayed.");
    }
}