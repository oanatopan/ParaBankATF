package tests;

import dataBase.DataBaseQueries;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.BillPayModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.BillPayPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@BillPayTest")
public class BillPayTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        DataBaseQueries db = new DataBaseQueries();
        BillPayModel billPayData = db.getBillPayData();
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        BillPayPage billPayPage = new BillPayPage(getDriver());

        accountServicesPage.clickBillPay();
        billPayPage.billPayProcess(billPayData);

        String actualBillPayResult = billPayPage.getBillPayResult();
        Assert.assertTrue(actualBillPayResult.toLowerCase().contains("bill payment complete"), "The payment was not completed.");
    }
}