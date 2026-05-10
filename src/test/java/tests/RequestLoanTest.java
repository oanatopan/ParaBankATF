package tests;

import dataBase.DataBaseQueries;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import modelObject.RequestLoanModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountServicesPage;
import pages.RequestLoanPage;
import sharedData.SharedData;

@Feature("@Transactions")
@Story("@RequestLoanTest")
public class RequestLoanTest extends SharedData {

    @Test(groups = {SuiteType.SMOKE_SUITE, SuiteType.REGRESSION_SUITE})
    public void metodaTest() {

        DataBaseQueries db = new DataBaseQueries();
        RequestLoanModel loanData = db.getLoanData();
        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());
        RequestLoanPage requestLoanPage = new RequestLoanPage(getDriver());

        accountServicesPage.clickRequestLoan();
        requestLoanPage.loanProcess(loanData);

        String actualLoanStatus = requestLoanPage.getLoanStatus();
        Assert.assertTrue(actualLoanStatus.equals(loanData.getApprovedStatus()) || actualLoanStatus.equals(loanData.getDeniedStatus()), "Loan status is not Approved or Denied. Actual status: " + actualLoanStatus);
    }
}