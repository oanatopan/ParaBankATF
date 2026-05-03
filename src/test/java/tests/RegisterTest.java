package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class RegisterTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        String actualSuccessMessage = registerPage.getSuccessMessage();
        System.out.println("STEP 2: The Register success message is captured.");

        Assert.assertTrue(actualSuccessMessage.contains("Your account was created successfully. You are now logged in."),
                "Register success message is not correct.");
        System.out.println("STEP 3: The Register success message is validated.");
    }
}