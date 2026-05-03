package tests;

import helpMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;

public class AccountHistoryTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.manage().deleteAllCookies();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        String successMessageText = registerPage.getSuccessMessage();
        System.out.println("STEP 5: The registration success message is captured: " + successMessageText);

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 6: The Accounts Overview page is opened.");

        accountsOverviewPage.clickFirstAccount();
        System.out.println("STEP 7: The first account link is clicked.");

        String actualPageTitle = accountDetailsPage.getPageTitle();
        System.out.println("STEP 8: The Account Details page title is captured.");

        Assert.assertTrue(actualPageTitle.contains("Account Details"), "The Account Details page was not loaded.");
        System.out.println("STEP 9: The Account Details page is validated.");

        driver.quit();
        System.out.println("STEP 10: The browser is closed.");
    }
}