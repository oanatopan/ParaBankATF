package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.LoginPage;
import pages.RegisterPage;
import sharedData.SharedData;

@Feature("@Authentication ")
@Story("@LogOutTest")
public class LogOutTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        RegisterModel testData = new RegisterModel("RegisterData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, testData);

        accountServicesPage.clickLogOut();

        String loginButtonValue = loginPage.getLoginButtonValue();
        Assert.assertEquals(loginButtonValue, "Log In", "The Log In button is not displayed after logout.");
    }
}