package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import sharedData.SharedData;

public class RegisterTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        String actualSuccessMessage = registerPage.getSuccessMessage();
        Assert.assertTrue(actualSuccessMessage.contains("Your account was created successfully. You are now logged in."),
                "Register success message is not correct.");
    }
}