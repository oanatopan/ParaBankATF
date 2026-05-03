package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class LoginValidTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        String passwordValue = "Parola123!";
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        loginPage.clickLogOut();
        System.out.println("STEP 2: The Log Out link is clicked.");

        loginPage.loginValidProcess(usernameValue, passwordValue);
        System.out.println("STEP 3: The login form is completed and submitted.");

        String logOutAfterLoginText = loginPage.getLogOutText();
        System.out.println("STEP 4: The Log Out link text is captured.");

        Assert.assertEquals(logOutAfterLoginText, "Log Out", "Login was not successful.");
        System.out.println("STEP 5: The valid login is validated.");
    }
}