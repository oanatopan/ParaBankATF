package tests;

import dataBase.DataBaseQueries;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.BillPayModel;
import modelObject.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.BillPayPage;
import pages.RegisterPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@BillPayTest")
public class BillPayTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        DataBaseQueries db = new DataBaseQueries();
        RegisterModel registerData = db.getRegisterData();
        BillPayModel billPayData = db.getBillPayData();
        RegisterPage registerPage = new RegisterPage(getDriver());
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        BillPayPage billPayPage = new BillPayPage(getDriver());

        String usernameValue = "oana" + System.currentTimeMillis() + Thread.currentThread().getId();
        registerPage.registerProcess(usernameValue, registerData);

        accountServicesPage.clickBillPay();
        billPayPage.billPayProcess(billPayData);

        String actualBillPayResult = billPayPage.getBillPayResult();
        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"), "The payment was not completed.");
    }
}