package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;

public class AccountsOverviewTest {

    public WebDriver driver;


    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        String registrationError = registerPage.getRegistrationError();
        if (!registrationError.isEmpty()) {
            Assert.fail("ERROR: Registration failed: " + registrationError);
        }
        System.out.println("STEP 5: The registration is verified to have no errors.");

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 6: The Accounts Overview page is opened.");

        String accountTableText = accountsOverviewPage.getAccountTableText();
        System.out.println("STEP 7: The account table content is captured.");

        Assert.assertFalse(accountTableText.isEmpty(), "ERROR: Account table is NOT displayed.");
        System.out.println("STEP 8: The account table is validated.");

        driver.quit();
        System.out.println("STEP 9: The browser is closed.");
    }
}