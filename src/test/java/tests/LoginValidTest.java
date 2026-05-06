package tests;

import modelObject.LoginModel;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class LoginValidTest extends SharedData {

    @Test(groups = {"SmokeSuite", "RegressionSuite"})
    public void metodaTest() {

        RegisterModel registerData = new RegisterModel("RegisterData.json");
        LoginPage loginPage = new LoginPage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, registerData);

        loginPage.clickLogOut();
        loginPage.loginValidProcess(usernameValue, registerData.getPassword());

        String logOutAfterLoginText = loginPage.getLogOutText();
        Assert.assertEquals(logOutAfterLoginText, "Log Out", "Login was not successful.");
    }
}