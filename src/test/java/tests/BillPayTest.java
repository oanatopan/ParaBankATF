package tests;

import modelObject.BillPayModel;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.BillPayPage;
import pages.RegisterPage;
import sharedData.SharedData;

public class BillPayTest extends SharedData {

    @Test(groups = {"RegressionSuite"})
    public void metodaTest() {

        RegisterModel registerData = new RegisterModel("RegisterData.json");
        BillPayModel billPayData = new BillPayModel("BillPayData.json");
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        BillPayPage billPayPage = new BillPayPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis();
        registerPage.registerProcess(usernameValue, registerData);

        accountServicesPage.clickBillPay();
        billPayPage.billPayProcess(billPayData);

        String actualBillPayResult = billPayPage.getBillPayResult();
        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"),
                "The payment was not completed.");
    }
}