package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.LoginPage;
import pages.RegisterPage;

public class LogOutTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        accountServicesPage.clickLogOut();
        System.out.println("STEP 5: The Log Out link is clicked.");

        String loginButtonValue = loginPage.getLoginButtonValue();
        System.out.println("STEP 6: The Log In button value is captured.");

        Assert.assertEquals(loginButtonValue, "Log In", "The Log In button is not displayed after logout.");
        System.out.println("STEP 7: The logout is validated.");

        driver.quit();
        System.out.println("STEP 8: The browser is closed.");
    }
}