package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class RequestLoanTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickRequestLoan();
        System.out.println("STEP 2: The Request Loan page is opened.");

        requestLoanPage.loanProcess();
        System.out.println("STEP 3: The Request Loan form is completed and submitted.");

        String actualLoanStatus = requestLoanPage.getLoanStatus();
        System.out.println("STEP 4: The loan application status is captured: " + actualLoanStatus);

        Assert.assertTrue(actualLoanStatus.equals("Approved") || actualLoanStatus.equals("Denied"),
                "Loan status is not Approved or Denied. Actual status: " + actualLoanStatus);
        System.out.println("STEP 5: The loan application result is validated.");
    }
}