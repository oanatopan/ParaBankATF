package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.RegisterPage;
import pages.RequestLoanPage;

import java.time.Duration;

public class RequestLoanTest {

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
        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        accountServicesPage.clickRequestLoan();
        System.out.println("STEP 5: The Request Loan page is opened.");

        requestLoanPage.loanProcess();
        System.out.println("STEP 6: The Request Loan form is completed and submitted.");

        String actualLoanStatus = requestLoanPage.getLoanStatus();
        System.out.println("STEP 7: The loan application status is captured: " + actualLoanStatus);

        Assert.assertTrue(actualLoanStatus.equals("Approved") || actualLoanStatus.equals("Denied"),
                "Loan status is not Approved or Denied. Actual status: " + actualLoanStatus);
        System.out.println("STEP 8: The loan application result is validated.");

        driver.quit();
        System.out.println("STEP 9: The browser is closed.");
    }
}