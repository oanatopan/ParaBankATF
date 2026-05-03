package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class BillPayTest extends SharedData {

    @Test
    public void metodaTest() {

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);
        System.out.println("STEP 1: The Register form is completed and submitted.");

        accountServicesPage.clickBillPay();
        System.out.println("STEP 2: The Bill Pay page is opened.");

        billPayPage.billPayProcess();
        System.out.println("STEP 3: The Bill Pay form is completed and submitted.");

        String actualBillPayResult = billPayPage.getBillPayResult();
        System.out.println("STEP 4: The Bill Pay result is captured.");

        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"),
                "The payment was not completed.");
        System.out.println("STEP 5: The Bill Pay result is validated.");
    }
}