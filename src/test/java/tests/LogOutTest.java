package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class LogOutTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickLogOut();
        System.out.println("STEP 2: The Log Out link is clicked.");

        String loginButtonValue = loginPage.getLoginButtonValue();
        System.out.println("STEP 3: The Log In button value is captured.");

        Assert.assertEquals(loginButtonValue, "Log In", "The Log In button is not displayed after logout.");
        System.out.println("STEP 4: The logout is validated.");
    }
}