package tests;

import dataBase.DataBaseQueries;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import sharedData.SharedData;

@Feature("@Authentication ")
@Story("@RegisterTest")
public class RegisterTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        DataBaseQueries db = new DataBaseQueries();
        RegisterModel testData = db.getRegisterData();
        RegisterPage registerPage = new RegisterPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, testData);

        String actualSuccessMessage = registerPage.getSuccessMessage();
        Assert.assertTrue(actualSuccessMessage.contains("Your account was created successfully. You are now logged in."),
                "Register success message is not correct.");
    }
}

