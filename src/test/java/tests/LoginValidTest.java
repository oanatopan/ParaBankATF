package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class LoginValidTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        String passwordValue = "Parola123!";
        registerPage.registerProcess(usernameValue);

        loginPage.clickLogOut();
        loginPage.loginValidProcess(usernameValue, passwordValue);

        String logOutAfterLoginText = loginPage.getLogOutText();
        Assert.assertEquals(logOutAfterLoginText, "Log Out", "Login was not successful.");
    }
}