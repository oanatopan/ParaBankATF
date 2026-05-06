package tests;

import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import sharedData.SharedData;

public class RegisterTest extends SharedData {

    @Test(groups = {"SmokeSuite", "RegressionSuite"})
    public void metodaTest() {

        RegisterModel testData = new RegisterModel("RegisterData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, testData);

        String actualSuccessMessage = registerPage.getSuccessMessage();
        Assert.assertTrue(actualSuccessMessage.contains("Your account was created successfully. You are now logged in."),
                "Register success message is not correct.");
    }
}