package tests;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountActivityPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.RegisterPage;

import java.time.Duration;

public class FindTransactionsTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    SelectMethods selectMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        selectMethods = new SelectMethods(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        accountServicesPage.clickAccountsOverview();
        System.out.println("STEP 5: The Accounts Overview page is opened.");

        accountsOverviewPage.clickFirstAccount();
        System.out.println("STEP 6: The first account link is clicked.");

        accountActivityPage.filterProcess();
        System.out.println("STEP 7: The Account Activity filters are applied.");

        String actualTitle = accountActivityPage.getActivityTitle();
        System.out.println("STEP 8: The Account Activity page title is captured.");

        Assert.assertEquals(actualTitle, "Account Activity", "Account Activity title is not correct.");
        System.out.println("STEP 9: The Account Activity title is validated.");

        boolean isRightPanelDisplayed = accountActivityPage.isRightPanelDisplayed();
        System.out.println("STEP 10: The Account Activity right panel visibility is checked.");

        Assert.assertTrue(isRightPanelDisplayed, "Account Activity page did not load correctly.");
        System.out.println("STEP 11: The Account Activity page content is validated.");

        driver.quit();
        System.out.println("STEP 12: The browser is closed.");
    }
}