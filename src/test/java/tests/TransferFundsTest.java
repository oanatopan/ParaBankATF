package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.OpenAccountPage;
import pages.RegisterPage;
import pages.TransferFundsPage;

import java.time.Duration;

public class TransferFundsTest {

    public WebDriver driver;

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

        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        accountServicesPage.clickOpenNewAccount();
        System.out.println("STEP 5: The Open New Account page is opened.");

        String fromAccountOptionValue = openAccountPage.getFromAccountOptionText();
        System.out.println("STEP 6: The From Account dropdown is loaded with: " + fromAccountOptionValue);

        openAccountPage.openAccountProcess();
        System.out.println("STEP 7: The second account is created.");

        String actualNewAccountId = openAccountPage.getNewAccountId();
        System.out.println("STEP 8: The new account ID is confirmed: " + actualNewAccountId);

        accountServicesPage.clickTransferFunds();
        System.out.println("STEP 9: The Transfer Funds page is opened.");

        transferFundsPage.transferProcess();
        System.out.println("STEP 10: The Transfer form is completed and submitted.");

        String actualResult = transferFundsPage.getTransferResult();
        System.out.println("STEP 11: The transfer result is captured.");

        Assert.assertTrue(actualResult.contains("Transfer Complete"),
                "The transfer confirmation message did not appear.");
        System.out.println("STEP 12: The transfer result is validated.");

        driver.quit();
        System.out.println("STEP 13: The browser is closed.");
    }
}