package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.RegisterPage;
import pages.RequestLoanPage;
import sharedData.SharedData;

public class RequestLoanTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        RequestLoanPage requestLoanPage = new RequestLoanPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickRequestLoan();
        requestLoanPage.loanProcess();

        String actualLoanStatus = requestLoanPage.getLoanStatus();
        Assert.assertTrue(actualLoanStatus.equals("Approved") || actualLoanStatus.equals("Denied"),
                "Loan status is not Approved or Denied. Actual status: " + actualLoanStatus);
    }
}