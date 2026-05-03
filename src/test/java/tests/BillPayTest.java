package tests;

import helpMethods.ElementsMethods;
import helpMethods.SelectMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.BillPayPage;
import pages.RegisterPage;

public class BillPayTest {

    public WebDriver driver;
    ElementsMethods elementsMethods;
    SelectMethods selectMethods;

    @Test
    public void metodaTest() {

        driver = new ChromeDriver();
        System.out.println("STEP 1: The browser is opened.");
        driver.manage().window().maximize();
        System.out.println("STEP 2: The browser is maximized.");
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("STEP 3: The Register page is opened.");

        elementsMethods = new ElementsMethods(driver);
        selectMethods = new SelectMethods(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
        BillPayPage billPayPage = new BillPayPage(driver);

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 4: The Register form is completed and submitted.");

        accountServicesPage.clickBillPay();
        System.out.println("STEP 5: The Bill Pay page is opened.");

        billPayPage.billPayProcess();
        System.out.println("STEP 6: The Bill Pay form is completed and submitted.");

        String actualBillPayResult = billPayPage.getBillPayResult();
        System.out.println("STEP 7: The Bill Pay result is captured.");

        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"),
                "The payment was not completed.");
        System.out.println("STEP 8: The Bill Pay result is validated.");

        driver.quit();
        System.out.println("STEP 9: The browser is closed.");
    }
}