package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.BillPayPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class BillPayTest extends SharedData {

    @Test
    public void metodaTest() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        BillPayPage billPayPage = new BillPayPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue);

        accountServicesPage.clickBillPay();
        billPayPage.billPayProcess();

        String actualBillPayResult = billPayPage.getBillPayResult();
        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"),
                "The payment was not completed.");
    }
}