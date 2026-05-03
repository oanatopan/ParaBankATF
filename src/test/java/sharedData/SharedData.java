package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountActivityPage;
import pages.AccountDetailsPage;
import pages.AccountServicesPage;
import pages.AccountsOverviewPage;
import pages.BillPayPage;
import pages.LoginPage;
import pages.OpenAccountPage;
import pages.RegisterPage;
import pages.RequestLoanPage;
import pages.TransferFundsPage;

import java.time.Duration;

public class SharedData {

    protected WebDriver driver;

    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected AccountServicesPage accountServicesPage;
    protected AccountsOverviewPage accountsOverviewPage;
    protected AccountDetailsPage accountDetailsPage;
    protected AccountActivityPage accountActivityPage;
    protected OpenAccountPage openAccountPage;
    protected TransferFundsPage transferFundsPage;
    protected BillPayPage billPayPage;
    protected RequestLoanPage requestLoanPage;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {
        driver = new ChromeDriver();
        System.out.println(" The browser is opened.");

        driver.manage().window().maximize();
        System.out.println(" The browser is maximized.");

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        accountServicesPage = new AccountServicesPage(driver);
        accountsOverviewPage = new AccountsOverviewPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        accountActivityPage = new AccountActivityPage(driver);
        openAccountPage = new OpenAccountPage(driver);
        transferFundsPage = new TransferFundsPage(driver);
        billPayPage = new BillPayPage(driver);
        requestLoanPage = new RequestLoanPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment() {
        if (driver != null) {
            driver.quit();
            System.out.println("The browser is closed.");
        }
    }
}